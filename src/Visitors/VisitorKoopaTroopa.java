package Visitors;

import Enemigos.BuzzyBeetle;
import Enemigos.Goomba;
import Enemigos.KoopaTroopa;
import Enemigos.Lakitu;
import Enemigos.Spiny;
import Entidades.Mario;
import Logica.ConstantesColisiones;

public class VisitorKoopaTroopa extends VisitorEnemigo {

    KoopaTroopa koopaTroopa;

    public VisitorKoopaTroopa(KoopaTroopa enemigo){
        super(enemigo);
        koopaTroopa = enemigo;
    }

    public void visit(KoopaTroopa koopa, int direccion) {
        if(direccion == ConstantesColisiones.IZQUIERDA || direccion == ConstantesColisiones.DERECHA){
            koopa.recibirDanio();
            koopa.eliminar();
        }
    }

    public void visit(Goomba goomba, int direccion) {
        if(direccion == ConstantesColisiones.IZQUIERDA || direccion == ConstantesColisiones.DERECHA){
            goomba.recibirDanio(0);
            goomba.eliminar();
        }
    }

    public void visit(Lakitu lakitu, int direccion) {
        if(direccion == ConstantesColisiones.IZQUIERDA || direccion == ConstantesColisiones.DERECHA){
            lakitu.recibirDanio(0);
            lakitu.eliminar();
        }
    }

    public void visit(BuzzyBeetle buzzyBeetle, int direccion) {
        if(direccion == ConstantesColisiones.IZQUIERDA || direccion == ConstantesColisiones.DERECHA){
            buzzyBeetle.recibirDanio(0);
            buzzyBeetle.eliminar();
        }
    }

    public void visit(Spiny spiny, int direccion) {
        if(direccion == ConstantesColisiones.IZQUIERDA || direccion == ConstantesColisiones.DERECHA){
            spiny.recibirDanio(0);
            spiny.eliminar();
        }
    }

    public void visit(Mario mario, int direccion) {
        if(direccion == ConstantesColisiones.ARRIBA) {
            mario.setPosicionY(mario.getPosicionY() + 16);
            double nuevaVel = 3;
            mario.setVelocidadY(nuevaVel);
        }

        if(!koopaTroopa.getEstado().esVulnerable()) {
            if(direccion == ConstantesColisiones.IZQUIERDA || direccion == ConstantesColisiones.DERECHA) {
                mario.recibirDanio(0);
            }
        }
    }
}
