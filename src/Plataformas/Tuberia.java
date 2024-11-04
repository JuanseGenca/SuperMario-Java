package Plataformas;

import Entidades.Entidad;
import GUI.Sprite;
import Logica.Visitor;

public class Tuberia extends BloqueIrrompible{
    
    public Tuberia(int posicionX ,int posicionY,Sprite sprite[]){
        super(posicionX,posicionY,sprite);
        miHitboxes.actualizarHitboxes(posicionX, posicionY-144, ancho, alto);
    }

    public Entidad getEntidadContenida(){
        return entidadContenida;
    }

    public void setEntidadContenida(Entidad entidad){
        entidadContenida = entidad;
    }

    public void mostrarEntidadContenida(){}

    public void OcultarEntidad(){}

    public void aceptar(Visitor visitor, int direccion){
        visitor.visit(this, direccion);
    }

}
