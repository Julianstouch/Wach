package type.stats;


import java.util.EnumSet;


/**
 * TODO Write the class' description
 *
 * @author
 */
public enum EStat {

    // ---- Base
    /** Santé */
    SAN("Santé", 3),

    /** Force */
    FOR("Force", 1),

    /** Souplesse */
    SOU("Souplesse", 4),

    /** Mental */
    MEN("Mental", 5),

    /** Intelligence */
    INT("Intelligence", 6),

    /** Endurance */
    END("Endurance", 2),

    // ---- Combat
    /** Concentration (Focus) */
    FOC("Concentration", 2),

    /** Calme */
    CAL("Calme", 1),

    /** Habilité (précision) */
    HAB("Habilité", 5),

    /** Rapidité */
    RAP("Rapidité", 6),

    /** Capacité physique */
    CAP("Capacité physique", 8),

    /** Moral (confiance perso) */
    MOR("Moral", 4),

    /** Assurance (connaissance technique perso) */
    ASS("Assurance", 3),

    /** Vue */
    VUE("Vue", 9),

    /** Ouïe */
    OUI("Ouïe", 10),

    /** Equilibire */
    EQU("Equilibre", 7),

    // ----- Dynamique
    /** Energie */
    NRJ("Energie", 2),

    /** Ressource */
    RES("Ressource", 1),

    /** Défense physique */
    DEF("Défense physique", 3),

    /** Psychique */
    PSY("Psychique", 4),

    // ---- Interaction
    /** Sympathie */
    SYM("Sympathie", 1),

    /** Confiance */
    CON("Confiance", 2),

    /** Connaissance technique */
    TEC("Connaissance technique", 3),

    // ------ Env
    /** Température */
    TEM("Température", 3),

    /** Encombrement */
    ENC("Encombrement", 4),

    /** Eclairage */
    ECL("Eclairage", 1),

    /** Visibilité */
    VIS("Visibilité", 2);

    /** Base */
    public static EnumSet<EStat> ESB = EnumSet.of(SAN, FOR, SOU, MEN, INT, END);
    /** Combat */
    public static EnumSet<EStat> ESC = EnumSet.of(FOC, CAL, HAB, RAP, CAP, MOR, ASS, VUE, OUI, EQU);
    /** Dynamique */
    public static EnumSet<EStat> ESD = EnumSet.of(NRJ, RES, DEF, PSY);
    /** Interaction */
    public static EnumSet<EStat> ESI = EnumSet.of(SYM, CON, TEC);
    /** Environnement */
    public static EnumSet<EStat> ESE = EnumSet.of(TEM, ENC, ECL, VIS);

    private String               code;

    private Integer              positionAff;

    /**
     * 
     */
    private EStat(final String code, final Integer pos) {
        this.code = code;
        this.positionAff = pos;
    }

    /**
     * Get le code
     * 
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the positionAff.
     *
     * @return the positionAff.
     */
    public Integer getPositionAff() {
        return positionAff;
    }
}
