package Visitors;

import Entidades.BolaDeFuego;
import Entidades.Mario;
import Logica.ConstantesColisiones;
import Logica.ConstantesEntidades;
import PowerUps.ChampinionVerde;
import PowerUps.Estrella;
import PowerUps.SuperChampinion;

public class VisitorBloquePregunta extends VisitorPlataforma{
    public VisitorBloquePregunta(){
    }
    @Override
    public void visit(Mario m, int direccion){
        if(direccion == ConstantesColisiones.DERECHA){
            m.setVelocidadX(0);
            m.setPosicionx(m.getPosicionX() - 2);
        }
        if(direccion == ConstantesColisiones.IZQUIERDA){
            m.setVelocidadX(0);
            m.setPosicionx(m.getPosicionX() + 2);
        }
        if(direccion == ConstantesColisiones.ABAJO){
            if(m.getVelocidadY() >= 0) 
                m.setVelocidadY(0);
        }
        if(direccion == ConstantesColisiones.ARRIBA){
            m.tocoSuelo();
        }
    }

    @SuppressWarnings("override")
    public void visit(Estrella e,int direccion){
        if(direccion == ConstantesColisiones.DERECHA){
            e.setPosicionx(e.getPosicionX() - 4);
            e.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }
        if(direccion == ConstantesColisiones.IZQUIERDA){
            e.setPosicionx(e.getPosicionX() + 4);
            e.establecerDireccion(ConstantesEntidades.DERECHA);
        }
        if(direccion == ConstantesColisiones.ARRIBA){
            e.tocoSuelo();
        } 
    }

    @SuppressWarnings("override")
    public void visit(ChampinionVerde cv,int direccion){
        if(direccion == ConstantesColisiones.DERECHA){
            cv.setPosicionx(cv.getPosicionX() - 4);
            cv.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }
        if(direccion == ConstantesColisiones.IZQUIERDA){
            cv.setPosicionx(cv.getPosicionX() + 4);
            cv.establecerDireccion(ConstantesEntidades.DERECHA);
        }
        if(direccion == ConstantesColisiones.ARRIBA){
            cv.tocoSuelo();
        }
    }

    @Override
    public void visit(SuperChampinion sc,int direccion){
        if(direccion == ConstantesColisiones.DERECHA){
            sc.setPosicionx(sc.getPosicionX() - 4);
            sc.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }
        if(direccion == ConstantesColisiones.IZQUIERDA){
            sc.setPosicionx(sc.getPosicionX() + 4);
            sc.establecerDireccion(ConstantesEntidades.DERECHA);
        }
        if(direccion == ConstantesColisiones.ARRIBA){
            sc.tocoSuelo();
        }
    }

    @SuppressWarnings("override")
    public void visit(BolaDeFuego bf, int direccion) {
        bf.eliminar();
        bf.recibirDanio(0);
    }
}
