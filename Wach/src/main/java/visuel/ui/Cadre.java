package visuel.ui;


import java.util.ArrayList;
import java.util.List;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import ressource.RandomUtil;
import ressource.template.ETMP;
import ressource.template.Templier;
import visuel.perso.Portrait;
import chose.perso.Membre;


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
        this.getRoot().getStyleClass().add("mainroot");
    }

    public void ajoutMembre(final GridPane gPane, int camp) {
        Membre first = Templier.getInstance().getNouveauMembre(ETMP.test);
        first.setCamp(camp);
        Portrait pMem = new Portrait(first);        
        GridPane.setConstraints(pMem, 1, 0);

        Pane blank = new Pane();
        blank.setMinWidth(RandomUtil.getRandomIndex(0, 422));
        GridPane.setConstraints(blank, 0, 0);
        
        gPane.getChildren().addAll(pMem, blank);

    }
   
}
