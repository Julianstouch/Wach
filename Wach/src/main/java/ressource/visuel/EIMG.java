package ressource.visuel;


/**
 * TODO Write the class' description
 *
 * @author
 */
public enum EIMG {

    fond("fond_1.png"), bufftest1("buff/bufftest45_1.png"), bufftest2("buff/bufftest45_2.png"),
    membrerandom("membre_");

    private String nom;

    /**
     * 
     */
    private EIMG(final String nom) {
        this.nom = nom;
    }

    /**
     * Gets the nom.
     *
     * @return the nom.
     */
    public String getNom() {
        return nom;
    }
}
