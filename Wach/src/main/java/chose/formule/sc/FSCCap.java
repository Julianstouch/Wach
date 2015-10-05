package chose.formule.sc;


import java.util.function.Supplier;

import type.stats.EStat;


/**
 * Formule calcul Capacité Physique
 *
 * @author
 */
public class FSCCap extends FSCombat {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer prepareInitValue() {
        return getPon().p(getS(EStat.FOR), 2).p(getS(EStat.END), 3).p(getS(EStat.SAN), 4).total(4) + getRandomSC();
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