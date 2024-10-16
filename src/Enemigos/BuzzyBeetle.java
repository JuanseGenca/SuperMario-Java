package Enemigos;


import Fabricas.SpriteFactory;
import GUI.Sprite;
import Logica.Visitor;

public class BuzzyBeetle extends Enemigo{
    public BuzzyBeetle(int x, int y,Sprite sprites, SpriteFactory sf){
        super(x,y,sprites, sf);
    }
   
    public void aceptar(Visitor v){
        v.visit(this);
    }
}
