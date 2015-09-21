package visuel.perso;


import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import ressource.css.CSSier;
import ressource.membre.Membrier;
import ressource.tooltip.Tooltipier;
import type.stats.ESB;
import type.stats.ESC;
import type.stats.ESD;
import type.stats.ESI;
import visuel.VisuManager;
import chose.concept.StatB;
import chose.concept.StatC;
import chose.concept.StatD;
import chose.concept.StatI;
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
    private GridPane            tabInfo;
    private GridPane            tabCombat;
    private GridPane            tabDyna;
    private List<Tab>           tabOthers;

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

        generatePaneCombat();
        generatePaneDyna();
        generatePaneInfo();
    }

    /**
     * TODO : write the method's description
     */
    public Boolean deSelect() {
        rect.getStyleClass().remove(CSSier.PORTRAITSEL);
        // rect.getStyleClass().add(CSSier.PORTRAIT);
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
     * Gets the tabCombat.
     *
     * @return the tabCombat.
     */
    public GridPane getTabCombat() {
        return tabCombat;
    }

    /**
     * Gets the tabDyna.
     *
     * @return the tabDyna.
     */
    public GridPane getTabDyna() {
        return tabDyna;
    }

    /**
     * TODO : write the method's description
     * 
     * @return
     */
    public GridPane getTabInfos() {
        return tabInfo;
    }

    public List<Tab> getTabOthers() {
        return tabOthers;
    }

    /**
     * 
     */
    public void select() {
        if (tabOthers == null)
            generatePaneOther();

        if (!rect.getStyleClass().contains(CSSier.PORTRAITSEL)) {
            rect.getStyleClass().add(CSSier.PORTRAITSEL);
        }
    }

    /**
     * TODO : write the method's description
     * 
     * @return
     */
    private void generatePaneCombat() {
        tabCombat = new GridPane();
        tabCombat.getColumnConstraints().add(new ColumnConstraints(100));
        tabCombat.getColumnConstraints().add(new ColumnConstraints(150));
        int i = 1;
        for (Entry<ESC, StatC> entryStat : membre.getStatCombat().entrySet()) {
            Text uneStat = new Text();
            uneStat.setFont(Font.font("null", FontWeight.MEDIUM, 12));
            uneStat.setText(entryStat.getKey().getCode());
            tabCombat.add(uneStat, 0, i);

            ProgressBar pb = new ProgressBar(new Double(entryStat.getValue().getValeur()) / 100);
            Tooltipier.getInstance().installTooltip(
                    entryStat.getKey().getCode() + SEP + entryStat.getValue().getValeur(), pb);
            pb.setMinWidth(120);
            tabCombat.add(pb, 1, i++, 2, 1);
        }
    }

    /**
     * TODO : write the method's description
     */
    private void generatePaneDyna() {
        tabDyna = new GridPane();
        tabDyna.getColumnConstraints().add(new ColumnConstraints(100));
        tabDyna.getColumnConstraints().add(new ColumnConstraints(150));
        int i = 1;
        for (Entry<ESD, StatD> entryStat : membre.getStatDyna().entrySet()) {
            Text uneStat = new Text();
            uneStat.setFont(Font.font("null", FontWeight.MEDIUM, 12));
            uneStat.setText(entryStat.getKey().getCode());
            tabDyna.add(uneStat, 0, i);

            ProgressBar pb = new ProgressBar(new Double(entryStat.getValue().getValeur()) / 100);
            Tooltipier.getInstance().installTooltip(
                    entryStat.getKey().getCode() + SEP + entryStat.getValue().getValeur(), pb);
            pb.setMinWidth(120);
            tabDyna.add(pb, 1, i++, 2, 1);
        }
    }

    private void generatePaneInfo() {
        tabInfo = new GridPane();
        tabInfo.getRowConstraints().add(new RowConstraints(50));
        tabInfo.getColumnConstraints().add(new ColumnConstraints(70));
        tabInfo.getColumnConstraints().add(new ColumnConstraints(150));

        GridPane gridNom = new GridPane();
        ColumnConstraints colCons = new ColumnConstraints(210);
        colCons.setHalignment(HPos.CENTER);
        gridNom.getColumnConstraints().add(colCons);
        String genre = membre.getGenre().getPrefix();
        Text nom = new Text(genre + membre.getNom());
        Text metier = new Text(membre.getMetier());
        nom.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        metier.setFont(Font.font("Arial", FontWeight.MEDIUM, FontPosture.ITALIC, 14));
        gridNom.add(nom, 0, 0);
        gridNom.add(metier, 0, 1);

        tabInfo.add(gridNom, 0, 0);
        int i = 3;
        for (Entry<ESB, StatB> entryStat : membre.getStatBase().entrySet()) {
            Text uneStat = new Text();
            uneStat.setFont(Font.font("null", FontWeight.MEDIUM, 12));
            uneStat.setText(entryStat.getKey().getCode());
            tabInfo.add(uneStat, 0, i);

            ProgressBar pb = new ProgressBar(new Double(entryStat.getValue().getValeur() * 5) / 100);
            Tooltipier.getInstance().installTooltip(
                    entryStat.getKey().getCode() + SEP + entryStat.getValue().getValeur(), pb);
            pb.setMinWidth(120);
            tabInfo.add(pb, 1, i++, 2, 1);
        }
    }

    private void generatePaneOther() {
        tabOthers = new ArrayList<Tab>();
        List<Membre> listOther = Membrier.getInstance().getAllMembreBut(membre);

        for (Membre oMembre : listOther) {
            Tab tab = new Tab();
            StringBuilder nom = new StringBuilder(oMembre.getNom());
            tab.setText(nom.length() > 14 ? nom.substring(0, 14) : nom.toString());
            tab.setClosable(false);
            GridPane grid = new GridPane();
            int i = 1;
            for (Entry<ESI, StatI> entryStat : membre.getStatInter().get(oMembre).entrySet()) {
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
            tab.setContent(grid);
            tabOthers.add(tab);
        }

    }
}
