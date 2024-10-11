package Plataformas;

import Entidades.Entidad;
import Logica.Visitor;

public abstract class Plataforma extends Entidad{
    public Plataforma(int x, int y){
        super(x,y);
    }
    public abstract void aceptar(Visitor v);
}
