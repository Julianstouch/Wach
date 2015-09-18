package ressource.membre;


import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import ressource.template.Templier;
import chose.perso.Membre;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class Membrier {

    private static Membrier      instance;

    private Map<Integer, Membre> tousMembre;

    private int                  idSuivant;

    /**
     * 
     */
    private Membrier() {
    }

    public static Membrier getInstance() {
        if (instance == null) {
            instance = new Membrier();
            instance.idSuivant = 1;
            instance.tousMembre = new HashMap<Integer, Membre>();
        }
        return instance;
    }

    public Collection<Membre> getAllMembre() {
        return tousMembre.values();
    }

    public List<Membre> getAllMembreBut(final Membre courrant) {
        return tousMembre.values().stream().filter(e -> e.getIdent() != courrant.getIdent())
                .collect(Collectors.toList());
    }

    /**
     * TODO : write the method's description
     * 
     * @return
     */
    public Membre getNouveauMembre(final int camp) {
        Properties propM = Templier.getInstance().getRandomTemplate();
        Membre newMembre = new Membre(propM);
        newMembre.setCamp(camp);
        newMembre.setIdent(idSuivant);
        tousMembre.put(idSuivant++, newMembre);
        return newMembre;
    }
}
