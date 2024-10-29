package Visitors;

import Enemigos.BuzzyBeetle;
import Enemigos.Goomba;
import Enemigos.KoopaTroopa;
import Enemigos.Lakitu;
import Enemigos.PiranhaPlant;
import Enemigos.Spiny;
import Entidades.BolaDeFuego;
import Entidades.Mario;
import Logica.Visitor;
import Plataformas.BloqueIrrompible;
import Plataformas.BloquePregunta;
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

public class VisitorBolaDeFuego implements Visitor{
    Mario mario;
    public VisitorBolaDeFuego(Mario mario){
        this.mario = mario;
    }
    @Override
    public void visit(KoopaTroopa k, int direccion) {
        k.recibirDanio();
        //k.eliminar();
    }

    @Override
    public void visit(Goomba g, int direccion) {
        g.recibirDanio(0);
        mario.actualizarPuntaje(90);
        g.eliminar();
    }

    @Override
    public void visit(Lakitu l, int direccion) {
        l.recibirDanio(0);
        mario.actualizarPuntaje(60);
        l.eliminar();
    }

    @Override
    public void visit(BuzzyBeetle b, int direccion){
        b.recibirDanio(0);
        mario.actualizarPuntaje(30);
        b.eliminar();
    }

    @Override
    public void visit(PiranhaPlant p, int direccion){
        p.recibirDanio(0);
        mario.actualizarPuntaje(30);
        p.eliminar();
    }

    @Override
    public void visit(Spiny s, int direccion){
        s.recibirDanio(0);
        mario.actualizarPuntaje(60);
        s.eliminar();
    } 

    @Override
    public void visit(Mario m, int direccion){}
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

    @SuppressWarnings("override")
    public void visit(BloquePregunta bp,int direccion){
    }
} 

