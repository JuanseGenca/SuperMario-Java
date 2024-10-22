package Visitors;

import Entidades.Mario;
import Logica.ConstantesColisiones;

public class VisitorMeta extends VisitorPlataforma {
    
    public VisitorMeta() {
    }

    @Override
    public void visit(Mario m, int direccion) {
        if (direccion == ConstantesColisiones.ARRIBA) {
            //Aca hace que salga la pantalla de siguiente nivel y eso
        }
    }
}
