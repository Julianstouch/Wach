package type.stats;


/**
 * Stats interaction (par rapport à chaque autre perso allié ou opposant)
 *
 * @author
 */
public enum ESI {

    /** Sympathie */
    SYM("Sympathie"),

    /** Confiance */
    CON("Confiance"),

    /** Connaissance technique */
    TEC("Connaissance technique");

    private String code;

    /**
     * 
     */
    private ESI(final String code) {
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
