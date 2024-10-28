package Enemigos;

import GUI.Sprite;
import Logica.ConstantesEntidades;
import Logica.Visitor;
import Visitors.VisitorPiranhaPlant;

public class PiranhaPlant extends Enemigo{
    private int YMax;
    private int YInicial;
    private boolean sube=true;
    public PiranhaPlant(int x, int y,Sprite[] sprite){
        super(x,y,sprite);
        puntaje=30;
        YInicial = posicionY;
        YMax = YInicial + (int) this.getHitbox().getHeight();
        visitor = new VisitorPiranhaPlant(this);
    }
    
    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }

    @Override
    public void mover(){
        if(sube){
            posicionY+= 2;
            if(posicionY == YMax) sube=false;
        }else{
            posicionY-=2;
            if(posicionY == YInicial) sube=true;
        }

        if(miObserver!=null){
            miObserver.actualizar();
        }
        
        actualizarHitboxes(posicionX, posicionY, ancho, alto);
    }

    @Override
    public int getZIndex(){
        return ConstantesEntidades.FONDO;
    }

    @Override
    public void recibirDanio(int puntaje) {
        velocidadX = 0;
        actualizar(direccion, estadoAereo);
     }
}
