package Visitors;

import Enemigos.BuzzyBeetle;
import Enemigos.Goomba;
import Enemigos.KoopaTroopa;
import Enemigos.Lakitu;
import Enemigos.PiranhaPlant;
import Enemigos.Spiny;
import Entidades.BolaDeFuego;
import Entidades.Mario;
import Plataformas.Plataforma;
import PowerUps.ChampinionVerde;
import PowerUps.Estrella;
import PowerUps.FlorDeFuego;
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
        m.aplicarGravedad();
    }
    
    public void visit(ChampinionVerde cv, int direccion){
        cv.aplicarGravedad();
    }
    
    public void visit(SuperChampinion sc, int direccion){
        sc.aplicarGravedad();
    }
    
    public void visit(FlorDeFuego f, int direccion){
        f.morir();
    }
    
    public void visit(Moneda m, int direccion){
        m.morir();
    }

    public void visit(Plataforma p, int direccion){}
    
    public void visit(Estrella e, int direccion){
        e.aplicarGravedad();
    }
    
    public void visit(BolaDeFuego bf, int direccion){
        bf.morir();
    }
}
