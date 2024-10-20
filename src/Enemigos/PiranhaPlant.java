package Enemigos;

import GUI.Sprite;
import Logica.Visitor;

public class PiranhaPlant extends Enemigo{
    public PiranhaPlant(int x, int y,Sprite[] sprite){
        super(x,y,sprite);
    }
    
    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }

    public void mover(){
    }
}
