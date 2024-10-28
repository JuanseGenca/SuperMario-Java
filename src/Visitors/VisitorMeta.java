package Visitors;

import Entidades.Mario;

public class VisitorMeta extends VisitorPlataforma {
    
    public VisitorMeta() {
    }

    @Override
    public void visit(Mario m, int direccion) {
        m.siguienteNivel();
    }
}
