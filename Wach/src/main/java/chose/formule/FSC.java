package chose.formule;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import type.stats.ESC;
import chose.concept.StatC;
import chose.formule.sc.FSCCon;
import chose.perso.Membre;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class FSC {

    private final Membre                        mem;
    private Map<ESC, Function<Membre, Integer>> mapF;

    /**
     * 
     */
    public FSC(final Membre mem) {
        mapF = new HashMap<ESC, Function<Membre, Integer>>();
        mapF.put(ESC.CON, new FSCCon());
        this.mem = mem;
    }

    public StatC getStatC(final ESC typeSC) {
        StatC stat = new StatC();
        stat.setType(typeSC);
        stat.setValeur(mapF.get(typeSC).apply(mem));
        return stat;
    }
}
