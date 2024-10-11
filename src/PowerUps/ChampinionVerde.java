package PowerUps;
import Logica.Visitor;

public class ChampinionVerde extends PowerUp{
    public ChampinionVerde(int x, int y){
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
