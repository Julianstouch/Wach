package chose.formule.sd;


import java.util.function.Supplier;

import type.stats.EStat;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class FSDNrj extends FSDyna {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer prepareInitValue() {
        return getPon().p(EStat.END, 1).total(4) + getRandomSC();
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