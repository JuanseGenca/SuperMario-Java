package Visitors;

import Enemigos.BuzzyBeetle;
import Enemigos.Goomba;
import Enemigos.KoopaTroopa;
import Enemigos.Lakitu;
import Enemigos.Spiny;
import Entidades.Mario;
import Logica.ConstantesColisiones;

public class VisitorKoopaTroopa extends VisitorEnemigo {

    KoopaTroopa kt;

    public VisitorKoopaTroopa(KoopaTroopa enemigo){
        super(enemigo);
        kt = enemigo;
    }

    public void visit(KoopaTroopa k, int direccion) {
        if(direccion == ConstantesColisiones.IZQUIERDA || direccion == ConstantesColisiones.DERECHA){
            k.recibirDanio();
            k.eliminar();
        }
    }

    public void visit(Goomba g, int direccion) {
        if(direccion == ConstantesColisiones.IZQUIERDA || direccion == ConstantesColisiones.DERECHA){
            g.recibirDanio(0);
            g.eliminar();
        }
    }

    public void visit(Lakitu l, int direccion) {
        if(direccion == ConstantesColisiones.IZQUIERDA || direccion == ConstantesColisiones.DERECHA){
            l.recibirDanio(0);
            l.eliminar();
        }
    }

    public void visit(BuzzyBeetle b, int direccion) {
        if(direccion == ConstantesColisiones.IZQUIERDA || direccion == ConstantesColisiones.DERECHA){
            b.recibirDanio(0);
            b.eliminar();
        }
    }

    public void visit(Spiny s, int direccion) {
        if(direccion == ConstantesColisiones.IZQUIERDA || direccion == ConstantesColisiones.DERECHA){
            s.recibirDanio(0);
            s.eliminar();
        }
    }

    public void visit(Mario m, int direccion) {
        if(direccion == ConstantesColisiones.ARRIBA) {
            m.setPosicionY(m.getPosicionY() + 16);
            double nuevaVel = 3;
            m.setVelocidadY(nuevaVel);
        }

        if(!kt.getEstado().esVulnerable()) {
            if(direccion == ConstantesColisiones.IZQUIERDA || direccion == ConstantesColisiones.DERECHA) {
                m.recibirDanio(0);
            }
        }
    }
}
