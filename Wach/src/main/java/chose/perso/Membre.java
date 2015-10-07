package chose.perso;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

import javafx.scene.image.Image;
import ressource.membre.Membrier;
import ressource.template.ECAT;
import ressource.template.ETERME;
import ressource.text.EGENRE;
import ressource.text.Textier;
import ressource.visuel.Imagier;
import type.stats.EStat;
import visuel.perso.Portrait;
import chose.concept.Stat;


/**
 * Un membre d'un camp
 *
 * @author
 */
public class Membre {

    private int        ident;
    private int        camp;
    private String     metier;
    private String     categorie;
    private EGENRE     genre;
    private String     nom;
    private Image      tete;

    private Portrait   sonPortrait;

    private List<Stat> stats;

    /**
     * @param propMember
     * @param idSuivant
     * @param camp
     */
    public Membre(final Properties propMember, final int camp, final int idSuivant) {

        this.ident = idSuivant;
        this.camp = camp;
        this.metier = propMember.getProperty(ETERME.METIER.toString());
        this.genre = EGENRE.valueOf(propMember.getProperty(ETERME.GENRE.toString()).trim());
        this.categorie = ECAT.valueOf(propMember.getProperty(ETERME.CAT.toString()).trim()).getNom();
        this.nom = Textier.getInstance().getNouveauNom(genre);
        this.tete = Imagier.getInstance().getRandomMembre();
        this.stats = new ArrayList<Stat>();

        for (EStat baseStat : EStat.ESB) {
            String val = propMember.getProperty(baseStat.name());
            Stat stat = new Stat(baseStat, this, Integer.valueOf(val));
            stats.add(stat);
        }

        for (EStat combatStat : EStat.ESC) {
            Stat stat = new Stat(combatStat, this);
            stats.add(stat);
        }

        for (EStat dynaStat : EStat.ESD) {
            Stat stat = new Stat(dynaStat, this);
            stats.add(stat);
        }

        sonPortrait = new Portrait(this);
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

    /**
     * Gets the sonPortrait.
     *
     * @return the sonPortrait.
     */
    public Portrait getSonPortrait() {
        return sonPortrait;
    }

    /**
     * Gets the statBase.
     *
     * @return the statBase.
     */
    public Stat getStat(final EStat statCherche) {
        Optional<Stat> theStat = stats.stream().filter(e -> statCherche.equals(e.getType())).findFirst();
        return theStat.get();
    }

    /**
     * Gets the statBase.
     *
     * @return the statBase.
     */
    public List<Stat> getStatBase() {
        return stats.stream().filter(e -> EStat.ESB.contains(e.getType())).sorted().collect(Collectors.toList());
    }

    /**
     * Gets the statCombat.
     *
     * @return the statCombat.
     */
    public List<Stat> getStatCombat() {
        return stats.stream().filter(e -> EStat.ESC.contains(e.getType())).sorted().collect(Collectors.toList());
    }

    /**
     * Gets the statDyna.
     *
     * @return the statDyna.
     */
    public List<Stat> getStatDyna() {
        return stats.stream().filter(e -> EStat.ESD.contains(e.getType())).sorted().collect(Collectors.toList());
    }

    public List<Stat> getStatInter() {
        return stats.stream().filter(e -> EStat.ESI.contains(e.getType())).sorted().collect(Collectors.toList());
    }

    public List<Stat> getStatInter(final Membre cible) {
        return stats.stream().filter(e -> EStat.ESI.contains(e.getType()) && e.getCible().equals(cible)).sorted()
                .collect(Collectors.toList());
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
        for (Membre other : Membrier.getInstance().getAllMembreBut(this)) {
            for (EStat otherStat : EStat.ESI) {
                Stat stat = new Stat(otherStat, this, other);
                // stat.setValeur(RandomUtil.getRandomIndex(0, 10));
                stats.add(stat);
            }
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
