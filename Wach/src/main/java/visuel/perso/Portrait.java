package visuel.perso;


import java.util.Map.Entry;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import ressource.visuel.Imagier;
import type.stats.ESB;
import type.stats.ESC;
import chose.concept.StatB;
import chose.formule.FSC;
import chose.perso.Membre;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class Portrait extends StackPane {

    /**
     * 
     */
    public Portrait(final Membre membre) {

        // int ratioX = (membre.getCamp() - 1) * 200 + 50;
        // int ratioY = membre.getIdent() * 50 + 10;

        // Text nom = new Text();
        // nom.setText(membre.getNom());

    	Image img = Imagier.getInstance().getRandomMembre();
    	ImageView tete = new ImageView(img);
    	if(membre.getCamp() == 2) {
    	tete.setScaleX(-1);
    	}
    	
        GridPane grid = new GridPane();
        grid.setHgap(4);
        // grid.setVgap(10);
        ColumnConstraints column2 = new ColumnConstraints(50);
        column2.setHalignment(HPos.CENTER);
        grid.getColumnConstraints().add(column2);
        grid.getColumnConstraints().add(new ColumnConstraints(60));
        grid.getColumnConstraints().add(new ColumnConstraints(60));
        // grid.setPadding(new Insets(10, 0, 0, 0));
        // grid.setGridLinesVisible(true);

        grid.setAlignment(Pos.CENTER);
        grid.add(tete, 1, 0, 1, 1);
        grid.getRowConstraints().add(new RowConstraints(20));

        TabPane tabPane = new TabPane();
        tabPane.getStyleClass().add("floating");
        //tabPane.getTabs().add(getPaneBase(membre));
        //tabPane.getTabs().add(getPaneCombat(membre));
        //grid.add(tabPane, 0, 1, 3, 1);
        this.getChildren().addAll(getRectangle(), grid);
    }

    /**
     * TODO : write the method's description
     * 
     * @return
     */
    public Rectangle getRectangle() {
        Rectangle r = new Rectangle();
        r.setX(50);
        r.setY(50);
        r.setWidth(120);
        r.setHeight(120);
        r.setArcWidth(120);
        r.setArcHeight(120);
        r.getStyleClass().add("portrait");

        DropShadow ds1 = new DropShadow();
        ds1.setOffsetY(2.0f);
        ds1.setOffsetX(2.0f);
        ds1.setColor(Color.WHITE);
        r.setEffect(ds1);

        return r;
    }

    /**
     * TODO : write the method's description
     * 
     * @return
     */
    private Tab getPaneBase(final Membre membre) {
        Tab tab = new Tab();
        tab.setText("Base");

        tab.setClosable(false);
        GridPane grid = new GridPane();
        int i = 1;
        for (Entry<ESB, StatB> entryStat : membre.getStatBase().entrySet()) {
            Text uneStat = new Text();
            uneStat.setFont(Font.font("null", FontWeight.MEDIUM, 10));
            uneStat.setText(entryStat.getKey().getCode());
            grid.add(uneStat, 0, i);

            ProgressBar pb = new ProgressBar(new Double(entryStat.getValue().getValeur()) / 100);
            pb.setMinWidth(120);
            // pb.setBorder(Border.EMPTY);
            grid.add(pb, 1, i++, 2, 1);
        }

        tab.setContent(grid);
        return tab;
    }

    /**
     * TODO : write the method's description
     * 
     * @return
     */
    private Tab getPaneCombat(final Membre membre) {
        Tab tab = new Tab();
        tab.setText("Combat");
        tab.setClosable(false);
        GridPane grid = new GridPane();
        FSC fsc = new FSC(membre);
        Text uneStat = new Text();
        uneStat.setFont(Font.font("null", FontWeight.MEDIUM, 10));
        uneStat.setText(ESC.CON.getCode());
        grid.add(uneStat, 0, 1);

        ProgressBar pb = new ProgressBar(new Double(fsc.getStatC(ESC.CON).getValeur()) / 100);
        pb.setMinWidth(120);
        // pb.setBorder(Border.EMPTY);
        grid.add(pb, 1, 1, 2, 1);

        tab.setContent(grid);
        return tab;
    }
}
