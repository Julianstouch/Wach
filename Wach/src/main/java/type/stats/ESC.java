package type.stats;


/**
 * Stats perso en combat
 *
 * @author
 */
public enum ESC {

    /** Concentration */
    CON("Concentration"),

    /** Calme */
    CAL("Calme"),

    /** Habilité (précision) */
    HAB("Habilité"),

    /** Rapidité */
    RAP("Rapidité"),

    /** Capacité physique */
    CAP("Capacité physique"),

    /** Moral (confiance perso) */
    MOR("Moral"),

    /** Assurance (connaissance technique perso) */
    ASS("Assurance");

    private String code;

    /**
     * 
     */
    private ESC(final String code) {
        this.code = code;
    }

    /**
     * Get le code
     * 
     * @return code
     */
    public String getCode() {
        return code;
    }
}
