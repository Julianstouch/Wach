package ressource.visuel;


import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import ressource.Randomier;
import javafx.scene.image.Image;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class Imagier {

    private static Imagier   instance;

    private Map<EIMG, Image> mapImg;
    private Map<String, Image> mapMembre;

    /**
     * 
     */
    private Imagier() {
        mapImg = new HashMap<EIMG, Image>();
        mapMembre = new HashMap<String, Image>();
    }

    public static Imagier getInstance() {
        if (instance == null) {
            instance = new Imagier();
        }
        return instance;
    }

    public Image getImage(final EIMG eImg) {
        Image image = mapImg.get(eImg);
        if (image == null) {
            try {
                InputStream urlImg = this.getClass().getResourceAsStream("/images/" + eImg.getNom());
                image = new Image(urlImg);
                mapImg.put(eImg, image);

            } catch (Exception e) {
                System.out.println("No image : " + e.getLocalizedMessage());
            }

        }
        return image;
    }
    
    public Image getRandomMembre() {
    	int ran = Randomier.getRandomIndex(1, 29);
    	StringBuilder nomC = new StringBuilder(EIMG.membrerandom.getNom());
    	if(ran < 10) {
    		nomC.append("00"+ran+".png");
    	} else {
    		nomC.append("0"+ran+".png");
    	}	
    	String nom = nomC.toString();
        Image image = mapMembre.get(nom);
        if (image == null) {
            try {
                InputStream urlImg = this.getClass().getResourceAsStream("/images/membre/" + nom);
                image = new Image(urlImg);
                mapMembre.put(nom, image);

            } catch (Exception e) {
                System.out.println("No image : " + e.getLocalizedMessage());
            }

        }
        return image;
    }
}
