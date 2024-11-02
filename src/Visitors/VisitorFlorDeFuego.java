package Visitors;

import Entidades.Mario;
import Estados.EstadoMarioFuego;

public class VisitorFlorDeFuego extends VisitorPowerUp{
    
    public VisitorFlorDeFuego() {
    }

    public void visit(Mario mario, int direccion){
        if(mario.getEstado().getModificador()!=ConstantesPowerUp.ESTRELLA){
            mario.setEstado(new EstadoMarioFuego(mario));
        }
    }
}

