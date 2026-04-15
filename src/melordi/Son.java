package melordi;

import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;

/**
 * Gère le son des intruments
 * et du programme
 * @author Paul E77
 * @version 1.0
 */
public class Son extends Parent{
    //Les datas
    public Slider slider;
    
    public Son() {
        slider = new Slider(0, 127, 60);
        slider.setOrientation(Orientation.VERTICAL);
        slider.setTranslateY(35);

        ProgressIndicator indicateur = new ProgressIndicator(0.0);
        indicateur.progressProperty().bind(slider.valueProperty().divide(127.0));
        
        this.getChildren().add(slider);
        this.getChildren().add(indicateur);
        this.setTranslateY(260);
        this.setTranslateX(60);

    }
    
}
