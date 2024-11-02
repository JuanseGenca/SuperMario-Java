package Plataformas;

import Entidades.Entidad;
import Entidades.ManejadorEntidades;
import GUI.Sprite;
import Logica.Visitor;

public abstract class Plataforma extends Entidad{
    
    public Plataforma(int posicionX ,int posicionY,Sprite sprite[]){
        super(posicionX,posicionY,sprite);
    }
    
    public void aceptar(Visitor visitor, int direccion){
        visitor.visit(this, direccion);
    }

    public void eliminar(){
        spriteActual = misSprites[1];
        actualizar(direccion, estadoAereo);
        ManejadorEntidades.getInstancia().eliminarPlataforma(this);
        miObserver.eliminar();
    }
}
