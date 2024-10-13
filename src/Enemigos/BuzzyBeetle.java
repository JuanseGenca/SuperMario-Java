package Enemigos;
import Logica.Visitor;

public class BuzzyBeetle extends Enemigo{
    public BuzzyBeetle(int x, int y,BufferedImage[] misSprites){
        super(x,y,sprite);
    }
   
    public void aceptar(Visitor v){
        v.visit(this);
    }
}
