package visuel.perso;


import java.util.ArrayList;
import java.util.List;

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
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import processier.visu.VisuManager;
import ressource.Randomier;
import ressource.css.CSSier;
import ressource.membre.Membrier;
import ressource.tooltip.Tooltipier;
import chose.concept.Stat;
import chose.perso.Membre;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class Portrait extends GridPane {

    /** SEP. */
    private static final String SEP = " : ";
    private static final String ON  = "/";
    private Membre              membre;
    private Rectangle           rect;
    private GridPane            tabInfo;
    private GridPane            tabCombat;
    private GridPane            tabDyna;
    private List<Tab>           tabOthers;
    private Pane                position;
    private boolean             moving;

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
        ColumnConstraints column2 = new ColumnConstraints(50);
        column2.setHalignment(HPos.CENTER);
        grid.getColumnConstraints().add(column2);
        grid.getColumnConstraints().add(new ColumnConstraints(60));
        grid.getColumnConstraints().add(new ColumnConstraints(60));
        grid.setAlignment(Pos.CENTER);
        grid.add(tete, 1, 0, 1, 1);
        grid.getRowConstraints().add(new RowConstraints(20));

        StackPane zoneTete = new StackPane();

        zoneTete.getChildren().addAll(getRectangle(), grid);
        Portrait port = this;
        zoneTete.setOnMouseClicked(new EventHandler<MouseEvent>() {
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

        position = new Pane();
        position.setMinWidth(Randomier.getRandom(0, 422));
        GridPane.setConstraints(position, 0, 0);
        GridPane.setConstraints(zoneTete, 1, 0);
        this.getChildren().addAll(zoneTete, position);
    }

    /**
     * TODO : write the method's description
     */
    public Boolean deSelect() {
        rect.getStyleClass().remove(CSSier.PORTRAIT_SEL);
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
     * Gets the moving.
     *
     * @return the moving.
     */
    public boolean getMoving() {
        return moving;
    }

    public double getPos() {
        return position.getMinWidth();
    }

    /**
     * 
     * 
     * @return
     */
    public Rectangle getRectangle() {
        if (rect == null) {
            rect = new Rectangle(50, 50, 120, 120);
            rect.setArcWidth(120);
            rect.setArcHeight(120);
            rect.getStyleClass().add(CSSier.PORTRAIT);

            DropShadow ds1 = new DropShadow(10.0, 2.0, 2.0, Color.WHITE);
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

    public void movePos(final double newPos) {
        position.setMinWidth(getPos() + newPos);
    }

    /**
     * 
     */
    public void select() {
        if (tabOthers == null)
            generatePaneOther();

        if (!rect.getStyleClass().contains(CSSier.PORTRAIT_SEL) && !rect.getStyleClass().contains(CSSier.PORTRAIT_TOUR)) {
            rect.getStyleClass().add(CSSier.PORTRAIT_SEL);
        }
    }

    /**
     * Sets the moving.
     *
     * @param moving moving.
     */
    public void setMoving(final boolean moving) {
        this.moving = moving;
    }

    /**
     * 
     */
    public void tour() {
        rect.getStyleClass().add(CSSier.PORTRAIT_TOUR);
    }

    /**
     * TODO : write the method's description
     */
    private void generatePane(final List<Stat> listStat, final GridPane tab) {
        int i = 1;
        for (Stat stat : listStat) {
            Text uneStat = new Text();
            uneStat.setFont(Font.font("null", FontWeight.MEDIUM, 12));
            uneStat.setText(stat.getType().getCode());
            tab.add(uneStat, 0, i);

            ProgressBar pb = new ProgressBar(new Double(stat.getValeurRatio()) / 100);
            Tooltipier.getInstance().installTooltip(
                    stat.getType().getCode() + SEP + stat.getValeur() + ON + stat.getMax(), pb);
            pb.setMinWidth(120);
            tab.add(pb, 1, i++, 2, 1);
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
        generatePane(membre.getStatCombat(), tabCombat);
    }

    /**
     * TODO : write the method's description
     */
    private void generatePaneDyna() {
        tabDyna = new GridPane();
        tabDyna.getColumnConstraints().add(new ColumnConstraints(100));
        tabDyna.getColumnConstraints().add(new ColumnConstraints(150));
        generatePane(membre.getStatDyna(), tabDyna);
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
        String categorie = membre.getCategorie();
        Tooltipier.getInstance().installTooltip(categorie, metier);
        gridNom.add(nom, 0, 0);
        gridNom.add(metier, 0, 1);

        tabInfo.add(gridNom, 0, 0);
        // TODO : i = 3
        generatePane(membre.getStatBase(), tabInfo);
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
            generatePane(membre.getStatInter(oMembre), grid);
            tab.setContent(grid);
            tabOthers.add(tab);
        }

    }
}
