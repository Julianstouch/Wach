package ressource.template;


import ressource.RandomUtil;


/**
 * TODO Write the class' description
 *
 * @author
 */
public enum ETMP {

    barman(""), biblio(""), carrossier(""), charcu(""), commercial(""), controleur(""), facteur(""), infirm(""), journaliste(
            ""), opposant(""), patron(""), pompier(""), secrait(""), suppor(""), technicien_s(""), telev(""), trader(""), veterin(
            ""), viti(""), webmast("");

    private String nom;

    /**
     * 
     */
    private ETMP(final String nom) {
        this.nom = nom;
    }

    public static ETMP getRandom() {
        int pos = RandomUtil.getRandomIndex(0, ETMP.values().length - 1);
        return ETMP.values()[pos];
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
