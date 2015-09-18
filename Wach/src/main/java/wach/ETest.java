package wach;


import java.util.function.Predicate;


/**
 * TODO Write the class' description
 *
 * @author
 */
public enum ETest {

    ET(e -> e != null);

    Predicate<?> pred;

    /**
     * 
     */
    private <T> ETest(final Predicate<?> pred) {
        this.pred = pred;
    }
}
