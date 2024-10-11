package Plataformas;

import Entidades.Entidad;
import Logica.Visitor;

public class BloquePregunta extends BloqueIrrompible{
    
    public BloquePregunta(int x, int y){
        super(x, y);
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
    @Override
    public void moverDerecha(){
        throw new UnsupportedOperationException("Unimplemented method 'moverDerecha'");
    }
    @Override
    public void moverIzquierda() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moverIzquierda'");
    }
}
