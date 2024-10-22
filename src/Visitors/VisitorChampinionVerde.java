package Visitors;

import Entidades.Mario;

public class VisitorChampinionVerde extends VisitorPowerUp{
    public VisitorChampinionVerde(){
    }
    @Override
    public void visit(Mario m, int direccion){ 
        m.aniadirVida();
    }
}
