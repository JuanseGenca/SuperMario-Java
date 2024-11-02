package PowerUps;

import GUI.Sprite;
import Logica.ConstantesEntidades;
import Logica.Visitor;
import Visitors.VisitorEstrella;

public class Estrella extends PowerUp{
    
    public Estrella(int posicionX, int posicionY,Sprite[] sprite){
        super(posicionX, posicionY, sprite);
        visitor = new VisitorEstrella();
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
