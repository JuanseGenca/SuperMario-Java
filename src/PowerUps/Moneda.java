package PowerUps;

import GUI.Sprite;
import Logica.*;
import Visitors.VisitorMoneda;

public class Moneda extends PowerUp{
    public Moneda(int x, int y,Sprite[] sprite){
        super(x,y, sprite);
        visitor = new VisitorMoneda();
        puntaje=5;
    }
    public void mover(){
        
    }
    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }
    
}
