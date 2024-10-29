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
    @Override
    public void visit(KoopaTroopa k, int direccion){
        k.morir();
    }
    @Override
    public void visit(Goomba g, int direccion){
        g.morir();
    }
    @Override
    public void visit(Lakitu l, int direccion){
        l.morir();
    }
    @Override
    public void visit(BuzzyBeetle b, int direccion){
        b.morir();
    }
    @Override
    public void visit(PiranhaPlant p, int direccion){
        p.morir();
    }
    @Override
    public void visit(Spiny s, int direccion){
        s.morir();
    }
    @Override
    public void visit(Mario m, int direccion){
        m.aplicarGravedad();
    }
    @Override
    public void visit(ChampinionVerde cv, int direccion){
        cv.aplicarGravedad();
    }
    @Override
    public void visit(SuperChampinion sc, int direccion){
        sc.aplicarGravedad();
    }
    @Override
    public void visit(FlorDeFuego f, int direccion){
        f.morir();
    }
    @Override
    public void visit(Moneda m, int direccion){
        m.morir();
    }
    @Override
    public void visit(Plataforma p, int direccion){}
    @Override
    public void visit(Estrella e, int direccion){
        e.aplicarGravedad();
    }
    @Override
    public void visit(BolaDeFuego bf, int direccion){
        bf.morir();
    }
}
