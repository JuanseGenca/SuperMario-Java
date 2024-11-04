package Enemigos;

import GUI.Sprite;
import Logica.ConstantesEntidades;
import Logica.Visitor;
import Visitors.VisitorPiranhaPlant;

public class PiranhaPlant extends Enemigo{

    private int YMax;
    private int YInicial;
    private boolean sube=true;
    private int counterDelay = 0;
    private final int framesDelay = 120;

    public PiranhaPlant(int x, int y,Sprite[] sprite){
        super(x,y,sprite);
        puntaje=30;
        YInicial = posicionY;
        YMax = YInicial + (int) this.getHitbox().getHeight();
        visitor = new VisitorPiranhaPlant(this);
    }
    
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }

    public void mover() {
        if (counterDelay > 0) {
            counterDelay--;
            return;
        }

        if (sube) {
            posicionY += 2;
            if (posicionY >= YMax) {
                sube = false;
                counterDelay = framesDelay;
            }
        } else {
            posicionY -= 2;
            if (posicionY <= YInicial-8) {
                sube = true;
                counterDelay = framesDelay;
            }
        }

        if (miObserver != null) {
            miObserver.actualizar();
        }

        actualizarHitboxes(posicionX, posicionY-25, ancho, alto);
    }

    public int getZIndex(){
        return ConstantesEntidades.FONDO;
    }

    public void recibirDanio(int puntaje) {
        velocidadX = 0;
        actualizar(direccion, estadoAereo);
     }
}
