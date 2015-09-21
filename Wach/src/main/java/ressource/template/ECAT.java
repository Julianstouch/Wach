package ressource.template;


/**
 * TODO Write the class' description
 *
 * @author
 */
public enum ECAT {

    o("Opposant"), e("Entrainant"), c("Contact"), m("Manager"), t("Terrain");

    private String nom;

    /**
     * 
     */
    private ECAT(final String nom) {
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
