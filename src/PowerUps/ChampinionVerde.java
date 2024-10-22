package PowerUps;

import GUI.Sprite;
import Logica.Visitor;
import Visitors.VisitorChampinionVerde;

public class ChampinionVerde extends PowerUp{
    public ChampinionVerde(int x, int y,Sprite[] sprite){
        super(x,y, sprite);
        visitor = new VisitorChampinionVerde();
        puntaje=100;
    }
    public void mover(){
        
    }
    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }
    
}
