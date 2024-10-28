package Enemigos;

import Logica.ConstantesEntidades;
import Entidades.Entidad;
import Entidades.ManejadorEntidades;
import GUI.Sprite;
import Logica.Visitor;
import Visitors.VisitorEnemigo;

public abstract class Enemigo extends Entidad{
    public Enemigo(int x, int y, Sprite[] sprite){
        super(x,y,sprite);
        visitor = new VisitorEnemigo();
        direccion = ConstantesEntidades.DERECHA;
        velocidadX = 2;
    }
    @Override
    public abstract void aceptar(Visitor v, int direccion);
    
    @Override
    public void mover(){
    
        if(direccion == ConstantesEntidades.DERECHA){
            posicionX += velocidadX;
        }
        if(direccion == ConstantesEntidades.IZQUIERDA){
            posicionX -= velocidadX;
        }
        if(miObserver!=null) {
            miObserver.actualizar();
        }
        actualizarHitboxes(posicionX, posicionY, ancho, alto);
    }
    
    
    public void eliminar(){
        ManejadorEntidades.getInstancia().eliminarEnemigo(this);
        miObserver.eliminar();
    }

}

