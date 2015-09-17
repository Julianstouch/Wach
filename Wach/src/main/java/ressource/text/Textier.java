package ressource.text;


import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ressource.RandomUtil;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class Textier {

    private static Textier                    instance;

    private static Map<Integer, List<String>> tousNoms;

    /**
     * 
     */
    private Textier() {
    }

    public static Textier getInstance() {
        if (instance == null) {

            instance = new Textier();
            tousNoms = new HashMap<Integer, List<String>>();
            Path path;
            try {

                for (ETXT type : ETXT.values()) {
                    path = Paths.get(instance.getClass().getResource("/text/noms_" + type.getNum() + ".txt").toURI());
                    try (Stream<String> lines = Files.lines(path)) {
                        tousNoms.put(type.getNum(), lines.collect(Collectors.toList()));
                    } catch (Exception e) {
                        System.out.println("No file : " + e.getLocalizedMessage());
                    }
                }
            } catch (URISyntaxException e1) {
                // LOGGER.error("", e1);
            }
        }

        return instance;
    }

    public String getNouveauNom(final ETXT eTxt) {
        int pos = RandomUtil.getRandomIndex(0, tousNoms.get(eTxt.getNum()).size() - 1);
        return tousNoms.get(eTxt.getNum()).get(pos);
    }

}
