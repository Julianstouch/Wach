package processier.action;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import ressource.Randomier;
import visuel.perso.Portrait;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class Deplacement {

    public void move(final Portrait port) {

        port.setMoving(true);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(1);

        // action tout les x
        Duration duration = Duration.millis(500);

        // action a faire
        EventHandler<ActionEvent> onFinished = new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent t) {
                // recup coordonnées, actuelle et nouvelle
                double actuelWidth = port.getPos();
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
                        port.movePos(ratio100);
                    }
                };
                final KeyFrame kf = new KeyFrame(duration, onFinished);
                timeline.getKeyFrames().add(kf);

                // action a faire
                EventHandler<ActionEvent> onFinishedMove = new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent t) {
                        port.setMoving(false);
                    }
                };

                timeline.setOnFinished(onFinishedMove);
                timeline.play();
            }
        };

        // ajout du keyframe, et démarrage
        final KeyFrame kf = new KeyFrame(duration, onFinished);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

}
