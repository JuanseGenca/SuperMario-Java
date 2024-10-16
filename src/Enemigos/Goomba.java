package Enemigos;

import Fabricas.SpriteFactory;
import GUI.Sprite;
import Logica.*;

public class Goomba extends Enemigo{
    public Goomba(int x, int y,Sprite sprite, SpriteFactory sf){
        super(x,y,sprite, sf);
    }
    
    public void aceptar(Visitor v){
        v.visit(this);
    }
}
