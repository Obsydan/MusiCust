package melordi;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Gère les touche du clavier sous leurs fronts
 * (la couleur, les effets, le font etc.)
 * @author Paul E77
 * @version 1.0
 */
public class Touche extends Parent{
    
    //Les datas
    public String lettre = new String("X");
    private int positionX = 0;
    private int positionY = 0;
    private int note = 0;
    private final Instru instru;//on déclare un objet de type Instru
    Rectangle fond_touche = new Rectangle(75,75,Color.WHITE);
    Text lettre_touche = new Text();
    
    //Le construct
    public Touche(String l, int posX, int posY, int n, Instru ins){
        lettre = l;
        positionX = posX;
        positionY = posY;
        note = n;
        instru = ins;//l'objet de type instru prend la valeur de l'objet passé en paramètre


        fond_touche.setArcHeight(10);
        fond_touche.setArcWidth(10);
        this.getChildren().add(fond_touche);
        lettre_touche.setText(lettre);
        lettre_touche.setFont(new Font(25));
        lettre_touche.setFill(Color.GREY);
        lettre_touche.setX(25);
        lettre_touche.setY(45);
        this.getChildren().add(lettre_touche);

        this.setTranslateX(positionX);//positionnement de la touche sur le clavier
        this.setTranslateY(positionY);
        
        //Les evenement
        this.setOnMouseEntered(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent me){
                fond_touche.setFill(Color.LIGHTGREY);
            }
        });
        
        this.setOnMouseExited(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent me) {
                fond_touche.setFill(Color.WHITE);
            }  
        });
        
        
        //Le clic souris 
        this.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent me){
                appuyer();
            }
        });
        
        this.setOnMouseReleased(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                relacher();
            }
        });
        
    }
    
    //Le clic souris
   public void appuyer(){
        fond_touche.setFill(Color.DARKGREY);
        this.setTranslateY(positionY+2);
        instru.note_on(note);
    }

   public void relacher(){
        fond_touche.setFill(Color.WHITE);
        this.setTranslateY(positionY);
        instru.note_off(note);
    }
  
}
