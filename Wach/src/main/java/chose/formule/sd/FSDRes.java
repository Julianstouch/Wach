package chose.formule.sd;


import java.util.function.Supplier;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class FSDRes extends FSDyna {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer prepareInitValue() {
        return getPon().p(getRandomPourcent(50, 50 + getRandomSC(), 1, 90), 1).total() + getRandomSC();
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