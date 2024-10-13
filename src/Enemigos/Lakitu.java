package Enemigos;


import java.awt.image.BufferedImage;
import Logica.Visitor;

public class Lakitu extends Enemigo{
    public Lakitu(int x, int y,BufferedImage[] sprite){
        super(x,y,sprite);
    }
   
    public void aceptar(Visitor v) {
        v.visit(this);
    }
}
