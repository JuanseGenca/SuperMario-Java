package Entidades;
import Logica.*;
import Plataformas.Plataforma;
import java.awt.image.BufferedImage;

public class Mario extends Entidad{
    protected EstadoMario estado;
    protected Logica miLogica;

    public Mario(int x, int y,BufferedImage[] sprite){
        super(x,y,sprite);
    }
    //Hay que ver si conviene ponerlo en mario y para cada entidad mover() se comporta de forma diferente
    //O si conviene hacer mover() en clase entidad y que todas se muevan igual.
    public void mover(){
        if(direccion == 15000){
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
        miObserver.actualizar();
    }

    

    public void saltar(){
        posicionY += velocidadY;
        miObserver.actualizar();
    }

    public void recibirDanio(){
        estado.recibirDanio();
    }
    public void disparar(){
        estado.disparar();
    }
    //¿Hace falta?
    public void chocarBloque(Plataforma bloque){
        
    }
    public void aceptar(Visitor v){
        v.visit(this);
    }
}
