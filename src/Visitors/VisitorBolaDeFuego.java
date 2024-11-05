package Visitors;

import Enemigos.*;
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
    
    public void visit(KoopaTroopa koopaTroopa, int direccion) {
        koopaTroopa.recibirDanio();
        mario.actualizarPuntaje(90);
    }

    public void visit(Goomba goomba, int direccion) {
        goomba.recibirDanio(0);
        mario.actualizarPuntaje(90);
        goomba.eliminar();
    }

    public void visit(Lakitu lakitu, int direccion) {
        lakitu.recibirDanio(0);
        mario.actualizarPuntaje(60);
        lakitu.eliminar();
    }

    public void visit(BuzzyBeetle buzzyBeetle, int direccion){
        buzzyBeetle.recibirDanio(0);
        mario.actualizarPuntaje(30);
        buzzyBeetle.eliminar();
    }

    public void visit(PiranhaPlant piranhaPlant, int direccion){
        piranhaPlant.recibirDanio(0);
        mario.actualizarPuntaje(30);
        piranhaPlant.eliminar();
    }

    public void visit(Spiny spiny, int direccion){
        spiny.recibirDanio(0);
        mario.actualizarPuntaje(60);
        spiny.eliminar();
    } 

    
    public void visit(ChampinionVerde champinionVerde, int direccion){}
    
    public void visit(SuperChampinion superChampinion, int direccion){}
    
    public void visit(FlorDeFuego florDeFuego, int direccion){}
    
    public void visit(Moneda moneda, int direccion){}
    
    public void visit(Plataforma plataforma, int direccion){}
    
    public void visit(Estrella estrella, int direccion){}
    
    public void visit(LadrilloRompible ladrilloRompible, int direccion){}
    
    public void visit(BloqueIrrompible bloqueIrrompible, int direccion){}
    
    public void visit(Meta meta, int direccion){}
    
    public void visit(Vacio vacio, int direccion){}
    
    public void visit(PowerUp powerUp, int direccion){}
    
    public void visit(BolaDeFuego bolaDeFuego, int direccion){}

    public void visit(BloquePregunta bloquePregunta, int direccion){}

    public void visit(Mario mario, int direccion) {}
} 

