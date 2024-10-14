package Enemigos;
import Logica.Visitor;

import GUI.Sprite;

public class Spiny extends Enemigo{
    public Spiny(int x, int y,Sprite sprite){
        super(x,y,sprite);
    }
   
    public void aceptar(Visitor v){
        v.visit(this);
    }
}
