package chose.concept;


import type.stats.ESI;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class StatI {

    private ESI type;

    private int valeur;

    /**
     * Gets the type.
     *
     * @return the type.
     */
    public ESI getType() {
        return type;
    }

    /**
     * Gets the valeur.
     *
     * @return the valeur.
     */
    public int getValeur() {
        return valeur;
    }

    /**
     * Sets the type.
     *
     * @param type type.
     */
    public void setType(final ESI type) {
        this.type = type;
    }

    /**
     * Sets the valeur.
     *
     * @param valeur valeur.
     */
    public void setValeur(final int valeur) {
        this.valeur = valeur;
    }

}
