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
        return getPon().p(EStat.END, 1).p(EStat.SOU, 2).p(EStat.INT, 1).p(EStat.SAN, 1).total(6) + getRandomSC();
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