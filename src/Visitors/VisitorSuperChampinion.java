package Visitors;

import Entidades.Mario;
import Estados.EstadoSuperMario;

public class VisitorSuperChampinion extends VisitorPowerUp {

    public VisitorSuperChampinion() {
    }

    public void visit(Mario mario, int direccion) {
        if(mario.getEstado().getModificador()!=ConstantesPowerUp.ESTRELLA && mario.getEstado().getModificador()!=ConstantesPowerUp.FLORDEFUEGO ){
            mario.setEstado(new EstadoSuperMario(mario));
        }
    }
}
