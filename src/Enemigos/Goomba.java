package Enemigos;
import java.awt.image.BufferedImage;
import Logica.*;

public class Goomba extends Enemigo{
    public Goomba(int x, int y,BufferedImage[] sprite){
        super(x,y,sprite);
    }
    
    public void aceptar(Visitor v){
        v.visit(this);
    }
}
