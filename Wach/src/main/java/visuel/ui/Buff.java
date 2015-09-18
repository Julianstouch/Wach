package visuel.ui;


import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ressource.tooltip.Tooltipier;
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

        Tooltipier.getInstance().installTooltip("Buff", vBuff, "bttip");

        Image debuff = Imagier.getInstance().getImage(EIMG.bufftest2);
        ImageView vDeBuff = new ImageView(debuff);

        Tooltipier.getInstance().installTooltip("Max Debuff", vDeBuff, "dttip");

        cBox.getChildren().addAll(vBuff, vDeBuff);

        bPane.setLeft(lBox);
        bPane.setRight(rBox);
        bPane.setCenter(cBox);

        this.getChildren().add(bPane);
    }

}
