package chose.formule.sc;


import java.util.function.Supplier;

import type.stats.EStat;


/**
 * Formule calcul Habilité
 *
 * @author
 */
public class FSCHab extends FSCombat {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer prepareInitValue() {
        return getPon().p(getS(EStat.END), 1).p(getS(EStat.SOU), 2).p(getS(EStat.INT), 1).p(getS(EStat.SAN), 1)
                .total(4)
                + getRandomSC();
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