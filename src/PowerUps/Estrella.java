package PowerUps;
import java.awt.image.BufferedImage;
import Logica.Visitor;

public class Estrella extends PowerUp{
    public Estrella(int x, int y,BufferedImage[] sprite){
        super(x,y, sprite);
    }
    public void mover(){

    }
    
    public void aceptar(Visitor v){
        v.visit(this);
    }
}
