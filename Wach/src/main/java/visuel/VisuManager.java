package visuel;


import javafx.event.EventHandler;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import ressource.membre.Membrier;
import ressource.membre.Portrier;
import visuel.perso.Portrait;
import visuel.ui.Bandeau;
import visuel.ui.BarAction;
import visuel.ui.Buff;
import visuel.ui.Cadre;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class VisuManager {

    private static VisuManager instance;
    private int                largeur = 1270;

    private int                hauteur = 920;
    private Bandeau            band;
    private Buff               buff;
    private Cadre              cadre;
    private GridPane           gPaneL;
    private BarAction          actionBox;
    private GridPane           gPaneR;

    private VisuManager() {

    }

    public static VisuManager getInstance() {
        if (instance == null) {
            instance = new VisuManager();
        }
        return instance;
    }

    public void afficherEquipe(final int camp) {

        for (int i = 0; i < 5; i++) {
            GridPane memP = new GridPane();
            // memP.setGridLinesVisible(true);
            cadre.ajoutMembre(memP, camp);

            GridPane.setConstraints(memP, 0, i);
            if (camp == 1) {
                gPaneL.getChildren().add(memP);
            } else {
                gPaneR.getChildren().add(memP);
            }
        }

    }

    public Scene preparerVisuel() {

        buff = new Buff();
        band = new Bandeau();
        actionBox = new BarAction();

        band.setTop(actionBox);

        BorderPane main = new BorderPane();
        main.setTop(buff);
        main.setBottom(band);

        gPaneL = new GridPane();
        gPaneL.setAlignment(Pos.TOP_RIGHT);
        main.setLeft(gPaneL);

        gPaneR = new GridPane();
        gPaneR.setAlignment(Pos.TOP_RIGHT);
        gPaneR.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        main.setRight(gPaneR);

        cadre = new Cadre(main, largeur, hauteur);
        cadre.setOnMouseClicked(new EventHandler<MouseEvent>() {
            /**
             * {@inheritDoc}
             */
            @Override
            public void handle(final MouseEvent event) {
                event.consume();
                gererSelection(null);
            }
        });

        afficherEquipe(1);
        afficherEquipe(2);
        Membrier.getInstance().getAllMembre().stream().forEach(e -> e.initStatI());
        return cadre;
    }

    public void showStat(final Portrait portrait) {
        this.gererSelection(portrait);
        band.afficherStats(portrait);
    }

    /**
     * TODO : write the method's description
     * 
     * @param portrait
     */
    private void gererSelection(final Portrait portrait) {
        if (portrait != null) {
            for (Portrait autre : Portrier.getInstance().getAllPortraitBut(portrait)) {
                autre.deSelect();
            }
            portrait.select();
        } else {
            Portrier.getInstance().getAllPortrait().stream().forEach(e -> e.deSelect());
            band.cacherStats();
        }
    }
}
