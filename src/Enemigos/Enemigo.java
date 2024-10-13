package Enemigos;

import Entidades.Entidad;
import GUI.Sprite;
import Logica.Visitor;

public abstract class Enemigo extends Entidad{
    public Enemigo(int x, int y,Sprite sprite){
        super(x,y,sprite);
    }
    public abstract void aceptar(Visitor v);
    
    public void mover(){

    }
    
}
