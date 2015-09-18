package ressource.text;


import ressource.RandomUtil;


/**
 * TODO Write the class' description
 *
 * @author
 */
public enum EGENRE {
    homme, femme;

    /**
     * 
     */
    private EGENRE() {
    }

    public static EGENRE getOne() {
        return EGENRE.values()[RandomUtil.getRandomIndex(0, EGENRE.values().length - 1)];
    }
}
