package Enemigos;

import GUI.Sprite;
import Logica.Visitor;

public class Lakitu extends Enemigo{
    public Lakitu(int x, int y,Sprite sprite){
        super(x,y,sprite);
    }
   
    public void aceptar(Visitor v) {
        v.visit(this);
    }
}
