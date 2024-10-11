package PowerUps;
import Entidades.*;
import Logica.Visitor;
public abstract class PowerUp extends Entidad{
    public PowerUp(int x, int y){
        super(x,y);
    }
     public abstract void aceptar(Visitor visitor);
}
