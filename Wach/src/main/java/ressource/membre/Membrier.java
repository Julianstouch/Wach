package ressource.membre;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import ressource.template.Templier;
import visuel.perso.Portrait;
import chose.perso.Membre;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class Membrier {

    private static Membrier    instance;

    private List<Membre>       tousMembre;

    private int                idSuivant;

    private Comparator<Membre> compare;

    /**
     * 
     */
    private Membrier() {
        idSuivant = 1;
        tousMembre = new ArrayList<Membre>();
        compare = new Comparator<Membre>() {
            @Override
            public int compare(final Membre mem1, final Membre mem2) {
                return Integer.compare(mem1.getIdent(), mem2.getIdent());
            }
        };

    }

    public static Membrier getInstance() {
        if (instance == null) {
            instance = new Membrier();
        }
        return instance;
    }

    public Collection<Membre> getAllMembre() {
        return tousMembre;
    }

    public List<Membre> getAllMembreBut(final Membre courrant) {
        return tousMembre.stream().filter(e -> e.getIdent() != courrant.getIdent()).sorted(compare)
                .collect(Collectors.toList());
    }

    public Collection<Portrait> getAllPortrait() {
        return tousMembre.stream().map(Membre::getSonPortrait).collect(Collectors.toList());
    }

    public List<Portrait> getAllPortraitBut(final Portrait port) {
        return tousMembre.stream().filter(e -> e.getIdent() != port.getMembre().getIdent()).map(Membre::getSonPortrait)
                .collect(Collectors.toList());

    }

    public Membre getMembre(final int ident) {
        return tousMembre.stream().filter(e -> e.getIdent() == ident).findFirst().get();
    }

    /**
     * TODO : write the method's description
     * 
     * @return
     */
    public Membre getNouveauMembre(final int camp) {
        Properties propM = Templier.getInstance().getRandomTemplate();
        Membre newMembre = new Membre(propM, camp, idSuivant++);
        tousMembre.add(newMembre);
        return newMembre;
    }

    /**
     * TODO : write the method's description
     * 
     * @return
     */
    public Portrait getPortrait(final Membre pMembre) {
        return tousMembre.stream().filter(e -> e.getIdent() == pMembre.getIdent()).findFirst().get().getSonPortrait();
    }
}
