package Enemigos;
import GUI.Sprite;
import Logica.ConstantesEntidades;
import Logica.Visitor;

public class Spiny extends Enemigo{
    protected int dirTickAnterior;
    public Spiny(int x, int y,Sprite[] sprite){
        super(x,y,sprite);
        puntaje=60;
        estadoAereo = ConstantesEntidades.AIRE;
        dirTickAnterior = ConstantesEntidades.IZQUIERDA;
    }
   
    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }

    @Override
    public void mover(){
        
        moverX();
        if(direccion == ConstantesEntidades.DERECHA){
            posicionX += velocidadX;
        }
        if(direccion == ConstantesEntidades.IZQUIERDA){
            posicionX -= velocidadX;
        }
        actualizar(direccion, estadoAereo);
        miHitboxes.actualizarHitboxes(posicionX, posicionY, ancho, alto);
        if(getEstadoAereo() == ConstantesEntidades.AIRE) {
            actualizarVelocidadY();
        }
        
    }

    private void actualizarVelocidadY() {
        double velInicialSalto = 11;
        double gravedad = -0.2;
        double velTerminal = -8;
        double velYActual = velocidadY;
        
        if (tocandoSuelo) {
            velYActual = velInicialSalto;
            tocandoSuelo = false;
        } else {
            velYActual = Math.max(velYActual + gravedad, velTerminal);
            if (miHitboxes.getHitbox().getY() < 0) {
                velYActual = 0;
                posicionY = 0;
                tocandoSuelo = true;
                estadoAereo = ConstantesEntidades.SUELO;
                posicionY = posicionY + 0;
            }
        }

        velocidadY = velYActual;
    }

    private void moverX() {
        if(direccion != ConstantesEntidades.QUIETO || estadoAereo == ConstantesEntidades.AIRE) {
            if(direccion==ConstantesEntidades.IZQUIERDA) {
                posicionX-=velocidadX;
                dirTickAnterior = ConstantesEntidades.IZQUIERDA;
                if (posicionX < 0) {
                    posicionX = 0;
                }
            } else if(direccion==ConstantesEntidades.DERECHA) {
                posicionX+=velocidadX;
                dirTickAnterior = ConstantesEntidades.DERECHA;
            }

            if(estadoAereo == ConstantesEntidades.AIRE) {
                posicionY += velocidadY;
            }
        }else{
            direccion = ConstantesEntidades.QUIETO;
        }
    }

    @SuppressWarnings("override")
    public void recibirDanio(int puntaje) {
        velocidadX = 0;
        spriteActual = misSprites[0];
        actualizar(direccion, estadoAereo);
     }
}
