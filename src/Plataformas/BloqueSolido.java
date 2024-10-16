package Plataformas;

import Entidades.Entidad;
import Fabricas.SpriteFactory;
import GUI.Sprite;
import Logica.Visitor;

public class BloqueSolido extends BloqueIrrompible{
    public BloqueSolido(int x, int y, Sprite sprite, SpriteFactory sf){
        super(x,y,sprite, sf);
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
