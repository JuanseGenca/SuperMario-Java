package Plataformas;

import Entidades.Entidad;
import GUI.Sprite;
import Logica.Visitor;
import Visitors.VisitorTuberia;

public class Tuberia extends BloqueIrrompible{
    

    public Tuberia(int x, int y, Sprite[] sprite){
        super(x, y, sprite);
        visitor= new VisitorTuberia();
        miHitboxes.actualizarHitboxes(x, y-144, ancho, alto);
    }

    public Entidad getEntidadContenida(){
        return entidadContenida;
    }
    public void setEntidadContenida(Entidad e){
        entidadContenida = e;
    }
    public void mostrarEntidadContenida(){
        //Resolver como mostrarla por pantalla.
    }
    public void OcultarEntidad(){
        //Resolver como esconderla por pantalla.
    }
    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }
    public void mover(){
        
    }

    @Override
    public void recibirDanio(int puntaje) {}
}
