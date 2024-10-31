package Visitors;

import Enemigos.BuzzyBeetle;
import Enemigos.Goomba;
import Enemigos.KoopaTroopa;
import Enemigos.Lakitu;
import Enemigos.PiranhaPlant;
import Enemigos.Spiny;
import Entidades.Mario;
import PowerUps.ChampinionVerde;
import PowerUps.Estrella;
import PowerUps.Moneda;
import PowerUps.SuperChampinion;

public class VisitorVacio extends VisitorPlataforma{
    public VisitorVacio(){
    }
    
    public void visit(KoopaTroopa k, int direccion){
        k.morir();
    }
    
    public void visit(Goomba g, int direccion){
        g.morir();
    }
    
    public void visit(Lakitu l, int direccion){
        l.morir();
    }
    
    public void visit(BuzzyBeetle b, int direccion){
        b.morir();
    }
    
    public void visit(PiranhaPlant p, int direccion){
        p.morir();
    }
    
    public void visit(Spiny s, int direccion){
        s.morir();
    }
    
    public void visit(Mario m, int direccion){
        if(m.getPosicionY() == 0){
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
