package PowerUps;

import Entidades.*;
import GUI.Sprite;
import Logica.ConstantesEntidades;
import Logica.Visitor;


public abstract class PowerUp extends Entidad{

    public PowerUp(int x, int y,Sprite[] sprite){
        super(x,y,sprite);
        velocidadX = 2;
        direccion = ConstantesEntidades.DERECHA;
    }
    
    public abstract void aceptar(Visitor visitor, int direccion);
    
    public abstract void mover();

    public void eliminar(){
        ManejadorEntidades.getInstancia().eliminarPowerUp(this);
        miObserver.eliminar();
    }
}
