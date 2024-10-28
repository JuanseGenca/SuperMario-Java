package Plataformas;

import Entidades.Entidad;
import Entidades.ManejadorEntidades;
import GUI.Sprite;
import Logica.Visitor;

public abstract class Plataforma extends Entidad{
    public Plataforma(int x, int y, Sprite[] sprite){
        super(x,y,sprite);
    }
    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }

    public void eliminar(){
        spriteActual = misSprites[1];
        actualizar(direccion, estadoAereo);
        ManejadorEntidades.getInstancia().eliminarPlataforma(this);
        miObserver.eliminar();
    }
}
