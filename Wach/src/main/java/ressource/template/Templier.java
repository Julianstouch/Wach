package ressource.template;


import java.io.InputStream;
import java.io.InputStreamReader;
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
            try (InputStream data = this.getClass().getResourceAsStream("/data/" + eTmp.toString() + ".txt");
                    InputStreamReader isr = new InputStreamReader(data, "UTF-8");) {
                propMember = new Properties();
                propMember.load(isr);
                mapTemplate.put(eTmp, propMember);
            } catch (Exception e) {
                System.out.println("No template : " + e.getLocalizedMessage());
            }
        }
        return propMember;
    }

}
