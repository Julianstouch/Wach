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
    protected Supplier<Integer> prepareInitValue() {
        return new Supplier<Integer>() {
            @Override
            public Integer get() {
                int ment = getProprio().getStat(EStat.MEN).getValeur();
                int force = getProprio().getStat(EStat.FOR).getValeur();
                int end = getProprio().getStat(EStat.END).getValeur();
                int rand = getRandomIndex(-10, 10);
                Double tot = new Double((ment * 2) + (end * 2) + (force * 2)) + rand;
                return tot.intValue();
            }
        };
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