package chose.formule.si;


import java.util.function.Supplier;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class FSISym extends FSInter {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer prepareInitValue() {
        return getPon().p(getRandomPourcent(98, 0, 25, 95), 1).total();
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