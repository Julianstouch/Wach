package ressource.template;


/**
 * TODO Write the class' description
 *
 * @author
 */
public enum ETMP {

    test("classe");

    private String nom;

    /**
     * 
     */
    private ETMP(final String nom) {
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
