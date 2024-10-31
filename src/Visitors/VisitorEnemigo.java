package Visitors;

import Enemigos.*;
import Entidades.*;
import Logica.ConstantesColisiones;
import Logica.Visitor;
import Plataformas.BloqueIrrompible;
import Plataformas.BloquePregunta;
import Plataformas.LadrilloRompible;
import Plataformas.Meta;
import Plataformas.Plataforma;
import Plataformas.Vacio;
import PowerUps.*;


public class VisitorEnemigo implements Visitor {

    protected Enemigo enemigo;

    public VisitorEnemigo(Enemigo enemigo) {
        this.enemigo = enemigo;
    }

    public void visit(KoopaTroopa k, int direccion) {}
    
    public void visit(Goomba g, int direccion) {}
    
    public void visit(Lakitu l, int direccion) {}
    
    public void visit(BuzzyBeetle b, int direccion) {}
    
    public void visit(PiranhaPlant p, int direccion) {}
    
    public void visit(Spiny s, int direccion) {}
    
    public void visit(Mario m, int direccion) { 
        if(direccion == ConstantesColisiones.ARRIBA) {
            m.setPosicionY(m.getPosicionY() + 8);
            double nuevaVel = 3;
            m.setVelocidadY(nuevaVel);
        }

        if(direccion == ConstantesColisiones.IZQUIERDA || direccion == ConstantesColisiones.DERECHA) {
            m.recibirDanio(enemigo.getPuntaje());
        }
    }
    
    public void visit(ChampinionVerde cv, int direccion) {}
    
    public void visit(SuperChampinion sc, int direccion) {}
    
    public void visit(FlorDeFuego f, int direccion) {}
    
    public void visit(Moneda m, int direccion) {}
    
    public void visit(Plataforma p, int direccion) {}
    
    public void visit(Estrella e, int direccion) {}
    
    public void visit(LadrilloRompible lr, int direccion) {}
    
    public void visit(BloqueIrrompible bi, int direccion) {}
    
    public void visit(Meta m, int direccion) {}
    
    public void visit(Vacio v, int direccion) {}
    
    public void visit(PowerUp pu, int direccion) {}
    
    public void visit(BolaDeFuego bf, int direccion) {
        bf.eliminar();
        bf.recibirDanio(0);
    }

    public void visit(BloquePregunta bp,int direccion){}
    
}
