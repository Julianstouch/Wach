package ressource.text;


import ressource.RandomUtil;


/**
 * TODO Write the class' description
 *
 * @author
 */
public enum ETXT {
    homme(1), femme(2);

    private int num;

    /**
     * 
     */
    private ETXT(final int num) {
        this.num = num;
    }

    public static ETXT getOne() {
        return ETXT.values()[RandomUtil.getRandomIndex(0, ETXT.values().length)];
    }

    /**
     * Gets the nom.
     *
     * @return the nom.
     */
    public int getNum() {
        return num;
    }

}
