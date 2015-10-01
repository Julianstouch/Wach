package ressource.text;


import ressource.Randomier;


/**
 * TODO Write the class' description
 *
 * @author
 */
public enum EGENRE {
    /** Homme */
    h("M. ", true),
    /** Femme */
    f("Mme ", true),
    /** Robot */
    r("i-", false);

    private String  prefix;
    private boolean loadFile;

    /**
     * 
     */
    private EGENRE(final String prefix, final boolean loadFile) {
        this.prefix = prefix;
        this.loadFile = loadFile;
    }

    public static EGENRE getOne() {
        return EGENRE.values()[Randomier.getRandomIndex(0, EGENRE.values().length - 1)];
    }

    /**
     * Gets the loadFile.
     *
     * @return the loadFile.
     */
    public boolean getLoadFile() {
        return loadFile;
    }

    /**
     * Gets the prefix.
     *
     * @return the prefix.
     */
    public String getPrefix() {
        return prefix;
    }
}
