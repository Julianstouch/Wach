package chose.formule.sb;


import java.util.function.Supplier;

import chose.formule.AbsFormule;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class FSBase extends AbsFormule {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getMaxValue() {
        return 25;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Supplier<Integer> prepareInitValue() {
        return new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 0;
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Supplier<Double> prepareRegen() {
        return new Supplier<Double>() {
            @Override
            public Double get() {
                return 0d;
            }
        };
    }
}