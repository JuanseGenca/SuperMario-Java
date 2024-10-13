package Enemigos;

import java.awt.image.BufferedImage;
import Logica.Visitor;

public class BuzzyBeetle extends Enemigo{
    public BuzzyBeetle(int x, int y,BufferedImage[] sprites){
        super(x,y,sprites);
    }
   
    public void aceptar(Visitor v){
        v.visit(this);
    }
}
