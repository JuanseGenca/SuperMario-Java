package Enemigos;

import Entidades.Entidad;
import Entidades.ManejadorEntidades;
import GUI.Sprite;
import Logica.ConstantesEntidades;
import Logica.Visitor;
import Visitors.VisitorEnemigo;

public abstract class Enemigo extends Entidad{

    public boolean cayoAlVacio;

    public Enemigo(int x, int y, Sprite[] sprite){
        super(x,y,sprite);
        velocidadX = 2;
        velocidadY = 4;
        direccion = ConstantesEntidades.DERECHA;
        tocandoSuelo = true;
        cayoAlVacio = false;
        visitor = new VisitorEnemigo(this);
    }
    
    public abstract void aceptar(Visitor v, int direccion);
    
    public void mover(){
        
        if(direccion == ConstantesEntidades.DERECHA){
            posicionX += velocidadX;
        }

        if(direccion == ConstantesEntidades.IZQUIERDA){
            posicionX -= velocidadX;
        }
        
        if(tocandoSuelo == false) {
            actualizarVelocidadY();
        }

        actualizarHitboxes(posicionX, posicionY, ancho, alto);
        if(miObserver!=null) {
            miObserver.actualizar(direccion,ConstantesEntidades.SUELO);
        }

    }
    
    public void aplicarGravedad() {
        tocandoSuelo = false;
    }

    public void tocoSuelo() {
        posicionY += 2;
        tocandoSuelo = true;
    }

    public void actualizarVelocidadY() {
       
        posicionY -= velocidadY;
        
        if (miHitboxes.getHitbox().getY() < 0 && !cayoAlVacio) {
            posicionY = 0;
            tocandoSuelo = true;
            }

        if(posicionY < -200){
            eliminar();
        }
    }

    public void eliminar(){
        ManejadorEntidades.getInstancia().eliminarEnemigo(this);
        miObserver.eliminar();
    }

}

