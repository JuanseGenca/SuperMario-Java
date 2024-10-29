package Visitors;

import Entidades.Mario;
import Estados.EstadoSuperMario;

public class VisitorSuperChampinion extends VisitorPowerUp {

    public VisitorSuperChampinion() {

    }

    @Override
    public void visit(Mario m, int direccion) {
        if(m.getEstado().getModificador()!=ConstantesPowerUp.ESTRELLA){
            m.setEstado(new EstadoSuperMario(m));
        }
    }
}
