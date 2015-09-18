package ressource.membre;


import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import visuel.perso.Portrait;
import chose.perso.Membre;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class Portrier {

    private static Portrier        instance;

    private Map<Integer, Portrait> tousPortrait;

    private int                    idSuivant;

    /**
     * 
     */
    private Portrier() {
    }

    public static Portrier getInstance() {
        if (instance == null) {
            instance = new Portrier();
            instance.tousPortrait = new HashMap<Integer, Portrait>();
        }
        return instance;
    }

    public Collection<Portrait> getAllPortrait() {
        return tousPortrait.values();
    }

    public List<Portrait> getAllPortraitBut(final Portrait port) {
        return tousPortrait.values().stream().filter(e -> e.getMembre().getIdent() != port.getMembre().getIdent())
                .collect(Collectors.toList());

    }

    /**
     * TODO : write the method's description
     * 
     * @return
     */
    public Portrait getPortrait(final Membre pMembre) {
        if (tousPortrait.get(pMembre.getIdent()) == null) {
            Portrait port = new Portrait(pMembre);
            tousPortrait.put(pMembre.getIdent(), port);
        }
        return tousPortrait.get(pMembre.getIdent());
    }
}
