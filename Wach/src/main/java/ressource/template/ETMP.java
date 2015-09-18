package ressource.template;


import ressource.RandomUtil;


/**
 * TODO Write the class' description
 *
 * @author
 */
public enum ETMP {

    facteur("facteur"), carro("carrossier"), journa("journaliste");

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
