package Visitors;

import Entidades.Mario;
import Estados.EstadoSuperMario;

public class VisitorSuperChampinion extends VisitorPowerUp {

    public VisitorSuperChampinion() {
    }

    public void visit(Mario m, int direccion) {
        if(m.getEstado().getModificador()!=ConstantesPowerUp.ESTRELLA && m.getEstado().getModificador()!=ConstantesPowerUp.FLORDEFUEGO ){
            m.setEstado(new EstadoSuperMario(m));
        }
    }
}
