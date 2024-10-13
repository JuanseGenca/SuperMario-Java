package Plataformas;

import java.awt.image.BufferedImage;
import Logica.Visitor;

public class LadrilloRompible extends Plataforma{
    public LadrilloRompible(int x, int y,BufferedImage[] sprite){
        super(x, y, sprite);
    }
    public void aceptar(Visitor v){
        v.visit(this);
    }
    public void mover(){
        
    }
}
