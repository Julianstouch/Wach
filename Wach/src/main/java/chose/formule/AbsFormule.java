package chose.formule;


import java.util.function.Supplier;

import ressource.Randomier;
import chose.perso.Membre;


/**
 * TODO Write the class' description
 *
 * @author
 */
public abstract class AbsFormule extends Randomier implements Formule {

    private Membre            mem;

    private Supplier<Double>  regen;

    private Supplier<Integer> initValue;

    private Integer           valeur;

    private Integer           valeurInitiale;

    private Integer           tendance;

    private Double            ratio;

    /**
     * 
     */
    public AbsFormule() {
        regen = prepareRegen();
        initValue = prepareInitValue();
    }

    public Integer getMax() {
        return getMaxValue();
    }

    public Membre getProprio() {
        return mem;
    }

    public Double getRegen() {
        return regen.get();
    }

    /**
     * Gets the tendance.
     *
     * @return the tendance.
     */
    public Integer getTendance() {
        return valeurInitiale.compareTo(valeur);
    }

    /**
     * Gets the valeur.
     *
     * @return the valeur.
     */
    public Integer getValeur() {
        return valeur;
    }

    public Integer getValeurRatio() {
        return new Double(valeur * ratio).intValue();
    }

    public void init(final Membre mem, final Integer initVal) {
        this.mem = mem;
        if (initVal == null) {
            this.valeurInitiale = initValue.get();
        } else {
            this.valeurInitiale = initVal;
        }
        valeur = valeurInitiale;
        ratio = 100 / new Double(getMaxValue());
    }

    protected abstract Integer getMaxValue();

    // protected abstract Integer getMinValue();

    protected abstract Supplier<Integer> prepareInitValue();

    protected abstract Supplier<Double> prepareRegen();

}
