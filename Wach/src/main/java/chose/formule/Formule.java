package chose.formule;


import chose.perso.Membre;


/**
 * TODO Write the class' description
 *
 * @author
 */
public interface Formule {

    Integer getMax();

    Membre getProprio();

    Double getRegen();

    Integer getTendance();

    Integer getValeur();

    Integer getValeurRatio();

    void init(Membre mem, Integer initVal);
}
