package ressource.template;


import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import ressource.text.ETXT;
import ressource.text.Textier;
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
            try (InputStream data = this.getClass().getResourceAsStream("/data/" + eTmp.getNom());) {
                Properties propMember = new Properties();
                propMember.load(data);
                membre = new Membre(propMember);
                membre.setNom(Textier.getInstance().getNouveauNom(ETXT.getOne()));
                membre.setCamp(1);
                membre.setIdent(1);
                mapTemplate.put(eTmp, membre);

            } catch (Exception e) {
                System.out.println("No template : " + e.getLocalizedMessage());
            }

        }
        return membre;
    }
}
