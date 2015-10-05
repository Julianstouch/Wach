package chose.formule.sc;


import java.util.function.Supplier;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class FSCOui extends FSCombat {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer prepareInitValue() {
        return getPon().p(getRandomPourcent(90, 100 + getRandomSC(), 10, 90), 1).total();
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