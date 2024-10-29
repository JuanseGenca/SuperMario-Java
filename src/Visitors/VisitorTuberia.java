package Visitors;

import Enemigos.BuzzyBeetle;
import Enemigos.Goomba;
import Enemigos.KoopaTroopa;
import Enemigos.Lakitu;
import Enemigos.PiranhaPlant;
import Enemigos.Spiny;
import Entidades.Mario;
import Logica.ConstantesColisiones;
import Logica.ConstantesEntidades;
import PowerUps.ChampinionVerde;
import PowerUps.Estrella;
import PowerUps.SuperChampinion;

public class VisitorTuberia extends VisitorPlataforma{
    
    public VisitorTuberia(){
        
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
    @Override
    public void visit(KoopaTroopa k, int direccion){
        if(k.getDireccion()==ConstantesEntidades.DERECHA){
            k.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }else if(k.getDireccion()==ConstantesEntidades.IZQUIERDA){
                k.establecerDireccion(ConstantesEntidades.DERECHA);
            }
    }
    @Override
    public void visit(Goomba g, int direccion){
        if(g.getDireccion()==ConstantesEntidades.DERECHA){
            g.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }else if(g.getDireccion()==ConstantesEntidades.IZQUIERDA){
                g.establecerDireccion(ConstantesEntidades.DERECHA);
            }
    }
    @Override
    public void visit(Lakitu l, int direccion){
        if(l.getDireccion()==ConstantesEntidades.DERECHA){
            l.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }else if(l.getDireccion()==ConstantesEntidades.IZQUIERDA){
                l.establecerDireccion(ConstantesEntidades.DERECHA);
            }
    }
    @Override
    public void visit(BuzzyBeetle b, int direccion){
        if(b.getDireccion()==ConstantesEntidades.DERECHA){
            b.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }else if(b.getDireccion()==ConstantesEntidades.IZQUIERDA){
                b.establecerDireccion(ConstantesEntidades.DERECHA);
            }
    }
    @Override
    public void visit(PiranhaPlant p, int direccion){}
    @Override
    public void visit(Spiny s, int direccion){
        if(s.getDireccion()==ConstantesEntidades.DERECHA){
            s.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }else if(s.getDireccion()==ConstantesEntidades.IZQUIERDA){
                s.establecerDireccion(ConstantesEntidades.DERECHA);
            }
    }

    public void visit(Estrella e,int direccion){
        if(e.getDireccion()==ConstantesEntidades.DERECHA){
            e.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }else if(e.getDireccion()==ConstantesEntidades.IZQUIERDA){
                e.establecerDireccion(ConstantesEntidades.DERECHA);
            }
    }

    public void visit(ChampinionVerde cv,int direccion){
        if(cv.getDireccion()==ConstantesEntidades.DERECHA){
            cv.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }else if(cv.getDireccion()==ConstantesEntidades.IZQUIERDA){
                cv.establecerDireccion(ConstantesEntidades.DERECHA);
            }
    }

    public void visit(SuperChampinion sc,int direccion){
        if(sc.getDireccion()==ConstantesEntidades.DERECHA){
            sc.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }else if(sc.getDireccion()==ConstantesEntidades.IZQUIERDA){
                sc.establecerDireccion(ConstantesEntidades.DERECHA);
            }
    }
}
