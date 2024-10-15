package PowerUps;

import GUI.Sprite;
import Logica.Visitor;

public class Estrella extends PowerUp{
    public Estrella(int x, int y,Sprite sprite){
        super(x,y, sprite);
    }
    public void mover(){

    }
    
    public void aceptar(Visitor v){
        v.visit(this);
    }
}
