package Enemigos;
import java.awt.image.BufferedImage;
import Logica.Visitor;

public class Spiny extends Enemigo{
    public Spiny(int x, int y,BufferedImage[] sprite){
        super(x,y,sprite);
    }
   
    public void aceptar(Visitor v){
        v.visit(this);
    }
}
