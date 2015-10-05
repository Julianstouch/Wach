package chose.formule.sc;


import java.util.function.Supplier;


/**
 * Formule calcul Calme
 *
 * @author
 */
public class FSCCal extends FSCombat {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer prepareInitValue() {
        return getPon().p(100, 1).total() + getRandomSC();
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