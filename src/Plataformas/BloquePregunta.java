package Plataformas;

import Entidades.Entidad;
import GUI.Sprite;
import Logica.Visitor;
import Visitors.VisitorBloquePregunta;

public class BloquePregunta extends Plataforma{
    
    protected Entidad entidadContenida;

    public BloquePregunta(int x, int y,Sprite sprite[]){
        super(x, y,sprite);
        visitor=new VisitorBloquePregunta();
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
}
