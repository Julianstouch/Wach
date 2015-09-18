package chose.perso;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javafx.scene.image.Image;
import ressource.template.ETERME;
import ressource.text.EGENRE;
import ressource.text.Textier;
import ressource.visuel.Imagier;
import type.stats.ESB;
import type.stats.ESC;
import type.stats.ESD;
import type.stats.ESI;
import type.stats.ESS;
import chose.concept.StatB;
import chose.concept.StatC;
import chose.concept.StatD;
import chose.formule.FSC;
import chose.formule.FSD;


/**
 * Un membre d'un camp
 *
 * @author
 */
public class Membre {

    private int                                ident;
    private int                                camp;
    private String                             metier;
    private String                             genre;
    private String                             nom;
    private Image                              tete;

    private Map<ESB, StatB>                    statBase;
    private Map<ESC, StatC>                    statCombat;
    private Map<ESD, StatD>                    statDyna;
    private Map<Membre, List<Map<ESI, StatB>>> statInter;
    private Map<ESS, StatB>                    statSens;

    /**
     * @param propMember
     */
    public Membre(final Properties propMember) {

        this.metier = propMember.getProperty(ETERME.METIER.name());
        this.genre = propMember.getProperty(ETERME.GENRE.name());

        this.nom = Textier.getInstance().getNouveauNom(EGENRE.valueOf(genre));
        this.tete = Imagier.getInstance().getRandomMembre();
        // stats
        this.statBase = new HashMap<ESB, StatB>();
        this.statCombat = new HashMap<ESC, StatC>();
        this.statDyna = new HashMap<ESD, StatD>();
        for (ESB baseStat : ESB.values()) {
            StatB stat = new StatB();
            stat.setType(baseStat);
            stat.setValeur(Integer.valueOf(propMember.getProperty(baseStat.name())));
            statBase.put(baseStat, stat);
        }

        FSC fsc = new FSC(this);
        for (ESC combatStat : ESC.values()) {
            statCombat.put(combatStat, fsc.getStat(combatStat));
        }

        FSD fsd = new FSD(this);
        for (ESD combatDyna : ESD.values()) {
            statDyna.put(combatDyna, fsd.getStat(combatDyna));
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
     * Gets the genre.
     *
     * @return the genre.
     */
    public String getGenre() {
        return genre;
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
     * Gets the metier.
     *
     * @return the metier.
     */
    public String getMetier() {
        return metier;
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
     * Gets the statCombat.
     *
     * @return the statCombat.
     */
    public Map<ESC, StatC> getStatCombat() {
        return statCombat;
    }

    /**
     * Gets the statDyna.
     *
     * @return the statDyna.
     */
    public Map<ESD, StatD> getStatDyna() {
        return statDyna;
    }

    /**
     * Gets the tete.
     *
     * @return the tete.
     */
    public Image getTete() {
        return tete;
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
