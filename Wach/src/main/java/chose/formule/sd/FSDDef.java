package chose.formule.sd;


import java.util.function.Supplier;

import type.stats.EStat;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class FSDDef extends FSDyna {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer prepareInitValue() {
        return getPon().p(getS(EStat.SAN) * 2, 1).p(getS(EStat.END) * 2, 1).total() + getRandomSC();
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