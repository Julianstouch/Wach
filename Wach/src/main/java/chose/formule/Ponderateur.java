package chose.formule;


import type.stats.EStat;
import chose.perso.Membre;


/**
 * 
 *
 * @author
 */
public class Ponderateur {

    private Membre     mem;
    private AbsFormule form;
    private Double     cumule;
    private Double     nbPond;

    /**
     * 
     public Ponderateur() { cumule = 0d; nbPond = 0d; }
     */

    /**
     * 
     */
    public Ponderateur(final Membre membre, final AbsFormule form) {
        cumule = 0d;
        nbPond = 0d;
        this.mem = membre;
        this.form = form;
        System.out.print(form.getClass().getSimpleName());
    }

    /**
     * Enlever
     * 
     * @param valeur
     * @param pond
     * @return
     */
    public Ponderateur m(final EStat stat, final Integer pond) {

        Integer valeur = mem.getStat(stat).getValeur();
        System.out.print("-[" + stat.getCode() + "-" + valeur + "*" + (pond == 0 ? 1 : pond) + "]");
        cumule = cumule - (valeur * (pond == 0 ? 1 : pond));
        return this;
    }

    /**
     * Ajouter
     * 
     * @param valeur
     * @param pond
     * @return
     */
    public Ponderateur p(final EStat stat, final Integer pond) {

        Integer valeur = mem.getStat(stat).getValeur();

        System.out.print("+[" + stat.getCode() + "-" + valeur + "*" + (pond == 0 ? 1 : pond) + "]");
        cumule = cumule + (valeur * (pond == 0 ? 1 : pond));
        nbPond = nbPond + pond;
        return this;
    }

    /**
     * Ajouter
     * 
     * @param valeur
     * @param pond
     * @return
     */
    public Ponderateur p(final EStat stat, final Integer multi, final Integer pond) {

        Integer valeur = mem.getStat(stat).getValeur();
        System.out.print("+[" + stat.getCode() + "-" + valeur + "*" + multi + "*" + (pond == 0 ? 1 : pond) + "]");
        cumule = cumule + (valeur * multi * (pond == 0 ? 1 : pond));
        nbPond = nbPond + pond;
        return this;
    }

    /**
     * Ajouter
     * 
     * @param valeur
     * @param pond
     * @return
     */
    public Ponderateur p(final Integer valeur, final Integer pond) {
        System.out.print("+[Random-" + valeur + "*" + (pond == 0 ? 1 : pond) + "]");
        cumule = cumule + (valeur * (pond == 0 ? 1 : pond));
        nbPond = nbPond + pond;
        return this;
    }

    public Integer total() {
        return total(1);
    }

    public Integer total(final int coef) {
        Integer res = new Double((cumule * coef) / nbPond).intValue();
        System.out.println("=[" + cumule + "*" + coef + "/" + nbPond + "] > " + res);
        return res;
    }

}
