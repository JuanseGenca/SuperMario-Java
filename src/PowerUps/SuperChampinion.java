package PowerUps;

import java.awt.image.BufferedImage;
import Logica.Visitor;
public class SuperChampinion extends PowerUp{
    public SuperChampinion(int x, int y,BufferedImage[] sprite){
        super(x,y, sprite);
    }
    public void mover(){
        
    }
    public void aceptar(Visitor v){
        v.visit(this);
    }
}
