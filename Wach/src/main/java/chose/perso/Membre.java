package chose.perso;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import javafx.scene.image.Image;
import ressource.RandomUtil;
import ressource.membre.Membrier;
import ressource.template.ECAT;
import ressource.template.ETERME;
import ressource.text.EGENRE;
import ressource.text.Textier;
import ressource.visuel.Imagier;
import type.stats.ESB;
import type.stats.ESC;
import type.stats.ESD;
import type.stats.ESI;
import chose.concept.StatB;
import chose.concept.StatC;
import chose.concept.StatD;
import chose.concept.StatI;
import chose.formule.FSC;
import chose.formule.FSD;


/**
 * Un membre d'un camp
 *
 * @author
 */
public class Membre {

    private int                          ident;
    private int                          camp;
    private String                       metier;
    private String                       categorie;
    private EGENRE                       genre;
    private String                       nom;
    private Image                        tete;

    private Map<ESB, StatB>              statBase;
    private Map<ESC, StatC>              statCombat;
    private Map<ESD, StatD>              statDyna;
    private Map<Membre, Map<ESI, StatI>> statInter;

    /**
     * @param propMember
     */
    public Membre(final Properties propMember) {

        this.metier = propMember.getProperty(ETERME.METIER.toString());
        this.genre = EGENRE.valueOf(propMember.getProperty(ETERME.GENRE.toString()).trim());
        this.categorie = ECAT.valueOf(propMember.getProperty(ETERME.CAT.toString()).trim()).getNom();
        this.nom = Textier.getInstance().getNouveauNom(genre);
        this.tete = Imagier.getInstance().getRandomMembre();
        // stats
        this.statBase = new LinkedHashMap<ESB, StatB>();
        this.statCombat = new LinkedHashMap<ESC, StatC>();
        this.statDyna = new LinkedHashMap<ESD, StatD>();
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
        for (ESD dynaStat : ESD.values()) {
            statDyna.put(dynaStat, fsd.getStat(dynaStat));
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
     * Gets the categorie.
     *
     * @return the categorie.
     */
    public String getCategorie() {
        return categorie;
    }

    /**
     * Gets the genre.
     *
     * @return the genre.
     */
    public EGENRE getGenre() {
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

    public Map<Membre, Map<ESI, StatI>> getStatInter() {
        return statInter;
    }

    /**
     * Gets the tete.
     *
     * @return the tete.
     */
    public Image getTete() {
        return tete;
    }

    public void initStatI() {
        this.statInter = new LinkedHashMap<Membre, Map<ESI, StatI>>();

        for (Membre other : Membrier.getInstance().getAllMembreBut(this)) {
            Map<ESI, StatI> listI = new HashMap<ESI, StatI>();
            for (ESI otherStat : ESI.values()) {
                StatI stat = new StatI();
                stat.setType(otherStat);
                stat.setValeur(RandomUtil.getRandomIndex(0, 10));
                listI.put(otherStat, stat);
            }
            statInter.put(other, listI);
        }
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

}
