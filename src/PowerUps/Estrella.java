package PowerUps;

import Fabricas.SpriteFactory;
import GUI.Sprite;
import Logica.Visitor;

public class Estrella extends PowerUp{
    public Estrella(int x, int y,Sprite sprite, SpriteFactory sf){
        super(x,y, sprite, sf);
    }
    public void mover(){

    }
    
    public void aceptar(Visitor v){
        v.visit(this);
    }
}
