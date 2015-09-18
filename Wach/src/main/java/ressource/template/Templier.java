package ressource.template;


import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/**
 * Classe de gestion des templates
 *
 * @author
 */
public class Templier {

    private static Templier       instance;

    private Map<ETMP, Properties> mapTemplate;

    /**
     * 
     */
    private Templier() {
        mapTemplate = new HashMap<ETMP, Properties>();
    }

    public static Templier getInstance() {
        if (instance == null) {
            instance = new Templier();
        }
        return instance;
    }

    /**
     * 
     * 
     * @return
     */
    public Properties getRandomTemplate() {
        return getTemplate(ETMP.getRandom());
    }

    public Properties getTemplate(final ETMP eTmp) {
        Properties propMember = mapTemplate.get(eTmp);
        if (propMember == null) {
            try (InputStream data = this.getClass().getResourceAsStream("/data/" + eTmp.getNom());) {
                propMember = new Properties();
                propMember.load(data);
                mapTemplate.put(eTmp, propMember);
            } catch (Exception e) {
                System.out.println("No template : " + e.getLocalizedMessage());
            }
        }
        return propMember;
    }

}
