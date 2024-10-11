package Enemigos;

public abstract class KoopaTroopa extends Enemigo{
    //Atributos
    protected Estado estadoKoopaTroopa;

    public KoopaTroopa(int x, int y){
        super(x, y);
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
