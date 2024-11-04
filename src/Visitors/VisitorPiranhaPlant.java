package Visitors;

import Enemigos.Enemigo;
import Entidades.*;
import Logica.ConstantesColisiones;

public class VisitorPiranhaPlant extends VisitorEnemigo {

    public VisitorPiranhaPlant(Enemigo enemigo) {
        super(enemigo);
    }

    public void visit(Mario mario, int direccion) { 
        if(direccion == ConstantesColisiones.ARRIBA || direccion == ConstantesColisiones.IZQUIERDA || direccion == ConstantesColisiones.DERECHA) {
            mario.recibirDanio(enemigo.getPuntaje());
        }
    } 
}

