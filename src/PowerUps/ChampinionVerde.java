package PowerUps;

import GUI.Sprite;
import Logica.Visitor;

public class ChampinionVerde extends PowerUp{
    public ChampinionVerde(int x, int y,Sprite[] sprite){
        super(x,y, sprite);
    }
    public void mover(){
        
    }
    public void aceptar(Visitor v){
        v.visit(this);
    }
}
