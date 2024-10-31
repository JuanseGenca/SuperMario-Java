package Visitors;

import Entidades.Mario;
import Estados.EstadoMarioFuego;

public class VisitorFlorDeFuego extends VisitorPowerUp{
    
    public VisitorFlorDeFuego() {
    }

    public void visit(Mario m, int direccion){
        if(m.getEstado().getModificador()!=ConstantesPowerUp.ESTRELLA){
            m.setEstado(new EstadoMarioFuego(m));
        }
    }
}

