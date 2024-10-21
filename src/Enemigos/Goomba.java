package Enemigos;

import GUI.Sprite;
import Logica.*;

public class Goomba extends Enemigo{

    public Goomba(int x, int y,Sprite[] sprite){
        super(x,y,sprite);
        puntaje=60;
    }
    
    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }
   
}
