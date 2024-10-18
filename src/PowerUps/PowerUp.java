package PowerUps;
import Entidades.*;
import GUI.Sprite;
import Logica.Visitor;


public abstract class PowerUp extends Entidad{
    public PowerUp(int x, int y,Sprite[] sprite){
        super(x,y,sprite);
    }
    public abstract void aceptar(Visitor visitor);
    
    public void mover(){
        
    }
}
