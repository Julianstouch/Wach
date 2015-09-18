package ressource.tooltip;


import java.lang.reflect.Field;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.control.Tooltip;
import javafx.util.Duration;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class Tooltipier {

    private static Tooltipier instance;

    /**
     * 
     */
    private Tooltipier() {
    }

    public static Tooltipier getInstance() {
        if (instance == null) {
            instance = new Tooltipier();
        }
        return instance;
    }

    public void installTooltip(final String text, final Node cible, final String... cssClass) {
        Tooltip ttip = new Tooltip(text);
        if (cssClass != null) {
            for (int i = 0; i < cssClass.length; i++) {
                ttip.getStyleClass().add(cssClass[i]);
            }
        }

        try {
            Field fieldBehavior = ttip.getClass().getDeclaredField("BEHAVIOR");
            fieldBehavior.setAccessible(true);
            Object objBehavior = fieldBehavior.get(ttip);

            Field fieldTimer = objBehavior.getClass().getDeclaredField("activationTimer");
            fieldTimer.setAccessible(true);
            Timeline objTimer = (Timeline) fieldTimer.get(objBehavior);

            objTimer.getKeyFrames().clear();
            objTimer.getKeyFrames().add(new KeyFrame(new Duration(1)));
        } catch (Exception e) {
        }
        Tooltip.install(cible, ttip);
    }
}
