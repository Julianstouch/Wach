package chose.concept;


import ressource.formule.Formulier;
import type.stats.EStat;
import chose.formule.Formule;
import chose.perso.Membre;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class Stat implements Comparable {

    private EStat   type;

    private Membre  proprio;
    private Membre  cible;

    private Formule formule;

    /**
     * 
     */
    public Stat(final EStat type, final Membre proprio) {
        this.type = type;
        this.proprio = proprio;
        this.cible = proprio;
        this.formule = Formulier.getInstance().getNewFormule(type, proprio);
    }

    /**
     * 
     */
    public Stat(final EStat type, final Membre proprio, final Integer initVal) {
        this.type = type;
        this.proprio = proprio;
        this.cible = proprio;
        this.formule = Formulier.getInstance().getNewFormule(type, proprio, initVal);
    }

    /**
     * 
     */
    public Stat(final EStat type, final Membre proprio, final Membre cible) {
        this.type = type;
        this.proprio = proprio;
        this.cible = cible;
        this.formule = Formulier.getInstance().getNewFormule(type, proprio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(final Object o) {
        return getType().getPositionAff().compareTo(((Stat) o).getType().getPositionAff());
    }

    /**
     * Gets the cible.
     *
     * @return the cible.
     */
    public Membre getCible() {
        return cible;
    }

    public Integer getMax() {
        return formule.getMax();
    }

    /**
     * Gets the tendance.
     *
     * @return the tendance.
     */
    public int getTendance() {
        return formule.getTendance();
    }

    /**
     * Gets the type.
     *
     * @return the type.
     */
    public EStat getType() {
        return type;
    }

    /**
     * Gets the valeur.
     *
     * @return the valeur.
     */
    public int getValeur() {
        return formule.getValeur();
    }

    /**
     * Gets the valeur.
     *
     * @return the valeur.
     */
    public int getValeurRatio() {
        return formule.getValeurRatio();
    }
}