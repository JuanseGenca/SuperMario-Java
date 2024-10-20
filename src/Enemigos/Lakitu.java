package Enemigos;

import GUI.Sprite;
import Logica.Visitor;

public class Lakitu extends Enemigo{
    public Lakitu(int x, int y,Sprite[] sprite){
        super(x,y,sprite);
    }
   
    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }
}
