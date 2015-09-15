package visuel;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import visuel.ui.Bandeau;
import visuel.ui.Buff;
import visuel.ui.Cadre;

/**
 * TODO Write the class' description
 *
 * @author
 */
public class VisuManager {

	private int largeur = 1270;
	private int hauteur = 920;

	private Bandeau band;
	private Buff buff;
	private Cadre cadre;
	private GridPane gPaneL;
	private VBox gPaneR;

	public VisuManager() {

	}

	public Scene preparerVisuel() {

		buff = new Buff();
		band = new Bandeau();

		BorderPane main = new BorderPane();
		main.setTop(buff);
		main.setBottom(band);

		gPaneL = new GridPane();
		//gPaneL.setMinWidth(600);
		gPaneL.setAlignment(Pos.CENTER_LEFT);
		//gPaneL.setGridLinesVisible(true);
		main.setLeft(gPaneL);

		gPaneR = new VBox();
		gPaneR.setMinWidth(600);
		gPaneR.setAlignment(Pos.TOP_RIGHT);
		//gPaneR.setGridLinesVisible(true);
		main.setRight(gPaneR);

		cadre = new Cadre(main, largeur, hauteur);

		return cadre;
	}

	public void afficherEquipe(int camp) {

		for (int i = 0; i < 5; i++) {
			GridPane memP = new GridPane();
			cadre.ajoutMembre(memP, camp);
			
			GridPane.setConstraints(memP, 0, i);
			if (camp == 1) {
				gPaneL.getChildren().add(memP);
			} else {
				gPaneR.getChildren().add(memP);
			}
		}

	}
}
