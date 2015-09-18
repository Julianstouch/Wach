package chose.formule;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import ressource.RandomUtil;
import type.stats.ESD;
import chose.concept.StatD;
import chose.perso.Membre;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class FSD implements Formule {

    private final Membre                        mem;
    private Map<ESD, Function<Membre, Integer>> mapD;

    /**
     * 
     */
    public FSD(final Membre mem) {
        Function temp = new Function<Membre, Integer>() {
            /**
             * {@inheritDoc}
             */
            @Override
            public Integer apply(final Membre t) {
                return RandomUtil.getRandomIndex(0, 100);
            }
        };

        mapD = new HashMap<ESD, Function<Membre, Integer>>();
        mapD.put(ESD.NRJ, temp);
        mapD.put(ESD.PSY, temp);
        mapD.put(ESD.RES, temp);
        mapD.put(ESD.DEF, temp);

        this.mem = mem;
    }

    public StatD getStat(final ESD typeSD) {
        StatD stat = new StatD();
        stat.setType(typeSD);
        stat.setValeur(mapD.get(typeSD).apply(mem));
        return stat;
    }
}
