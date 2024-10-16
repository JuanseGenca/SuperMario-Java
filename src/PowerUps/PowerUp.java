package PowerUps;
import Entidades.*;
import Fabricas.SpriteFactory;
import GUI.Sprite;
import Logica.Visitor;


public abstract class PowerUp extends Entidad{
    public PowerUp(int x, int y,Sprite sprite, SpriteFactory sf){
        super(x,y,sprite, sf);
    }
    public abstract void aceptar(Visitor visitor);
    
    public void mover(){
        
    }
}
