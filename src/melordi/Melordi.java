package melordi;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Cette classe représente le programme principale du projet,
 * il fait appel à toute les autres classes, et les autres méthodes
 * et en fin permet l'exécution du projet
 * @author Paul E77
 * @version 1.0
 */
public class Melordi extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MusiCust"); // Le titre du programme
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.setIconified(true);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("images/icon.png"))); // L'icone du programme
        
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500, Color.WHITE);
        
        Instru mon_instru = new Instru();
        
        Clavier mon_clavier = new Clavier(mon_instru);
        root.getChildren().add(mon_clavier);
        
        ChangeInstru mon_changeinstru = new ChangeInstru(mon_instru);
        root.getChildren().add(mon_changeinstru);
        
        Son mon_son = new Son();
        root.getChildren().add(mon_son);
        
        Metronome metro = new Metronome();
        root.getChildren().add(metro);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        mon_clavier.requestFocus();

    }

    /**
     * Le point d'entrer du programme
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
