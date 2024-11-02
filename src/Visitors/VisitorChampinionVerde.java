package Visitors;

import Entidades.Mario;

public class VisitorChampinionVerde extends VisitorPowerUp{

    public VisitorChampinionVerde(){
    }
    
    public void visit(Mario mario, int direccion){ 
        mario.aniadirVida();
    }
}
