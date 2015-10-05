package visuel.ui;


import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import ressource.Randomier;
import ressource.membre.Membrier;
import ressource.membre.Portrier;
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
        this.getRoot().getStyleClass().add("battleground");
        int imageFond = Randomier.getRandom(1, 5);
        this.getRoot().setStyle("-fx-background-image: url(/images/fond/fond_" + imageFond + ".png);");
    }

    public void ajoutMembre(final GridPane gPane, final int camp) {

        Membre unMembre = Membrier.getInstance().getNouveauMembre(camp);
        Portrait pMem = Portrier.getInstance().getPortrait(unMembre);

        Pane blank = new Pane();
        blank.setMinWidth(Randomier.getRandom(0, 422));
        GridPane.setConstraints(blank, 0, 0);
        GridPane.setConstraints(pMem, 1, 0);
        gPane.getChildren().addAll(pMem, blank);

        // Timeline, se repete.
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);

        // action tout les x
        int randomDuration = Randomier.getRandom(2000, 10000);
        Duration duration = Duration.millis(randomDuration);

        // action a faire
        EventHandler<ActionEvent> onFinished = new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent t) {
                // recup coordonnées, actuelle et nouvelle
                double actuelWidth = blank.getMinWidth();
                double newWidth = Randomier.getRandom(0, 422);
                // ratio de deplacer en 100 unités
                double ratio100 = (newWidth - actuelWidth) / 100;
                // nouvelle animation, s'execute 100 fois pour 100 unités
                Timeline timeline = new Timeline();
                timeline.setCycleCount(100);
                Duration duration = Duration.millis(10);
                EventHandler<ActionEvent> onFinished = new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent t) {
                        // deplacement d'un 100tième de deplacement
                        blank.setMinWidth(blank.getMinWidth() + ratio100);
                    }
                };
                final KeyFrame kf = new KeyFrame(duration, onFinished);
                timeline.getKeyFrames().add(kf);
                timeline.play();
            }
        };

        // ajout du keyframe, et démarrage
        final KeyFrame kf = new KeyFrame(duration, onFinished);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

}
