package Enemigos;
import Logica.Visitor;
import java.awt.image.BufferedImage;

public class Spiny extends Enemigo{
    public Spiny(int x, int y,BufferedImage[] sprite){
        super(x,y,sprite);
    }
   
    public void aceptar(Visitor v){
        v.visit(this);
    }
}
