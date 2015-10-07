package visuel.ui;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
import ressource.css.CSSier;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class Derouleur extends StackPane {

    Timeline   tlToRight;
    Timeline   tlToMid;
    Timeline   tlToLeft;
    Timeline   tlToBye;
    int        pos;
    List<Text> listTour;
    double     heightMid;
    double     widthMid;
    boolean    started;

    // // général
    // Event général : météo, crs, chutte d'objet, pompier et jet d'eau
    // Evolution de l'environnement
    // Application des récurrents et effets
    // Conséquence sur les membres
    // // perso dont c'est le tour
    // Mise à jour des stats du perso : regen
    //
    // -> Attente de l'action du perso : au clic ou action auto
    //
    // // exécution de l'action
    // Event d'action : event d'action générique + suivant le type d'action
    // Influence sur l'action par les facteurs
    // Impact de l'action
    // Conséquence de l'action
    /**
     * 
     */
    public Derouleur() {

        started = false;

        listTour = new ArrayList<Text>();
        Text debut = new Text("  Démarrer   ");
        Text eventG = new Text(" Evénement  ");
        Text evol = new Text(" Evolution  ");
        Text recur = new Text(" Récurrents ");
        Text conseqG = new Text("Conséquences");
        Text regen = new Text("Régénération");
        Text action = new Text("   Action   ");
        Text eventA = new Text(" Evénement  ");
        Text influ = new Text(" Influences ");
        Text impact = new Text("   Impact   ");
        Text conseqA = new Text("Conséquences");
        Text fin = new Text("    Fin     ");

        listTour.addAll(Arrays.asList(debut, eventG, evol, recur, conseqG, regen, action, eventA, influ, impact,
                conseqA, fin));
        initAll();
        started = true;
        Duration duration = Duration.millis(1);

        tlToRight = new Timeline();
        tlToRight.setCycleCount(100);
        EventHandler<ActionEvent> onFinishedR = new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent act) {
                if (pos + 1 < listTour.size()) {
                    Text tex = listTour.get(pos + 1);
                    PerspectiveTransform pt = (PerspectiveTransform) tex.getEffect();

                    pt.setUlx(pt.getUlx() - (widthMid / 3 / 100));
                    pt.setLlx(pt.getLlx() - (widthMid / 3 / 100));

                    pt.setUly(pt.getUly() - (heightMid / 2 / 100));
                    pt.setLly(pt.getLly() + (heightMid / 2 / 100));

                    pt.setUry(pt.getUry() - (heightMid / 6 / 100));
                    pt.setLry(pt.getLry() + (heightMid / 6 / 100));
                }
            }
        };
        KeyFrame kfr = new KeyFrame(duration, onFinishedR);
        tlToRight.getKeyFrames().add(kfr);

        tlToMid = new Timeline();
        tlToMid.setCycleCount(100);
        EventHandler<ActionEvent> onFinishedM = new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent act) {
                Text tex = listTour.get(pos);
                PerspectiveTransform pt = (PerspectiveTransform) tex.getEffect();

                pt.setUry(pt.getUry() - (heightMid / 3 / 100));
                pt.setLry(pt.getLry() + (heightMid / 3 / 100));

                pt.setUrx(pt.getUrx() + ((widthMid - (widthMid / 3)) / 100));
                pt.setLrx(pt.getLrx() + ((widthMid - (widthMid / 3)) / 100));

                tex.setTranslateX(tex.getTranslateX() - (widthMid / 100));
            }
        };
        KeyFrame kfm = new KeyFrame(duration, onFinishedM);
        tlToMid.getKeyFrames().add(kfm);

        tlToLeft = new Timeline();
        tlToLeft.setCycleCount(100);
        EventHandler<ActionEvent> onFinishedL = new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent act) {
                if (pos > 0) {
                    Text tex = listTour.get(pos - 1);
                    PerspectiveTransform pt = (PerspectiveTransform) tex.getEffect();
                    pt.setUly(pt.getUly() + (heightMid / 3 / 100));
                    pt.setLly(pt.getLly() - (heightMid / 3 / 100));

                    pt.setUlx(pt.getUlx() + ((widthMid - (widthMid / 3)) / 100));
                    pt.setLlx(pt.getLlx() + ((widthMid - (widthMid / 3)) / 100));

                    tex.setTranslateX(tex.getTranslateX() - (widthMid / 100));
                }
            }
        };
        KeyFrame kfl = new KeyFrame(duration, onFinishedL);
        tlToLeft.getKeyFrames().add(kfl);

        tlToBye = new Timeline();
        tlToBye.setCycleCount(100);
        EventHandler<ActionEvent> onFinishedB = new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent act) {
                if (pos - 2 > -1) {
                    Text tex = listTour.get(pos - 2);
                    PerspectiveTransform pt = (PerspectiveTransform) tex.getEffect();

                    pt.setUrx(pt.getUrx() - (widthMid / 3 / 100));
                    pt.setLrx(pt.getLrx() - (widthMid / 3 / 100));

                    pt.setUly(pt.getUly() + (heightMid / 6 / 100));
                    pt.setLly(pt.getLly() - (heightMid / 6 / 100));

                    pt.setUry(pt.getUry() + (heightMid / 2 / 100));
                    pt.setLry(pt.getLry() - (heightMid / 2 / 100));
                }
            }
        };
        KeyFrame kfb = new KeyFrame(duration, onFinishedB);
        tlToBye.getKeyFrames().add(kfb);

        Rectangle rect = new Rectangle();
        rect.setX(-2);
        rect.setY(8);
        rect.setWidth(widthMid + 3);
        rect.setHeight(heightMid);
        rect.setArcWidth(20);
        rect.setArcHeight(20);
        rect.getStyleClass().add(CSSier.PORTRAIT);

        DropShadow ds1 = new DropShadow();
        ds1.setOffsetY(2.0f);
        ds1.setOffsetX(2.0f);
        ds1.setColor(Color.WHITE);
        rect.setEffect(ds1);

        Pane gp = new Pane();
        gp.getChildren().add(rect);
        gp.getChildren().addAll(listTour);
        this.getChildren().addAll(gp);
    }

    // Déroule l'étape du tour
    public void deroule() {
        if (!tlToBye.getStatus().equals(Status.RUNNING)) {
            if (pos == listTour.size() - 1) {
                initAll();
            } else {
                pos++;
                // hide all, sauf les 3 visible
                for (int i = 0; i < listTour.size(); i++) {
                    if (i >= pos - 2 && i <= pos + 1) {
                        listTour.get(i).setVisible(true);
                    } else {
                        listTour.get(i).setVisible(false);
                    }
                }
                tlToRight.play();
                tlToMid.play();
                tlToLeft.play();
                tlToBye.play();
            }
        }
    }

    /**
     * Gets the widthMid.
     *
     * @return the widthMid.
     */
    public double getWidthMid() {
        return widthMid;
    }

    /**
     * TODO : write the method's description
     */
    private void initAll() {
        Consumer<Text> con = t -> {
            t.setX(0.0f);
            t.setY(40.0f);

            if (!started) {
                t.setFont(Font.font("null", FontWeight.BOLD, 26));
                t.setFill(Color.RED);
                t.getStyleClass().add("tourtext");
                t.setCache(true);
                widthMid = t.getBoundsInLocal().getWidth() > widthMid ? t.getBoundsInLocal().getWidth() : widthMid;
                heightMid = t.getBoundsInLocal().getHeight();
            }
        };

        listTour.forEach(con);
        pos = 0;
        listTour.forEach(this::initTrans);
        pos = 0;
    }

    private void initTrans(final Text t) {

        PerspectiveTransform pt;
        if (!started) {
            pt = new PerspectiveTransform();
        } else {
            pt = (PerspectiveTransform) t.getEffect();
        }

        if (pos == 0) {
            pt.setUlx(t.getX());
            pt.setUly(t.getY() - heightMid);

            pt.setLlx(t.getX());
            pt.setLly(t.getY());

            pt.setUrx(t.getX() + widthMid);
            pt.setUry(t.getY() - heightMid);

            pt.setLrx(t.getX() + widthMid);
            pt.setLry(t.getY());

            t.setTranslateX(0);
            t.setVisible(true);
        } else if (pos == 1) {
            pt.setUlx(t.getX());
            pt.setLlx(t.getX());
            pt.setUrx(t.getX() + widthMid / 3);
            pt.setLrx(t.getX() + widthMid / 3);

            pt.setUly(t.getY() - heightMid);
            pt.setLly(t.getY());
            pt.setUry(t.getY() - heightMid + (heightMid / 3));
            pt.setLry(t.getY() - heightMid / 3);
            t.setTranslateX(widthMid);
            t.setVisible(true);
        } else {
            pt.setUlx(t.getX() + widthMid / 3);
            pt.setLlx(t.getX() + widthMid / 3);
            pt.setUrx(t.getX() + widthMid / 3);
            pt.setLrx(t.getX() + widthMid / 3);

            pt.setUly(t.getY() - heightMid / 2);
            pt.setLly(t.getY() - heightMid / 2);
            pt.setUry(t.getY() - heightMid / 2);
            pt.setLry(t.getY() - heightMid / 2);
            t.setTranslateX(widthMid);
            t.setVisible(false);
        }

        if (!started) {
            t.setEffect(pt);
        }
        pos++;
    }
}
