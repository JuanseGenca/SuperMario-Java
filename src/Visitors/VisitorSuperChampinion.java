package Visitors;

import Entidades.Mario;
import Estados.EstadoSuperMario;

public class VisitorSuperChampinion extends VisitorPowerUp {

    public VisitorSuperChampinion() {

    }

    @Override
    public void visit(Mario m, int direccion) {
        m.setEstado(new EstadoSuperMario(m));
    }
}
