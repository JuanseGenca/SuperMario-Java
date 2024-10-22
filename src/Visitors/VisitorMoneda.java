package Visitors;

import Entidades.Mario;

public class VisitorMoneda extends VisitorPowerUp{
    public VisitorMoneda() {
    }
    @Override
    public void visit(Mario m, int direccion) { 
        m.aniadirMoneda();
    }
}
