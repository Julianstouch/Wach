package chose.formule.sc;


import java.util.function.Function;

import ressource.RandomUtil;
import type.stats.ESB;
import chose.perso.Membre;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class FSCAss implements Function<Membre, Integer> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer apply(final Membre mem) {
        int ment = mem.getSB(ESB.MEN);
        int force = mem.getSB(ESB.FOR);
        int end = mem.getSB(ESB.END);
        int rand = RandomUtil.getRandomIndex(-10, 10);
        Double tot = new Double((ment * 2) + (end * 2) + (force * 2)) + rand;
        return tot.intValue();
    }
}