/*
 * Copyright (c) 2015 by VIF (Vignon Informatique France)
 * Project : TestO
 * File : $RCSfile$
 * Created on 3 sept. 2015 by presta2
 */
package wach;


import java.util.function.Predicate;


/**
 * TODO Write the class' description
 *
 * @author presta2
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
