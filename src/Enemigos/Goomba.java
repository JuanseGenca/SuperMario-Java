package Enemigos;
import GUI.Sprite;
import Logica.*;

public class Goomba extends Enemigo{
    public Goomba(int x, int y,Sprite sprite){
        super(x,y,sprite);
    }
    
    public void aceptar(Visitor v){
        v.visit(this);
    }
}
