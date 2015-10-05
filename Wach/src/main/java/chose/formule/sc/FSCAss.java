package chose.formule.sc;


import java.util.function.Supplier;

import type.stats.EStat;


/**
 * Formule calcul Assurance
 *
 * @author
 */
public class FSCAss extends FSCombat {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer prepareInitValue() {
        return getPon().p(getS(EStat.MEN), 3).p(getS(EStat.FOR), 3).p(getS(EStat.END), 1).total(4) + getRandomSC();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Supplier<Double> prepareRegen() {
        // TODO Auto-generated method stub
        return null;
    }

}