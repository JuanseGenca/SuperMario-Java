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
import PowerUps.Moneda;
import PowerUps.SuperChampinion;

public class VisitorVacio extends VisitorPlataforma{
    public VisitorVacio(){
    }
    
    public void visit(KoopaTroopa k, int direccion){
        if(k.getPosicionY() == 0){
            k.cayoAlVacio = true;
        }
        k.aplicarGravedad();
    }
    
    public void visit(Goomba g, int direccion){
        if(g.getPosicionY() == 0){
            g.cayoAlVacio = true;
        }
        g.aplicarGravedad();
    }
    
    public void visit(Lakitu l, int direccion){
        if(direccion == ConstantesColisiones.DERECHA){
            l.setPosicionx(l.getPosicionX() - 4);
            l.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }
        if(direccion == ConstantesColisiones.IZQUIERDA){
            l.setPosicionx(l.getPosicionX() + 4);
            l.establecerDireccion(ConstantesEntidades.DERECHA);
        }
    }
    
    public void visit(BuzzyBeetle b, int direccion){
        if(b.getPosicionY() == 0){
            b.cayoAlVacio = true;
        }
        b.aplicarGravedad();
    }
    
    public void visit(PiranhaPlant p, int direccion){
        if(p.getPosicionY() == 0){
            p.cayoAlVacio = true;
        }
        p.aplicarGravedad();
    }
    
    public void visit(Spiny s, int direccion){
        if(s.getPosicionY() == 0){
            s.cayoAlVacio = true;
        }
        s.aplicarGravedad();
    }
    
    public void visit(Mario m, int direccion){
        if(m.sobreY0()){
            m.cayoAlVacio = true;
        }
        m.aplicarGravedad();
    }
    
    public void visit(ChampinionVerde cv, int direccion){
        if(cv.getPosicionY() == 0){
            cv.cayoAlVacio = true;
        }
        cv.aplicarGravedad();
    }
    
    public void visit(SuperChampinion sc, int direccion){
        if(sc.getPosicionY() == 0){
            sc.cayoAlVacio = true;
        }
        sc.aplicarGravedad();
    }
    
    public void visit(Moneda m, int direccion){
        m.morir();
    }
    
    public void visit(Estrella e, int direccion){
        if(e.getPosicionY() == 0){
            e.cayoAlVacio = true;
        }
        e.aplicarGravedad();
    }
    
}
