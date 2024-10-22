package Visitors;

import Entidades.Mario;
import Logica.ConstantesColisiones;

public class VisitorBloquePregunta extends VisitorPlataforma{
    public VisitorBloquePregunta(){
    }
    @Override
    public void visit(Mario m, int direccion){
        if(direccion == ConstantesColisiones.LATERAL){
            m.setVelocidadX(0);
        }
        if(direccion == ConstantesColisiones.ABAJO){
            if(m.getVelocidadY() >= 0) 
                m.setVelocidadY(0);
        }
        if(direccion == ConstantesColisiones.ARRIBA){
            m.tocoSuelo();
        }
    }
}
