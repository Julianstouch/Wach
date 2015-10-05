package chose.formule.sc;


import java.util.function.Supplier;

import type.stats.EStat;


/**
 * Formule calcul Equilibre
 *
 * @author
 */
public class FSCEqu extends FSCombat {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer prepareInitValue() {
        return getPon().p(25, 4).p(getS(EStat.SOU), 1).p(getS(EStat.END), 1).total(4) + getRandomSC();
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