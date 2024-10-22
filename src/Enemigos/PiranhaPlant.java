package Enemigos;

import GUI.Sprite;
import Logica.Visitor;

public class PiranhaPlant extends Enemigo{
    public PiranhaPlant(int x, int y,Sprite[] sprite){
        super(x,y,sprite);
        puntaje=30;
    }
    
    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }
}
