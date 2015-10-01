package chose.formule.sc;


import java.util.function.Supplier;

import ressource.Randomier;
import type.stats.EStat;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class FSCRap extends FSCombat {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Supplier<Integer> prepareInitValue() {
        return new Supplier<Integer>() {
            @Override
            public Integer get() {
                int ment = getProprio().getStat(EStat.MEN).getValeur();
                int intel = getProprio().getStat(EStat.INT).getValeur();
                int force = getProprio().getStat(EStat.FOR).getValeur();
                int rand = Randomier.getRandomIndex(-10, 10);
                Double tot = new Double((ment * 3) + (intel * 2) - force) + rand;
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