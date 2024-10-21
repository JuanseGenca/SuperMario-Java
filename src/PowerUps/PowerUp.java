package PowerUps;
import Entidades.*;
import GUI.Sprite;
import Logica.Visitor;


public abstract class PowerUp extends Entidad{
    public PowerUp(int x, int y,Sprite[] sprite){
        super(x,y,sprite);
    }
    @Override
    public abstract void aceptar(Visitor visitor, int direccion);
    
    public void mover(){
        
    }

    public void eliminar(){
        spriteActual = misSprites[1];
        actualizar(direccion, estadoAereo);
        ManejadorEntidades.getInstancia().eliminarPowerUp(this);
    }
}
