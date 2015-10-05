package chose.formule;


/**
 * 
 *
 * @author
 */
public class Ponderateur {

    private Double cumule;
    private Double nbPond;

    /**
     * 
     */
    public Ponderateur() {
        cumule = 0d;
        nbPond = 0d;
    }

    /**
     * Enlever
     * 
     * @param valeur
     * @param pond
     * @return
     */
    public Ponderateur m(final Integer valeur, final Integer pond) {
        cumule = cumule - (valeur * pond);
        return this;
    }

    /**
     * Ajouter
     * 
     * @param valeur
     * @param pond
     * @return
     */
    public Ponderateur p(final Integer valeur, final Integer pond) {
        cumule = cumule + (valeur * pond);
        nbPond = nbPond + pond;
        return this;
    }

    public Integer total() {
        return total(1);
    }

    public Integer total(final int coef) {
        return new Double(cumule / nbPond).intValue() * coef;
    }
}
