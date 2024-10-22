package Visitors;

import Entidades.Mario;
import Estados.EstadoMarioFuego;

public class VisitorFlorDeFuego extends VisitorPowerUp{
    public VisitorFlorDeFuego() {
    }

    @Override
    public void visit(Mario m, int direccion){
            m.setEstado(new EstadoMarioFuego(m)); 
    }
}

