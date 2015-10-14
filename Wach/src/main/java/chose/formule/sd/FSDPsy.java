package chose.formule.sd;


import java.util.function.Supplier;

import type.stats.EStat;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class FSDPsy extends FSDyna {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer prepareInitValue() {
        return getPon().p(EStat.INT, 2, 1).p(EStat.MEN, 2, 0).total() + getRandomSC();
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