package Enemigos;

import Entidades.Entidad;
import Logica.Visitor;

public abstract class Enemigo extends Entidad{
    public Enemigo(int x, int y){
        super(x,y);
    }
    public abstract void aceptar(Visitor v);
}
