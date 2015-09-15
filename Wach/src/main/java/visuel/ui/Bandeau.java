package visuel.ui;


import javafx.geometry.Pos;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import visuel.perso.Portrait;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class Bandeau extends BorderPane {

    private HBox statbox;
    private HBox actionBox;

    /**
     * 
     */
    public Bandeau() {

        actionBox = new HBox();
        // actionBox.getChildren().add(new Text("actions"));
        actionBox.setAlignment(Pos.CENTER);
        actionBox.setStyle("-fx-background-color: #336699;");
        actionBox.setMinHeight(52);

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

        actionBox.getChildren().add(action);
        this.setTop(actionBox);

        statbox = new HBox();
        statbox.getChildren().add(new Text("stats"));
        statbox.setStyle("-fx-background-color: #996633;");
        statbox.setMinHeight(160);
        this.setBottom(statbox);
    }

    public void afficherStats(final Portrait portrait) {

        statbox.getChildren().clear();
        GridPane grid = new GridPane();
        TabPane tabPane = new TabPane();
        tabPane.getStyleClass().add("floating");
        tabPane.getTabs().add(portrait.getPaneBase());
        tabPane.getTabs().add(portrait.getPaneCombat());
        grid.add(tabPane, 0, 0);

        statbox.getChildren().add(grid);
    }
}
