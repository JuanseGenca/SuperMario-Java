package Visitors;

import Entidades.Mario;
import Logica.ConstantesEntidades;

public class VisitorMeta extends VisitorPlataforma {
    
    public VisitorMeta() {
    }

    public void visit(Mario mario, int direccion) {
        mario.actualizar(ConstantesEntidades.QUIETO, mario.getEstadoAereo());
        mario.siguienteNivel();
    }
    
}
