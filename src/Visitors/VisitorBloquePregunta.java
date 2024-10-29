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
        if(direccion == ConstantesColisiones.ARRIBA){
            m.tocoSuelo();
        }
    }

    @SuppressWarnings("override")
    public void visit(Estrella e,int direccion){
        if(direccion == ConstantesColisiones.DERECHA){
            e.establecerDireccion(ConstantesEntidades.DERECHA);
        } else {
            if(direccion == ConstantesColisiones.IZQUIERDA){
                e.establecerDireccion(ConstantesEntidades.IZQUIERDA);
                } else {
                    if (direccion == ConstantesColisiones.ARRIBA){
                        e.tocoSuelo();
                        }   
                }
            } 
    }

    @SuppressWarnings("override")
    public void visit(ChampinionVerde cv,int direccion){
        if(direccion == ConstantesColisiones.DERECHA){
            cv.establecerDireccion(ConstantesEntidades.DERECHA);
        } else {
            if(direccion == ConstantesColisiones.IZQUIERDA){
                cv.establecerDireccion(ConstantesEntidades.IZQUIERDA);
                } else {
                    if (direccion == ConstantesColisiones.ARRIBA){
                        cv.tocoSuelo();
                        }   
                }
            } 
    }

    @Override
    public void visit(SuperChampinion sc,int direccion){
        if(direccion == ConstantesColisiones.DERECHA){
            sc.establecerDireccion(ConstantesEntidades.DERECHA);
        } else {
            if(direccion == ConstantesColisiones.IZQUIERDA){
                sc.establecerDireccion(ConstantesEntidades.IZQUIERDA);
                } else {
                    if (direccion == ConstantesColisiones.ARRIBA){
                        sc.tocoSuelo();
                        }   
                }
            }    
    }

    @Override
    public void visit(BolaDeFuego bf, int direccion) {
        bf.eliminar();
        bf.recibirDanio(0);
    }
}
