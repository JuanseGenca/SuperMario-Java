package Visitors;

import Enemigos.BuzzyBeetle;
import Enemigos.Goomba;
import Enemigos.KoopaTroopa;
import Enemigos.Lakitu;
import Enemigos.PiranhaPlant;
import Enemigos.Spiny;
import Entidades.BolaDeFuego;
import Entidades.ConstantesEntidades;
import Entidades.Mario;
import Logica.ConstantesColisiones;
import Plataformas.BloqueIrrompible;
import Plataformas.LadrilloRompible;
import Plataformas.Meta;
import Plataformas.Plataforma;
import Plataformas.Vacio;
import PowerUps.ChampinionVerde;
import PowerUps.Estrella;
import PowerUps.FlorDeFuego;
import PowerUps.Moneda;
import PowerUps.PowerUp;
import PowerUps.SuperChampinion;

public class VisitorLadrilloRompible extends VisitorPlataforma{
    public VisitorLadrilloRompible() {
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
    @Override
    public void visit(ChampinionVerde cv, int direccion){}
    @Override
    public void visit(SuperChampinion sc, int direccion){}
    @Override
    public void visit(FlorDeFuego f, int direccion){}
    @Override
    public void visit(Moneda m, int direccion){}
    @Override
    public void visit(Plataforma p, int direccion){}
    @Override
    public void visit(Estrella e, int direccion){}
    @Override
    public void visit(LadrilloRompible lr, int direccion){}
    @Override
    public void visit(BloqueIrrompible bi, int direccion){}
    @Override
    public void visit(Meta m, int direccion){}
    @Override
    public void visit(Vacio v, int direccion){}
    @Override
    public void visit(PowerUp pu, int direccion){}
    @Override
    public void visit(BolaDeFuego bf, int direccion){}
}
