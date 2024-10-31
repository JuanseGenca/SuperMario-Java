package Visitors;

import Enemigos.*;
import Entidades.Mario;
import Logica.ConstantesColisiones;

public class VisitorSpiny extends VisitorEnemigo{

    public VisitorSpiny(Enemigo enemigo) {
        super(enemigo);
    }

    public void visit(Mario m, int direccion) { 
        if(direccion == ConstantesColisiones.ARRIBA||direccion == ConstantesColisiones.IZQUIERDA || direccion == ConstantesColisiones.DERECHA) {
            m.recibirDanio(enemigo.getPuntaje());
        }
    }
}
