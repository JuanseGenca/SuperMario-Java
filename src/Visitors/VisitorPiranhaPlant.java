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


public class VisitorPiranhaPlant extends VisitorEnemigo {
    public VisitorPiranhaPlant() {
    }

    @Override
    public void visit(KoopaTroopa k, int direccion) {}
    
    @Override
    public void visit(Goomba g, int direccion) {}
    
    @Override
    public void visit(Lakitu l, int direccion) {}
    
    @Override
    public void visit(BuzzyBeetle b, int direccion) {}
    
    @Override
    public void visit(PiranhaPlant p, int direccion) {}
    
    @Override
    public void visit(Spiny s, int direccion) {}
    
    @Override
    public void visit(Mario m, int direccion) { 
        if(direccion == ConstantesColisiones.ARRIBA) {
            m.recibirDanio();
        }

        if(direccion == ConstantesColisiones.LATERAL) {
            m.recibirDanio();
        }
    }
    
    @Override
    public void visit(ChampinionVerde cv, int direccion) {}
    
    @Override
    public void visit(SuperChampinion sc, int direccion) {}
    
    @Override
    public void visit(FlorDeFuego f, int direccion) {}
    
    @Override
    public void visit(Moneda m, int direccion) {}
    
    @Override
    public void visit(Plataforma p, int direccion) {}
    
    @Override
    public void visit(Estrella e, int direccion) {}
    
    @Override
    public void visit(LadrilloRompible lr, int direccion) {}
    
    @Override
    public void visit(BloqueIrrompible bi, int direccion) {}
    
    @Override
    public void visit(Meta m, int direccion) {}
    
    @Override
    public void visit(Vacio v, int direccion) {}
    
    @Override
    public void visit(PowerUp pu, int direccion) {}
    
    @Override
    public void visit(BolaDeFuego bf, int direccion) {
        bf.eliminar();
        bf.recibirDanio();
    }

    public void visit(BloquePregunta bp,int direccion){
    }
}
