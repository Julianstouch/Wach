package chose.formule;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import type.stats.ESC;
import chose.concept.StatC;
import chose.formule.sc.FSCAss;
import chose.formule.sc.FSCCal;
import chose.formule.sc.FSCCap;
import chose.formule.sc.FSCCon;
import chose.formule.sc.FSCEqu;
import chose.formule.sc.FSCHab;
import chose.formule.sc.FSCMor;
import chose.formule.sc.FSCOui;
import chose.formule.sc.FSCRap;
import chose.formule.sc.FSCVue;
import chose.perso.Membre;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class FSC implements Formule {

    private final Membre                        mem;
    private Map<ESC, Function<Membre, Integer>> mapF;

    /**
     * 
     */
    public FSC(final Membre mem) {
        mapF = new HashMap<ESC, Function<Membre, Integer>>();
        mapF.put(ESC.ASS, new FSCAss());
        mapF.put(ESC.CAL, new FSCCal());
        mapF.put(ESC.CAP, new FSCCap());
        mapF.put(ESC.CON, new FSCCon());
        mapF.put(ESC.HAB, new FSCHab());
        mapF.put(ESC.MOR, new FSCMor());
        mapF.put(ESC.RAP, new FSCRap());
        mapF.put(ESC.VUE, new FSCVue());
        mapF.put(ESC.OUI, new FSCOui());
        mapF.put(ESC.EQU, new FSCEqu());
        this.mem = mem;
    }

    public StatC getStat(final ESC typeSC) {
        StatC stat = new StatC();
        stat.setType(typeSC);
        stat.setValeur(mapF.get(typeSC).apply(mem));
        return stat;
    }
}
