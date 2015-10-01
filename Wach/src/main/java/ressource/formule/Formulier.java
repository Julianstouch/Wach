package ressource.formule;


import java.util.HashMap;
import java.util.Map;

import type.stats.EStat;
import chose.formule.Formule;
import chose.formule.sb.FSBase;
import chose.formule.sc.FSCAss;
import chose.formule.sc.FSCCal;
import chose.formule.sc.FSCCap;
import chose.formule.sc.FSCEqu;
import chose.formule.sc.FSCFoc;
import chose.formule.sc.FSCHab;
import chose.formule.sc.FSCMor;
import chose.formule.sc.FSCOui;
import chose.formule.sc.FSCRap;
import chose.formule.sc.FSCVue;
import chose.formule.sd.FSDDef;
import chose.formule.sd.FSDNrj;
import chose.formule.sd.FSDPsy;
import chose.formule.sd.FSDRes;
import chose.formule.si.FSICon;
import chose.formule.si.FSISym;
import chose.formule.si.FSITec;
import chose.perso.Membre;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class Formulier {

    private static Formulier                     instance;

    private Map<EStat, Class<? extends Formule>> mapF;

    /**
     * 
     */
    private Formulier() {
        mapF = new HashMap<EStat, Class<? extends Formule>>();

        mapF.put(EStat.SAN, FSBase.class);
        mapF.put(EStat.FOR, FSBase.class);
        mapF.put(EStat.SOU, FSBase.class);
        mapF.put(EStat.MEN, FSBase.class);
        mapF.put(EStat.INT, FSBase.class);
        mapF.put(EStat.END, FSBase.class);

        mapF.put(EStat.ASS, FSCAss.class);
        mapF.put(EStat.CAL, FSCCal.class);
        mapF.put(EStat.CAP, FSCCap.class);
        mapF.put(EStat.FOC, FSCFoc.class);
        mapF.put(EStat.HAB, FSCHab.class);
        mapF.put(EStat.MOR, FSCMor.class);
        mapF.put(EStat.RAP, FSCRap.class);
        mapF.put(EStat.VUE, FSCVue.class);
        mapF.put(EStat.OUI, FSCOui.class);
        mapF.put(EStat.EQU, FSCEqu.class);

        mapF.put(EStat.NRJ, FSDNrj.class);
        mapF.put(EStat.PSY, FSDPsy.class);
        mapF.put(EStat.RES, FSDRes.class);
        mapF.put(EStat.DEF, FSDDef.class);

        mapF.put(EStat.SYM, FSISym.class);
        mapF.put(EStat.CON, FSICon.class);
        mapF.put(EStat.TEC, FSITec.class);
    }

    public static Formulier getInstance() {
        if (instance == null) {
            instance = new Formulier();
        }
        return instance;
    }

    public Formule getNewFormule(final EStat eStat, final Membre proprio) {
        Formule formu = null;
        try {
            formu = mapF.get(eStat).newInstance();
            formu.init(proprio, null);
        } catch (InstantiationException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            // LOGGER.error("", e);
        }
        return formu;
    }

    public Formule getNewFormule(final EStat eStat, final Membre proprio, final Integer initVal) {
        Formule formu = null;
        try {
            formu = mapF.get(eStat).newInstance();
            formu.init(proprio, initVal);
        } catch (InstantiationException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            // LOGGER.error("", e);
        }
        return formu;
    }
}
