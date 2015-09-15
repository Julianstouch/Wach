package type.stats;


/**
 * Stats de base
 *
 * @author
 */
public enum ESB {

    /** Santé */
    SAN("Santé"),

    /** Force */
    FOR("Force"),

    /** Souplesse */
    SOU("Souplesse"),

    /** Mental */
    MEN("Mental"),

    /** Intelligence */
    INT("Intelligence"),

    /** Endurance */
    END("Endurance");

    private String code;

    /**
     * 
     */
    private ESB(final String code) {
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
