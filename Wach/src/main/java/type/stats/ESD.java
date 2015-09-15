package type.stats;


/**
 * Stats Dynamique
 *
 * @author
 */
public enum ESD {

    /** Energie */
    NRJ("Energie"),

    /** Ressource */
    RES("Ressource"),

    /** Défense physique */
    DEF("Défense physique"),

    /** Psychique */
    PSY("Psychique");

    private String code;

    /**
     * 
     */
    private ESD(final String code) {
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
