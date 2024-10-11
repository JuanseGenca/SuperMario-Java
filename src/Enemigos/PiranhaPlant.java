package Enemigos;

public class PiranhaPlant extends Enemigo{
    public PiranhaPlant(int x, int y){
        super(x,y);
    }
    public void moverDerecha() {
        posicionX += velocidadX;
    }
    
    public void moverIzquierda() {
        posicionX -= velocidadX;
    }
    public void aceptar(Visitor v){
        v.visit(this);
    }
}
