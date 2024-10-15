package PowerUps;

import GUI.Sprite;
import Logica.Visitor;
public class SuperChampinion extends PowerUp{
    public SuperChampinion(int x, int y,Sprite sprite){
        super(x,y, sprite);
    }
    public void mover(){
        
    }
    public void aceptar(Visitor v){
        v.visit(this);
    }
}
