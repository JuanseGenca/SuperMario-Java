package Visitors;

import Entidades.Mario;
import Estados.EstadoMarioEstrella;

public class VisitorEstrella extends VisitorPowerUp{
    
    public VisitorEstrella(){
    }

    public void visit(Mario mario, int direccion){
        if(mario.getEstado().getModificador()!=ConstantesPowerUp.ESTRELLA){
            EstadoMarioEstrella aux=new EstadoMarioEstrella(mario);
            aux.setEstadoPrevio(mario.getEstado());
            mario.setEstado(aux); 
        }
       
    }
}

