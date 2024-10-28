package Visitors;

import Enemigos.BuzzyBeetle;
import Enemigos.Enemigo;
import Enemigos.Goomba;
import Enemigos.KoopaTroopa;
import Enemigos.Lakitu;
import Entidades.Mario;
import Logica.ConstantesColisiones;

public class VisitorKoopaTroopa extends VisitorEnemigo {
    public VisitorKoopaTroopa(Enemigo enemigo){
        super(enemigo);
    }

    @Override
    public void visit(KoopaTroopa k, int direccion) {
        if(direccion == ConstantesColisiones.IZQUIERDA || direccion == ConstantesColisiones.DERECHA){
            k.recibirDanio();
            k.eliminar();
        }
    }

    @Override
    public void visit(Goomba g, int direccion) {
        if(direccion == ConstantesColisiones.IZQUIERDA || direccion == ConstantesColisiones.DERECHA){
            g.recibirDanio(0);
            g.eliminar();
        }
    }

    @Override
    public void visit(Lakitu l, int direccion) {
        if(direccion == ConstantesColisiones.IZQUIERDA || direccion == ConstantesColisiones.DERECHA){
            l.recibirDanio(0);
            l.eliminar();
        }
    }

    @Override
    public void visit(BuzzyBeetle b, int direccion) {
        if(direccion == ConstantesColisiones.IZQUIERDA || direccion == ConstantesColisiones.DERECHA){
            b.recibirDanio(0);
            b.eliminar();
        }
    }

    @Override
    public void visit(Mario m, int direccion) { 
        if(direccion == ConstantesColisiones.ARRIBA) {
            double nuevaVel = 3;
            m.setVelocidadY(nuevaVel);
        }

        if(direccion == ConstantesColisiones.IZQUIERDA || direccion == ConstantesColisiones.DERECHA) {
            m.recibirDanio(0);
        }
    }
}
