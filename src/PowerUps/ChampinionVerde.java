package PowerUps;

import GUI.Sprite;
import Logica.ConstantesEntidades;
import Logica.Visitor;
import Visitors.VisitorChampinionVerde;

public class ChampinionVerde extends PowerUp{
    
    public ChampinionVerde(int posicionX ,int posicionY,Sprite[] sprite){
        super(posicionX,posicionY, sprite);
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
        
        if(tocandoSuelo == false) {
            actualizarVelocidadY();
        }

        actualizarHitboxes(posicionX, posicionY, ancho, alto);
        if(miObserver!=null) {
            miObserver.actualizar();
        }
    }
    
    public void aceptar(Visitor visitor, int direccion){
        visitor.visit(this, direccion);
    }
    
}
