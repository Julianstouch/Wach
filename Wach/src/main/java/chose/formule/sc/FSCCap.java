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
public class FSCCap implements Function<Membre, Integer> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer apply(final Membre mem) {
        int ment = mem.getSB(ESB.MEN);
        int intel = mem.getSB(ESB.INT);
        int force = mem.getSB(ESB.FOR);
        int rand = RandomUtil.getRandomIndex(-10, 10);
        Double tot = new Double((ment * 3) + (intel * 2) - force) + rand;
        return tot.intValue();
    }
}