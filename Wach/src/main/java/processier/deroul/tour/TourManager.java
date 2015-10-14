package processier.deroul.tour;


import ressource.membre.Membrier;
import chose.perso.Membre;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class TourManager {

    /**
     * 
     */
    public TourManager() {

    }

    public void demarrer() {
        Membre actuel = Membrier.getInstance().getMembre(1);
        actuel.getSonPortrait().tour();
    }

}
