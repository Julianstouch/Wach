package chose.formule;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import ressource.RandomUtil;
import type.stats.ESD;
import type.stats.ESI;
import chose.concept.StatD;
import chose.perso.Membre;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class FSI implements Formule {

    private final Membre                        mem;
    private Map<ESI, Function<Membre, Integer>> mapD;

    /**
     * 
     */
    public FSI(final Membre mem) {
        Function temp = new Function<Membre, Integer>() {
            /**
             * {@inheritDoc}
             */
            @Override
            public Integer apply(final Membre t) {
                return RandomUtil.getRandomIndex(0, 10);
            }
        };

        mapD = new HashMap<ESI, Function<Membre, Integer>>();
        mapD.put(ESI.SYM, temp);
        mapD.put(ESI.CON, temp);
        mapD.put(ESI.TEC, temp);

        this.mem = mem;
    }

    public StatD getStat(final ESD typeSD) {
        StatD stat = new StatD();
        stat.setType(typeSD);
        stat.setValeur(mapD.get(typeSD).apply(mem));
        return stat;
    }
}
