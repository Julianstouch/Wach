package ressource.template;


import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import chose.perso.Membre;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class Templier {

    private static Templier   instance;

    private Map<ETMP, Membre> mapTemplate;

    /**
     * 
     */
    private Templier() {
        mapTemplate = new HashMap<ETMP, Membre>();
    }

    public static Templier getInstance() {
        if (instance == null) {
            instance = new Templier();
        }
        return instance;
    }

    public Membre getNouveauMembre(final ETMP eTmp) {
        Membre membre = mapTemplate.get(eTmp);
        if (membre == null) {
            try {
                Properties propMember = new Properties();
                InputStream data = this.getClass().getResourceAsStream("/data/" + eTmp.getNom());
                propMember.load(data);
                membre = new Membre(propMember);
                membre.setNom("John");
                membre.setCamp(1);
                membre.setIdent(1);
                data.close();
                mapTemplate.put(eTmp, membre);

            } catch (Exception e) {
                System.out.println("No image : " + e.getLocalizedMessage());
            }

        }
        return membre;
    }
}
