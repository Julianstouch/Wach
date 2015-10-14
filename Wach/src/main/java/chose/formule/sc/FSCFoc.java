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
        return getPon().p(EStat.MEN, 5).p(EStat.SAN, 3).m(EStat.FOR, 1).total(7) + getRandomSC();
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