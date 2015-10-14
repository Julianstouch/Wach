package wach;


import javafx.application.Application;
import javafx.stage.Stage;
import processier.deroul.tour.TourManager;
import processier.visu.VisuManager;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class Starting extends Application {

    /**
     * 
     */
    public Starting() {
    }

    public static void main(final String[] args) {
        launch(args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(final Stage primaryStage) throws Exception {

        VisuManager visu = VisuManager.getInstance();
        primaryStage.setTitle("Welcome to WACH - Where Anyone Can Hurt !");
        primaryStage.setScene(visu.preparerVisuel());
        primaryStage.setResizable(false);
        TourManager tm = new TourManager();
        tm.demarrer();
        primaryStage.show();

    }

    // interaction

    // Debut - tous subit un random
    // ESB est fixe
    // ESE est init par template
    // ESD et ESC est init par ESB
    // ESI est random, a tendance vide
    //
    // En action - tous subit des influences
    // Action impact tous sauf ESB
    // ESB regen ESC et ESD
    // ESE agit sur ESD
    //
    // Tendance : pour les stats, la tendance dis si c'est plutot en progression, diminution ou retour à la normal (en +
    // ou en -).
    // Tendance général de l'équipe.
    //
    // Succes : quand une action est réalisé, une évalution est faite pour voir si c'est un succes, un echec ou autre.
    // potentiellement peux se répercuter sur les membres qui ont participé
    //
    // *
    // * -- Aptitudes > modifie la regen des stats,
    // * peut immuniser contre une stats Discipline Patience
    // ********************
    // * -- Classes environnement Météo Lieu
    // *********************
    // * -- Talents Musique Cuisine StripTease Sportif Geek

}
