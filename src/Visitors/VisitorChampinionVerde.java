package Visitors;

import Entidades.Mario;

public class VisitorChampinionVerde extends VisitorPowerUp{

    public VisitorChampinionVerde(){
    }
    
    public void visit(Mario m, int direccion){ 
        m.aniadirVida();
    }
}
