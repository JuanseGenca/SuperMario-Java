package Enemigos;

import Fabricas.SpriteFactory;
import GUI.Sprite;
import Logica.Visitor;

public class Lakitu extends Enemigo{
    public Lakitu(int x, int y,Sprite sprite, SpriteFactory sf){
        super(x,y,sprite, sf);
    }
   
    public void aceptar(Visitor v) {
        v.visit(this);
    }
}
