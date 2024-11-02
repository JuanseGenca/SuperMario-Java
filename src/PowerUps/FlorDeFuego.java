package PowerUps;

import GUI.Sprite;
import Logica.Visitor;
import Visitors.VisitorFlorDeFuego;

public class FlorDeFuego extends PowerUp{
    
    public FlorDeFuego(int posicionX, int posicionY,Sprite[] sprite){
        super(posicionX, posicionY, sprite);
        visitor=new VisitorFlorDeFuego();
    }

    public void mover(){
        
    }
    
    public void aceptar(Visitor visitor, int direccion){
        visitor.visit(this, direccion);
    }
    
}
