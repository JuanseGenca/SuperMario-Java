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

    public void visit(KoopaTroopa koopaTroopa, int direccion) {}
    
    public void visit(Goomba goomba, int direccion) {}
    
    public void visit(Lakitu lakitu, int direccion) {}
    
    public void visit(BuzzyBeetle buzzyBeetle, int direccion) {}
    
    public void visit(PiranhaPlant piranhaPlant, int direccion) {}
    
    public void visit(Spiny spiny, int direccion) {}
    
    public void visit(Mario mario, int direccion) { 
        if(direccion == ConstantesColisiones.ARRIBA) {
            mario.setPosicionY(mario.getPosicionY() + 8);
            double nuevaVel = 3;
            mario.setVelocidadY(nuevaVel);
        }

        if(direccion == ConstantesColisiones.IZQUIERDA || direccion == ConstantesColisiones.DERECHA) {
            mario.recibirDanio(enemigo.getPuntaje());
        }
    }
    
    public void visit(ChampinionVerde champinionVerde, int direccion) {}
    
    public void visit(SuperChampinion superChampinion, int direccion) {}
    
    public void visit(FlorDeFuego florDeFuego, int direccion) {}
    
    public void visit(Moneda moneda, int direccion) {}
    
    public void visit(Plataforma plataforma, int direccion) {}
    
    public void visit(Estrella estrella, int direccion) {}
    
    public void visit(LadrilloRompible ladrilloRompible, int direccion) {}
    
    public void visit(BloqueIrrompible bloqueIrrompible, int direccion) {}
    
    public void visit(Meta meta, int direccion) {}
    
    public void visit(Vacio vacio, int direccion) {}
    
    public void visit(PowerUp powerUp, int direccion) {}
    
    public void visit(BolaDeFuego bolaDeFuego, int direccion) {
        bolaDeFuego.eliminar();
        bolaDeFuego.recibirDanio(0);
    }

    public void visit(BloquePregunta bloquePregunta,int direccion){}
    
}
