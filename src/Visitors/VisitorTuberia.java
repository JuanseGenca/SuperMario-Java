package Visitors;

import Entidades.Mario;
import Logica.ConstantesColisiones;

public class VisitorTuberia extends VisitorPlataforma{
    
    public VisitorTuberia(){
        
    }
    
    @Override
    public void visit(Mario m, int direccion){
        if(direccion == ConstantesColisiones.LATERAL){
            m.setVelocidadX(0);
        }
        if(direccion == ConstantesColisiones.ABAJO){
            m.setVelocidadY(0);
        }
        if(direccion == ConstantesColisiones.ARRIBA){
            m.tocoSuelo();
        }
    }
}
