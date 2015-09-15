package chose.perso;


import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import type.stats.ESB;
import type.stats.ESC;
import type.stats.ESD;
import type.stats.ESI;
import type.stats.ESS;
import chose.concept.StatB;


/**
 * Un membre d'un camp
 *
 * @author 
 */
public class Membre {

    private int             ident;
    private int             camp;
    private String          nom;

    private Map<ESB, StatB> statBase;
    private Map<ESC, StatB> statCombat;
    private Map<ESD, StatB> statDyna;
    private Map<ESI, StatB> statInter;
    private Map<ESS, StatB> statSens;

    /**
     * 
     */
    public Membre(final Map<ESB, StatB> statInit) {
        this.statBase = statInit;
    }

    /**
     * @param propMember
     */
    public Membre(final Properties propMember) {
        this.statBase = new HashMap<ESB, StatB>();
        for (ESB baseStat : ESB.values()) {
            StatB stat = new StatB();
            stat.setType(baseStat);
            stat.setValeur(Integer.valueOf(propMember.getProperty(baseStat.name())));
            statBase.put(baseStat, stat);
        }
    }

    /**
     * Gets the camp.
     *
     * @return the camp.
     */
    public int getCamp() {
        return camp;
    }

    /**
     * Gets the ident.
     *
     * @return the ident.
     */
    public int getIdent() {
        return ident;
    }

    /**
     * Gets the nom.
     *
     * @return the nom.
     */
    public String getNom() {
        return nom;
    }

    public int getSB(final ESB typeSB) {
        return getStatBase().get(typeSB).getValeur();
    }

    /**
     * Gets the statBase.
     *
     * @return the statBase.
     */
    public Map<ESB, StatB> getStatBase() {
        return statBase;
    }

    /**
     * Sets the camp.
     *
     * @param camp camp.
     */
    public void setCamp(final int camp) {
        this.camp = camp;
    }

    /**
     * Sets the ident.
     *
     * @param ident ident.
     */
    public void setIdent(final int ident) {
        this.ident = ident;
    }

    /**
     * Sets the nom.
     *
     * @param nom nom.
     */
    public void setNom(final String nom) {
        this.nom = nom;
    }

}
