package Enemigos;
import Logica.Visitor;

public class Spiny extends Enemigo{
    public Spiny(int x, int y){
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
