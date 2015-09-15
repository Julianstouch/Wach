package visuel.ui;


import java.lang.reflect.Field;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import ressource.visuel.EIMG;
import ressource.visuel.Imagier;


/**
 * TODO Write the class' description
 *
 * @author
*/
public class Buff extends HBox {

    /**
     * 
     */
    public Buff() {

        this.setAlignment(Pos.TOP_CENTER);
        // this.setStyle("-fx-background-color: #44FF88;");
        this.setMinHeight(52);

        BorderPane bPane = new BorderPane();

        VBox lBox = new VBox();
        lBox.setMinWidth(300);

        VBox rBox = new VBox();
        rBox.setMinWidth(300);

        HBox cBox = new HBox();
        cBox.setMinWidth(300);
        cBox.setStyle("-fx-background-color: #44FF88;");
        cBox.setAlignment(Pos.CENTER);
        Image buff = Imagier.getInstance().getImage(EIMG.bufftest1);
        ImageView vBuff = new ImageView(buff);
        Tooltip bttip = new Tooltip("Buff");
        bttip.getStyleClass().add("bttip");
        Tooltip.install(vBuff, bttip);

        Image debuff = Imagier.getInstance().getImage(EIMG.bufftest2);
        ImageView vDeBuff = new ImageView(debuff);
        Tooltip dttip = new Tooltip("Max Debuff");
        dttip.getStyleClass().add("dttip");

        Tooltip.install(vDeBuff, dttip);
        try {
            Field fieldBehavior = bttip.getClass().getDeclaredField("BEHAVIOR");
            fieldBehavior.setAccessible(true);
            Object objBehavior = fieldBehavior.get(bttip);

            Field fieldTimer = objBehavior.getClass().getDeclaredField("activationTimer");
            fieldTimer.setAccessible(true);
            Timeline objTimer = (Timeline) fieldTimer.get(objBehavior);

            objTimer.getKeyFrames().clear();
            objTimer.getKeyFrames().add(new KeyFrame(new Duration(1)));
        } catch (Exception e) {
        }

        cBox.getChildren().addAll(vBuff, vDeBuff);

        bPane.setLeft(lBox);
        bPane.setRight(rBox);
        bPane.setCenter(cBox);

        this.getChildren().add(bPane);
    }

}
