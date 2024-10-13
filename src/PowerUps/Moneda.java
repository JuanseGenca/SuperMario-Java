package PowerUps;
import GUI.Sprite;
import Logica.*;

public class Moneda extends PowerUp{
    public Moneda(int x, int y,Sprite sprite){
        super(x,y, sprite);
    }
    public void mover(){
        
    }
    public void aceptar(Visitor v) {
        v.visit(this);
    }
}
