package processier.visu;


import javafx.event.EventHandler;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import processier.action.Deplacement;
import ressource.membre.Membrier;
import visuel.perso.Portrait;
import visuel.ui.Bandeau;
import visuel.ui.BarAction;
import visuel.ui.Buff;
import visuel.ui.Cadre;
import chose.perso.Membre;


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

            Membre unMembre = Membrier.getInstance().getNouveauMembre(camp);
            Portrait pMem = unMembre.getSonPortrait();

            GridPane.setConstraints(pMem, 0, i);
            if (camp == 1) {
                gPaneL.getChildren().add(pMem);
            } else {
                gPaneR.getChildren().add(pMem);
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
                showStat(null);
            }
        });

        afficherEquipe(1);
        afficherEquipe(2);
        Membrier.getInstance().getAllMembre().stream().forEach(e -> e.initStatI());
        return cadre;
    }

    public void showStat(final Portrait portrait) {
        Portrait current = portrait != null ? portrait : Membrier.getInstance().getMembre(1).getSonPortrait();
        this.gererSelection(current);
        band.afficherStats(current);
    }

    /**
     * TODO : write the method's description
     * 
     * @param portrait
     */
    private void gererSelection(final Portrait portrait) {
        Membrier.getInstance().getAllPortrait().forEach(e -> e.deSelect());
        portrait.select();
        if (!portrait.getMoving()) {
            new Deplacement().move(portrait);
        }

    }
}
