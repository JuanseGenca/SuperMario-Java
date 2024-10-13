package PowerUps;

import java.awt.image.BufferedImage;
import Logica.*;

public class Moneda extends PowerUp{
    public Moneda(int x, int y,BufferedImage[] sprite){
        super(x,y, sprite);
    }
    public void mover(){
        
    }
    public void aceptar(Visitor v) {
        v.visit(this);
    }
}
