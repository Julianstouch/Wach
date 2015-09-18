package visuel.perso;


import java.util.Map.Entry;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tab;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import ressource.css.CSSier;
import ressource.tooltip.Tooltipier;
import type.stats.ESB;
import type.stats.ESC;
import type.stats.ESD;
import visuel.VisuManager;
import chose.concept.StatB;
import chose.concept.StatC;
import chose.concept.StatD;
import chose.perso.Membre;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class Portrait extends StackPane {

    /** SEP. */
    private static final String SEP = " : ";
    private Membre              membre;
    private Rectangle           rect;
    private Tab                 tabInfo;
    private Tab                 tabBase;
    private Tab                 tabCombat;
    private Tab                 tabDyna;

    /**
     * 
     */
    public Portrait(final Membre pMembre) {

        this.membre = pMembre;
        ImageView tete = new ImageView(membre.getTete());
        if (membre.getCamp() == 2) {
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

        this.getChildren().addAll(getRectangle(), grid);
        Portrait port = this;
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            /**
             * {@inheritDoc}
             */
            @Override
            public void handle(final MouseEvent event) {
                event.consume();
                VisuManager.getInstance().showStat(port);
            }
        });

        generatePaneBase();
        generatePaneCombat();
        generatePaneDyna();
        generatePaneInfo();
    }

    /**
     * TODO : write the method's description
     */
    public Boolean deSelect() {
        rect.getStyleClass().remove(CSSier.PORTRAITSEL);
        rect.getStyleClass().add(CSSier.PORTRAIT);
        return true;
    }

    /**
     * Gets the membre.
     *
     * @return the membre.
     */
    public Membre getMembre() {
        return membre;
    }

    /**
     * 
     * 
     * @return
     */
    public Rectangle getRectangle() {
        if (rect == null) {
            rect = new Rectangle();
            rect.setX(50);
            rect.setY(50);
            rect.setWidth(120);
            rect.setHeight(120);
            rect.setArcWidth(120);
            rect.setArcHeight(120);
            rect.getStyleClass().add(CSSier.PORTRAIT);

            DropShadow ds1 = new DropShadow();
            ds1.setOffsetY(2.0f);
            ds1.setOffsetX(2.0f);
            ds1.setColor(Color.WHITE);
            rect.setEffect(ds1);
        }
        return rect;
    }

    /**
     * Gets the tabBase.
     *
     * @return the tabBase.
     */
    public Tab getTabBase() {
        return tabBase;
    }

    /**
     * Gets the tabCombat.
     *
     * @return the tabCombat.
     */
    public Tab getTabCombat() {
        return tabCombat;
    }

    /**
     * Gets the tabDyna.
     *
     * @return the tabDyna.
     */
    public Tab getTabDyna() {
        return tabDyna;
    }

    /**
     * TODO : write the method's description
     * 
     * @return
     */
    public Tab getTabInfos() {
        return tabInfo;
    }

    /**
     * 
     */
    public void select() {
        rect.getStyleClass().remove(CSSier.PORTRAIT);
        rect.getStyleClass().add(CSSier.PORTRAITSEL);
    }

    /**
     * TODO : write the method's description
     * 
     * @return
     */
    private void generatePaneBase() {
        tabBase = new Tab();
        tabBase.setText("Base");
        tabBase.setClosable(false);
        GridPane grid = new GridPane();

        int i = 1;
        for (Entry<ESB, StatB> entryStat : membre.getStatBase().entrySet()) {
            Text uneStat = new Text();
            uneStat.setFont(Font.font("null", FontWeight.MEDIUM, 12));
            uneStat.setText(entryStat.getKey().getCode());
            grid.add(uneStat, 0, i);

            ProgressBar pb = new ProgressBar(new Double(entryStat.getValue().getValeur() * 5) / 100);
            Tooltipier.getInstance().installTooltip(
                    entryStat.getKey().getCode() + SEP + entryStat.getValue().getValeur(), pb);
            pb.setMinWidth(120);
            grid.add(pb, 1, i++, 2, 1);
        }
        tabBase.setContent(grid);
    }

    /**
     * TODO : write the method's description
     * 
     * @return
     */
    private void generatePaneCombat() {
        tabCombat = new Tab();
        tabCombat.setText("Combat");
        tabCombat.setClosable(false);
        GridPane grid = new GridPane();

        int i = 1;
        for (Entry<ESC, StatC> entryStat : membre.getStatCombat().entrySet()) {
            Text uneStat = new Text();
            uneStat.setFont(Font.font("null", FontWeight.MEDIUM, 12));
            uneStat.setText(entryStat.getKey().getCode());
            grid.add(uneStat, 0, i);

            ProgressBar pb = new ProgressBar(new Double(entryStat.getValue().getValeur()) / 100);
            Tooltipier.getInstance().installTooltip(
                    entryStat.getKey().getCode() + SEP + entryStat.getValue().getValeur(), pb);
            pb.setMinWidth(120);
            grid.add(pb, 1, i++, 2, 1);
        }
        tabCombat.setContent(grid);
    }

    /**
     * TODO : write the method's description
     */
    private void generatePaneDyna() {
        tabDyna = new Tab();
        tabDyna.setText("Dynamique");
        tabDyna.setClosable(false);
        GridPane grid = new GridPane();

        int i = 1;
        for (Entry<ESD, StatD> entryStat : membre.getStatDyna().entrySet()) {
            Text uneStat = new Text();
            uneStat.setFont(Font.font("null", FontWeight.MEDIUM, 12));
            uneStat.setText(entryStat.getKey().getCode());
            grid.add(uneStat, 0, i);

            ProgressBar pb = new ProgressBar(new Double(entryStat.getValue().getValeur()) / 100);
            Tooltipier.getInstance().installTooltip(
                    entryStat.getKey().getCode() + SEP + entryStat.getValue().getValeur(), pb);
            pb.setMinWidth(120);
            grid.add(pb, 1, i++, 2, 1);
        }
        tabDyna.setContent(grid);
    }

    private void generatePaneInfo() {
        tabInfo = new Tab();
        tabInfo.setText("Info");
        tabInfo.setClosable(false);
        GridPane grid = new GridPane();
        Text lNom = new Text("Nom");
        Text lGenre = new Text("Genre");
        Text lMetier = new Text("Job");
        Text nom = new Text(membre.getNom());
        Text genre = new Text(membre.getGenre());
        Text metier = new Text(membre.getMetier());
        grid.getColumnConstraints().add(new ColumnConstraints(80));
        grid.getColumnConstraints().add(new ColumnConstraints(140));
        grid.add(lNom, 0, 0);
        grid.add(lGenre, 0, 1);
        grid.add(lMetier, 0, 2);

        grid.add(nom, 1, 0);
        grid.add(genre, 1, 1);
        grid.add(metier, 1, 2);
        tabInfo.setContent(grid);
    }
}
