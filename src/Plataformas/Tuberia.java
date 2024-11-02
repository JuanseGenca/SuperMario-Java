package Plataformas;

import Entidades.Entidad;
import GUI.Sprite;
import Logica.Visitor;
import Visitors.VisitorTuberia;

public class Tuberia extends BloqueIrrompible{
    
    public Tuberia(int posicionX ,int posicionY,Sprite sprite[]){
        super(posicionX,posicionY,sprite);
        visitor= new VisitorTuberia();
        miHitboxes.actualizarHitboxes(posicionX, posicionY-144, ancho, alto);
    }

    public Entidad getEntidadContenida(){
        return entidadContenida;
    }

    public void setEntidadContenida(Entidad entidad){
        entidadContenida = entidad;
    }

    public void mostrarEntidadContenida(){
        //Resolver como mostrarla por pantalla.
    }

    public void OcultarEntidad(){
        //Resolver como esconderla por pantalla.
    }

    public void aceptar(Visitor visitor, int direccion){
        visitor.visit(this, direccion);
    }

    public void mover(){
    }

}
