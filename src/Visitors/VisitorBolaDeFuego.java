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
    
    public void visit(KoopaTroopa k, int direccion) {
        k.recibirDanio();
        mario.actualizarPuntaje(90);
    }

    public void visit(Goomba g, int direccion) {
        g.recibirDanio(0);
        mario.actualizarPuntaje(90);
        g.eliminar();
    }

    public void visit(Lakitu l, int direccion) {
        l.recibirDanio(0);
        mario.actualizarPuntaje(60);
        l.eliminar();
    }

    public void visit(BuzzyBeetle b, int direccion){
        b.recibirDanio(0);
        mario.actualizarPuntaje(30);
        b.eliminar();
    }

    public void visit(PiranhaPlant p, int direccion){
        p.recibirDanio(0);
        mario.actualizarPuntaje(30);
        p.eliminar();
    }

    public void visit(Spiny s, int direccion){
        s.recibirDanio(0);
        mario.actualizarPuntaje(60);
        s.eliminar();
    } 

    
    public void visit(ChampinionVerde cv, int direccion){}
    
    public void visit(SuperChampinion sc, int direccion){}
    
    public void visit(FlorDeFuego f, int direccion){}
    
    public void visit(Moneda m, int direccion){}
    
    public void visit(Plataforma p, int direccion){}
    
    public void visit(Estrella e, int direccion){}
    
    public void visit(LadrilloRompible lr, int direccion){}
    
    public void visit(BloqueIrrompible bi, int direccion){}
    
    public void visit(Meta m, int direccion){}
    
    public void visit(Vacio v, int direccion){}
    
    public void visit(PowerUp pu, int direccion){}
    
    public void visit(BolaDeFuego bf, int direccion){}

    public void visit(BloquePregunta bp,int direccion){}

    public void visit(Mario m, int direccion) {}
} 

