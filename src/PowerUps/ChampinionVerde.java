package PowerUps;

import GUI.Sprite;
import Logica.ConstantesEntidades;
import Logica.Visitor;
import Visitors.VisitorChampinionVerde;

public class ChampinionVerde extends PowerUp{
    
    public ChampinionVerde(int x, int y,Sprite[] sprite){
        super(x,y, sprite);
        visitor = new VisitorChampinionVerde();
        puntaje=100;
    }

    public void mover(){
        if(direccion == ConstantesEntidades.DERECHA){
            posicionX += velocidadX;
        }
        if(direccion == ConstantesEntidades.IZQUIERDA){
            posicionX -= velocidadX;
        }
        
        actualizarHitboxes(posicionX, posicionY, ancho, alto);
        miObserver.actualizar();

        if(getEstadoAereo() == ConstantesEntidades.AIRE) {
            actualizarVelocidadY();
        }
    }
    
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }
    
}
