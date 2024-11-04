package PowerUps;

import GUI.Sprite;
import Logica.*;
import Visitors.VisitorMoneda;

public class Moneda extends PowerUp{
    
    public Moneda(int posicionX, int posicionY,Sprite[] sprite){
        super(posicionX, posicionY, sprite);
        visitor = new VisitorMoneda();
        puntaje=5;
    }
    
    public void mover(){
    }
    
    public void aceptar(Visitor visitor, int direccion){
        visitor.visit(this, direccion);
    }
    
}
