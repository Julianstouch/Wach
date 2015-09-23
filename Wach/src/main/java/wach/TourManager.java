package wach;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class TourManager extends Application {

    Stage      stage;
    Scene      scene;
    Timeline   tlToRight;
    Timeline   tlToMid;
    Timeline   tlToLeft;
    Timeline   tlToBye;
    int        pos;
    List<Text> listTour;
    double     heightMid;
    double     widthMid;

    /**
     * 
     */
    public TourManager() {

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

    }

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(final Stage stage) {
        stage.show();

        listTour = new ArrayList<Text>();
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

        pos = 0;
        listTour.addAll(Arrays.asList(eventG, evol, recur, conseqG, regen, action, eventA, influ, impact, conseqA, fin));
        listTour.forEach(t -> init(t));
        widthMid = widthMid - 10;
        heightMid = heightMid - 8;

        listTour.forEach(t -> initTrans(t));
        pos = 0;
        scene = new Scene(new Group(), 600, 300);
        scene.getStylesheets().add(this.getClass().getResource("/css/mainscene.css").toExternalForm());
        ObservableList<Node> content = ((Group) scene.getRoot()).getChildren();

        content.addAll(listTour);
        stage.setScene(scene);

        Duration duration = Duration.millis(3);

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
                Text tex = listTour.get(pos - 1);
                PerspectiveTransform pt = (PerspectiveTransform) tex.getEffect();
                pt.setUly(pt.getUly() + (heightMid / 3 / 100));
                pt.setLly(pt.getLly() - (heightMid / 3 / 100));

                pt.setUlx(pt.getUlx() + ((widthMid - (widthMid / 3)) / 100));
                pt.setLlx(pt.getLlx() + ((widthMid - (widthMid / 3)) / 100));

                tex.setTranslateX(tex.getTranslateX() - (widthMid / 100));
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

        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(final MouseEvent event) {
                if (pos < listTour.size() - 1 && !tlToBye.getStatus().equals(Status.RUNNING)) {
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
            };
        });
    }

    /**
     * TODO : write the method's description
     * 
     * @param t
     * @return
     */
    private void init(final Text t) {
        t.setFont(Font.font("null", FontWeight.BOLD, 26));
        t.setFill(Color.RED);
        t.setX(0.0f);
        t.setY(40.0f);
        t.getStyleClass().add("tourtext");

        DropShadow ds1 = new DropShadow();
        ds1.setOffsetY(2.0f);
        ds1.setOffsetX(2.0f);
        ds1.setColor(Color.WHITE);
        t.setEffect(ds1);

        widthMid = t.getBoundsInParent().getWidth() > widthMid ? t.getBoundsInParent().getWidth() : widthMid;
        heightMid = t.getBoundsInParent().getHeight();
    }

    private void initTrans(final Text t) {

        PerspectiveTransform pt = new PerspectiveTransform();
        if (pos == 0) {
            pt.setUlx(t.getX());
            pt.setUly(t.getY() - heightMid);

            pt.setLlx(t.getX());
            pt.setLly(t.getY());

            pt.setUrx(t.getX() + widthMid);
            pt.setUry(t.getY() - heightMid);

            pt.setLrx(t.getX() + widthMid);
            pt.setLry(t.getY());

            t.setTranslateX(100);
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
            t.setTranslateX(100 + widthMid);
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
            t.setTranslateX(100 + widthMid);
            t.setVisible(false);
        }

        t.setEffect(pt);
        pos++;
    }

}
