package PowerUps;
import Entidades.*;
import GUI.Sprite;
import Logica.Visitor;


public abstract class PowerUp extends Entidad{
    public PowerUp(int x, int y,Sprite sprite){
        super(x,y,sprite);
    }
    public abstract void aceptar(Visitor visitor);
    
    public void mover(){
        if(direccion == 15001){
            posicionY+=velocidadY;
        }
        if(direccion == 15001){
            posicionY-=velocidadY;
        }
        if(direccion == 15002){
            posicionX-= velocidadX;
        }
        if(direccion == 15003){
            posicionX+= velocidadX;
        }
        aplicarGravedad();
    }
}
