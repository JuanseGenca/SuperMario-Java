package PowerUps;

import Entidades.*;
import GUI.Sprite;
import Logica.ConstantesEntidades;
import Logica.Visitor;


public abstract class PowerUp extends Entidad{
    
    public boolean cayoAlVacio;

    public PowerUp(int posicionX, int posicionY,Sprite[] sprite){
        super(posicionX, posicionY, sprite);
        velocidadX = 2;
        velocidadY = 4;
        direccion = ConstantesEntidades.DERECHA;
        tocandoSuelo = true;
        cayoAlVacio = false;
    }
    
    public abstract void aceptar(Visitor visitor, int direccion);
    
    public abstract void mover();

    public void eliminar(){
        ManejadorEntidades.getInstancia().eliminarPowerUp(this);
        miObserver.eliminar();
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

}
