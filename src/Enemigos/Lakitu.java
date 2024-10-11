package Enemigos;

import Logica.Visitor;

public class Lakitu extends Enemigo{
    public Lakitu(int x, int y){
        super(x,y);
    }
    public void moverDerecha() {
        posicionX += velocidadX;
    }
    
    public void moverIzquierda() {
        posicionX -= velocidadX;
    }
    public void aceptar(Visitor v) {
        v.visit(this);
    }
}
