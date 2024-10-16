package PowerUps;

import Fabricas.SpriteFactory;
import GUI.Sprite;
import Logica.*;

public class Moneda extends PowerUp{
    public Moneda(int x, int y,Sprite sprite, SpriteFactory sf){
        super(x,y, sprite, sf);
    }
    public void mover(){
        
    }
    public void aceptar(Visitor v) {
        v.visit(this);
    }
}
