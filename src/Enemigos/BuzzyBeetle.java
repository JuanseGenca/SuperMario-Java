package Enemigos;

import GUI.Sprite;
import Logica.Visitor;

public class BuzzyBeetle extends Enemigo{
    public BuzzyBeetle(int x, int y,Sprite[] sprites){
        super(x,y,sprites);
    }
   
    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }
}
