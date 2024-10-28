package PowerUps;

import GUI.Sprite;
import Logica.ConstantesEntidades;
import Logica.Visitor;
import Visitors.VisitorEstrella;

public class Estrella extends PowerUp{
    
    public Estrella(int x, int y,Sprite[] sprite){
        super(x,y, sprite);
        visitor = new VisitorEstrella();
    }

    public void mover(){
        if(direccion == ConstantesEntidades.DERECHA){
            posicionX += velocidadX;
        }
        if(direccion == ConstantesEntidades.IZQUIERDA){
            posicionX -= velocidadX;
        }
        if(miObserver!=null) {
            miObserver.actualizar();
        }
        actualizarHitboxes(posicionX, posicionY, ancho, alto);
    }
    
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }
    
}
