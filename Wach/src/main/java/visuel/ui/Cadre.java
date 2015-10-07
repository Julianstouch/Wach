package visuel.ui;


import java.util.List;

import javafx.scene.Parent;
import javafx.scene.Scene;
import ressource.Randomier;
import visuel.perso.Portrait;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class Cadre extends Scene {

    private List<Portrait> listePort;

    /**
     * 
     */
    public Cadre(final Parent parent, final double sizeX, final double sizeY) {

        super(parent, sizeX, sizeY);
        this.getStylesheets().add(this.getClass().getResource("/css/mainscene.css").toExternalForm());
        this.getRoot().getStyleClass().add("battleground");
        int imageFond = Randomier.getRandom(1, 5);
        this.getRoot().setStyle("-fx-background-image: url(/images/fond/fond_" + imageFond + ".png);");
    }
}
