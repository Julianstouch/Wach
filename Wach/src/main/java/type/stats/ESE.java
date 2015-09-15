package type.stats;


/**
 * Stats environnement (pour chaque groupe)
 *
 * @author
 */
public enum ESE {

    /** Température */
    TEM("Température"),

    /** Encombrement */
    ENC("Encombrement"),

    /** Eclairage */
    ECL("Eclairage"),

    /** Visibilité */
    VIS("Visibilité");

    private String code;

    /**
     * 
     */
    private ESE(final String code) {
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
