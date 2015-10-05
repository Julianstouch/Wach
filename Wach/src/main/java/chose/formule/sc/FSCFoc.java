package chose.formule.sc;


import java.util.function.Supplier;

import type.stats.EStat;


/**
 * Formule pour Focus / Concentration
 *
 * @author
 */
public class FSCFoc extends FSCombat {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer prepareInitValue() {
        return getPon().p(getS(EStat.MEN), 5).p(getS(EStat.SAN), 3).m(getS(EStat.FOR), 1).total(4) + getRandomSC();
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