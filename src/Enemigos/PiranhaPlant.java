package Enemigos;

import Fabricas.SpriteFactory;
import GUI.Sprite;
import Logica.Visitor;

public class PiranhaPlant extends Enemigo{
    public PiranhaPlant(int x, int y,Sprite sprite, SpriteFactory sf){
        super(x,y,sprite, sf);
    }
    
    public void aceptar(Visitor v){
        v.visit(this);
    }
}
