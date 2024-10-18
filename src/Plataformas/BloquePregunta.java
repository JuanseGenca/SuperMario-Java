package Plataformas;

import Entidades.Entidad;
import GUI.Sprite;
import Logica.Visitor;

public class BloquePregunta extends BloqueIrrompible{
    
    public BloquePregunta(int x, int y,Sprite sprite[]){
        super(x, y,sprite);
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
    public void aceptar(Visitor v){
        v.visit(this);
    }
    public void mover(){
        
    }
}
