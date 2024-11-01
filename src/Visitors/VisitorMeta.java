package Visitors;

import Entidades.Mario;
import Logica.ConstantesEntidades;

public class VisitorMeta extends VisitorPlataforma {
    
    public VisitorMeta() {
    }

    public void visit(Mario m, int direccion) {
        m.actualizar(ConstantesEntidades.QUIETO, m.getEstadoAereo());
        m.siguienteNivel();
    }
}
