package visuel.ui;


import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import visuel.perso.Portrait;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class Bandeau extends BorderPane {

    private HBox statbox;

    /**
     * 
     */
    public Bandeau() {

        statbox = new HBox();
        statbox.setStyle("-fx-background-color: #f4f4f4;");
        statbox.setMinHeight(160);
        this.setBottom(statbox);
    }

    public void afficherStats(final Portrait portrait) {

        cacherStats();
        GridPane grid = new GridPane();

        // TabPane tabPaneI = new TabPane();
        // tabPaneI.getStyleClass().add("floating");
        // tabPaneI.getTabs().add(portrait.getTabInfos());
        //
        // TabPane tabPaneB = new TabPane();
        // tabPaneB.getStyleClass().add("floating");
        // tabPaneB.getTabs().add(portrait.getTabBase());
        //
        // TabPane tabPaneC = new TabPane();
        // tabPaneC.getStyleClass().add("floating");
        // tabPaneC.getTabs().add(portrait.getTabCombat());
        //
        // TabPane tabPaneD = new TabPane();
        // tabPaneD.getStyleClass().add("floating");
        // tabPaneD.getTabs().add(portrait.getTabDyna());
        //
        TabPane tabPaneO = new TabPane();
        tabPaneO.getStyleClass().add("floating");
        tabPaneO.getTabs().addAll(portrait.getTabOthers());

        grid.add(portrait.getTabInfos(), 0, 0);
        grid.add(portrait.getTabCombat(), 1, 0);
        grid.add(portrait.getTabDyna(), 2, 0);
        grid.add(tabPaneO, 3, 0);

        statbox.getChildren().add(grid);
    }

    /**
     * TODO : write the method's description
     */
    public void cacherStats() {
        statbox.getChildren().clear();
    }
}
