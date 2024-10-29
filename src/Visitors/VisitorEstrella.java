package Visitors;

import Entidades.Mario;
import Estados.EstadoMarioEstrella;

public class VisitorEstrella extends VisitorPowerUp{
    public VisitorEstrella(){
    }

    @Override
    public void visit(Mario m, int direccion){
        if(m.getEstado().getModificador()!=ConstantesPowerUp.ESTRELLA){
            EstadoMarioEstrella aux=new EstadoMarioEstrella(m);
            aux.setEstadoPrevio(m.getEstado());
            m.setEstado(aux); 
        }
       
    }
}

