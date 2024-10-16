package Enemigos;
import Logica.Visitor;
import Fabricas.SpriteFactory;
import GUI.Sprite;

public class Spiny extends Enemigo{
    public Spiny(int x, int y,Sprite sprite, SpriteFactory sf){
        super(x,y,sprite, sf);
    }
   
    public void aceptar(Visitor v){
        v.visit(this);
    }
}
