package Enemigos;

import java.awt.image.BufferedImage;
import Entidades.Entidad;
import Logica.Visitor;

public abstract class Enemigo extends Entidad{
    public Enemigo(int x, int y, BufferedImage[] sprite){
        super(x,y,sprite);
    }
    public abstract void aceptar(Visitor v);
    
    public void mover(){
        if(direccion == 15001){
            posicionY+=velocidadY;
        }
        if(direccion == 15001){
            posicionY-=velocidadY;
        }
        if(direccion == 15002){
            posicionX-= velocidadX;
        }
        if(direccion == 15003){
            posicionX+= velocidadX;
        }
        aplicarGravedad();
    }
    
}
