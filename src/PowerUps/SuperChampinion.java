package PowerUps;

public class SuperChampinion extends PowerUp{
    public SuperChampinion(int x, int y){
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
