package chose.formule.si;


import java.util.function.Supplier;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class FSICon extends FSInter {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer prepareInitValue() {
        return getPon().p(getRandomPourcent(95, 0, 25, 75), 1).total();
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