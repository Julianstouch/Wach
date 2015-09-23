package visuel.ui;


import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import visuel.perso.Portrait;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class BarAction extends HBox {

    /**
     * 
     */
    public BarAction() {

        // actionBox.getChildren().add(new Text("actions"));
        setAlignment(Pos.CENTER);
        setStyle("-fx-background-color: #336699;");
        setMinHeight(52);

        BorderPane action = new BorderPane();
        Pane pLeft = new Pane();
        pLeft.setMinWidth(7);
        pLeft.getStyleClass().add("actionleft");

        Pane pCentre = new Pane();
        pCentre.getStyleClass().add("actioncentre");

        Pane pRight = new Pane();
        pRight.setMinWidth(7);
        pRight.getStyleClass().add("actionright");

        action.setLeft(pLeft);
        action.setMinWidth(1280);
        action.setCenter(pCentre);
        action.setRight(pRight);

        getChildren().add(action);

    }

    public void afficherAction(final Portrait portrait) {

    }
}
