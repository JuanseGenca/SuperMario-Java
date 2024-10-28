package Visitors;

import Enemigos.Enemigo;
import Entidades.*;
import Logica.ConstantesColisiones;


public class VisitorPiranhaPlant extends VisitorEnemigo {
    public VisitorPiranhaPlant(Enemigo enemigo) {
        super(enemigo);
    }
    @Override
    public void visit(Mario m, int direccion) { 
        if(direccion == ConstantesColisiones.ARRIBA || direccion == ConstantesColisiones.IZQUIERDA || direccion == ConstantesColisiones.DERECHA) {
            m.recibirDanio(enemigo.getPuntaje());
        }
    } 
}

