package Visitors;

import Enemigos.BuzzyBeetle;
import Enemigos.Goomba;
import Enemigos.KoopaTroopa;
import Enemigos.Lakitu;
import Enemigos.PiranhaPlant;
import Enemigos.Spiny;
import Entidades.BolaDeFuego;
import Entidades.Mario;
import Logica.ConstantesColisiones;
import Logica.ConstantesEntidades;
import PowerUps.ChampinionVerde;
import PowerUps.Estrella;
import PowerUps.SuperChampinion;

public class VisitorTuberia extends VisitorPlataforma{
    
    public VisitorTuberia(){
    }
    
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
    
    public void visit(KoopaTroopa k, int direccion){
        if(k.getDireccion()==ConstantesEntidades.DERECHA){
            k.setPosicionx(k.getPosicionX() - 4);
            k.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }else if(k.getDireccion()==ConstantesEntidades.IZQUIERDA){
                k.setPosicionx(k.getPosicionX() + 4);
                k.establecerDireccion(ConstantesEntidades.DERECHA);
         }
    }

    public void visit(Goomba g, int direccion){
        if(g.getDireccion()==ConstantesEntidades.DERECHA){
            g.setPosicionx(g.getPosicionX() - 4);
            g.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }else if(g.getDireccion()==ConstantesEntidades.IZQUIERDA){
                g.setPosicionx(g.getPosicionX() + 4);
                g.establecerDireccion(ConstantesEntidades.DERECHA);
         }
    }
    
    public void visit(Lakitu l, int direccion){
        if(l.getDireccion()==ConstantesEntidades.DERECHA){
            l.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }else if(l.getDireccion()==ConstantesEntidades.IZQUIERDA){
                l.establecerDireccion(ConstantesEntidades.DERECHA);
            }
    }
    
    public void visit(BuzzyBeetle b, int direccion){
        if(b.getDireccion()==ConstantesEntidades.DERECHA){
            b.setPosicionx(b.getPosicionX() - 4);
            b.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }else if(b.getDireccion()==ConstantesEntidades.IZQUIERDA){
                b.setPosicionx(b.getPosicionX() + 4);
                b.establecerDireccion(ConstantesEntidades.DERECHA);
         }
    }
    
    public void visit(PiranhaPlant p, int direccion){}
    
    public void visit(Spiny s, int direccion){
        if(s.getDireccion()==ConstantesEntidades.DERECHA){
            s.setVelocidadX(0);
            s.setPosicionx(s.getPosicionX() - 4);
            s.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }else if(s.getDireccion()==ConstantesEntidades.IZQUIERDA){
                s.setPosicionx(s.getPosicionX() + 4);
                s.establecerDireccion(ConstantesEntidades.DERECHA);
         }
    }

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

    public void visit(BolaDeFuego bf, int direccion) {
        bf.eliminar();
        bf.recibirDanio(0);
    }
}
