package Enemigos;

import Entidades.ConstantesEntidades;
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
    }
    @Override
    public abstract void aceptar(Visitor v, int direccion);
    
    public void mover(){
        if(direccion == ConstantesEntidades.DERECHA){
            posicionX += 2;
        }
        if(direccion == ConstantesEntidades.IZQUIERDA){
            posicionX -= 2;
        }
        miObserver.actualizar();
        actualizarHitboxes(posicionX, posicionY, ancho, alto);
        }
    
    
    public void eliminar(){
        ManejadorEntidades.getInstancia().eliminarEnemigo(this);
    }

}

