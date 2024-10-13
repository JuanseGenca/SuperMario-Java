package Enemigos;
import GUI.Sprite;
import Logica.Visitor;

public class Spiny extends Enemigo{
    public Spiny(int x, int y,Sprite sprite){
        super(x,y,sprite);
    }
   
    public void aceptar(Visitor v){
        v.visit(this);
    }
}
