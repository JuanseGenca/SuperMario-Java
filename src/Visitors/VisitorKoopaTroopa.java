package Visitors;

import Enemigos.BuzzyBeetle;
import Enemigos.Goomba;
import Enemigos.KoopaTroopa;
import Enemigos.Lakitu;
import Enemigos.PiranhaPlant;
import Enemigos.Spiny;
import Entidades.BolaDeFuego;
import Entidades.Mario;
import Estados.EstadoKoopaTroopa;
import Estados.EstadoKoopaTroopaCaparazon;
import Logica.ConstantesColisiones;
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

public class VisitorKoopaTroopa implements Visitor {
    public VisitorKoopaTroopa(){

    }

    @Override
    public void visit(KoopaTroopa k, int direccion) {
        if(direccion == ConstantesColisiones.LATERAL){
            k.recibirDanio();
        }
    }

    @Override
    public void visit(Goomba g, int direccion) {
        if(direccion == ConstantesColisiones.LATERAL){
            g.recibirDanio();
        }
    }

    @Override
    public void visit(Lakitu l, int direccion) {
        if(direccion == ConstantesColisiones.LATERAL){
            l.recibirDanio();
        }
    }

    @Override
    public void visit(BuzzyBeetle b, int direccion) {
        if(direccion == ConstantesColisiones.LATERAL){
            b.recibirDanio();
        }
    }

    @Override
    public void visit(PiranhaPlant p, int direccion) {
        
    }

    @Override
    public void visit(Spiny s, int direccion) {
       
    }

    @Override
    public void visit(Mario m, int direccion) { 
        if(direccion == ConstantesColisiones.ARRIBA) {
            double nuevaVel = 3;
            m.setVelocidadY(nuevaVel);
        }

        if(direccion == ConstantesColisiones.LATERAL) {
            m.recibirDanio();
        }
    }

    @Override
    public void visit(ChampinionVerde cv, int direccion) {
        
    }

    @Override
    public void visit(SuperChampinion sc, int direccion) {
       
    }

    @Override
    public void visit(FlorDeFuego f, int direccion) {
       
    }

    @Override
    public void visit(Moneda m, int direccion) {
      

    }

    @Override
    public void visit(Plataforma p, int direccion) {
        
    
    }

    @Override
    public void visit(Estrella e, int direccion) {
       
    
    }

    @Override
    public void visit(LadrilloRompible lr, int direccion) {
       
    
    }

    @Override
    public void visit(BloqueIrrompible bi, int direccion) {
        
        
    }

    @Override
    public void visit(Meta m, int direccion) {
        
        
    }

    @Override
    public void visit(Vacio v, int direccion) {
       
        
    }

    @Override
    public void visit(PowerUp pu, int direccion) {
        
    
    }

    @Override
    public void visit(BolaDeFuego bf, int direccion) {
        
    }

    @Override
    public void visit(BloquePregunta bp, int direccion) {
       
    }
    
}
