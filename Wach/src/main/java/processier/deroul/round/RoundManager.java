package processier.deroul.round;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import ressource.membre.Membrier;
import chose.perso.Membre;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class RoundManager {

    public RoundManager() {
    }

    public void demarrer() {

        Comparator startOrder = new Comparator<Membre>() {
            @Override
            public int compare(final Membre mem1, final Membre mem2) {
                return Integer.compare(mem1.getIdent(), mem2.getIdent());
            }
        };

        List<Integer> ordre = Membrier.getInstance().getAllMembre().stream().sorted(startOrder).map(e -> e.getIdent())
                .collect(Collectors.toList());

    }
}
