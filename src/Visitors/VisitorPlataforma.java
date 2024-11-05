package Visitors;

import Enemigos.*;
import Entidades.Mario;
import Logica.ConstantesColisiones;
import Logica.ConstantesEntidades;
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

    public class VisitorPlataforma implements Visitor{
    public VisitorPlataforma() {
    }

    @Override
    public void visit(KoopaTroopa koopaTroopa, int direccion) {
        if(direccion == ConstantesColisiones.DERECHA){
            koopaTroopa.setPosicionx(koopaTroopa.getPosicionX() - 4);
            koopaTroopa.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }
        if(direccion == ConstantesColisiones.IZQUIERDA){
            koopaTroopa.setPosicionx(koopaTroopa.getPosicionX() + 4);
            koopaTroopa.establecerDireccion(ConstantesEntidades.DERECHA);
        }
        if(direccion == ConstantesColisiones.ARRIBA){
            koopaTroopa.tocoSuelo();
        }
    }

    @Override
    public void visit(Goomba goomba, int direccion) {
        if(direccion == ConstantesColisiones.DERECHA){
            goomba.setPosicionx(goomba.getPosicionX() - 4);
            goomba.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }
        if(direccion == ConstantesColisiones.IZQUIERDA){
            goomba.setPosicionx(goomba.getPosicionX() + 4);
            goomba.establecerDireccion(ConstantesEntidades.DERECHA);
        }
        if(direccion == ConstantesColisiones.ARRIBA){
            goomba.tocoSuelo();
        }
    }

    @Override
    public void visit(Lakitu lakitu, int direccion) {
        if(direccion == ConstantesColisiones.DERECHA){
            lakitu.setPosicionx(lakitu.getPosicionX() - 4);
            lakitu.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }
        if(direccion == ConstantesColisiones.IZQUIERDA){
            lakitu.setPosicionx(lakitu.getPosicionX() + 4);
            lakitu.establecerDireccion(ConstantesEntidades.DERECHA);
        }
        if(direccion == ConstantesColisiones.ARRIBA){
            lakitu.tocoSuelo();
        }
    }

    @Override
    public void visit(BuzzyBeetle buzzyBeetle, int direccion) {
        if(direccion == ConstantesColisiones.DERECHA){
            buzzyBeetle.setPosicionx(buzzyBeetle.getPosicionX() - 4);
            buzzyBeetle.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }
        if(direccion == ConstantesColisiones.IZQUIERDA){
            buzzyBeetle.setPosicionx(buzzyBeetle.getPosicionX() + 4);
            buzzyBeetle.establecerDireccion(ConstantesEntidades.DERECHA);
        }
        if(direccion == ConstantesColisiones.ARRIBA){
            buzzyBeetle.tocoSuelo();
        }
    }

    @Override
    public void visit(PiranhaPlant piranhaPlant, int direccion) {
        
    }

    @Override
    public void visit(Spiny spiny, int direccion) {
        if(direccion == ConstantesColisiones.DERECHA){
            spiny.setPosicionx(spiny.getPosicionX() - 4);
            spiny.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }
        if(direccion == ConstantesColisiones.IZQUIERDA){
            spiny.setPosicionx(spiny.getPosicionX() + 4);
            spiny.establecerDireccion(ConstantesEntidades.DERECHA);
        }
        if(direccion == ConstantesColisiones.ARRIBA){
            spiny.tocoSuelo();
        }
    }

    @Override
    public void visit(Mario mario, int direccion) {
        if(direccion == ConstantesColisiones.DERECHA){
            mario.setVelocidadX(0);
            mario.setPosicionx(mario.getPosicionX() - 2);
        }
        if(direccion == ConstantesColisiones.IZQUIERDA){
            mario.setVelocidadX(0);
            mario.setPosicionx(mario.getPosicionX() + 2);
        }
        if(direccion == ConstantesColisiones.ABAJO){
            if(mario.getVelocidadY() >= 0) 
                mario.setVelocidadY(0);
        }
        if(direccion == ConstantesColisiones.ARRIBA){
            mario.tocoSuelo();
        }
    }

    @Override
    public void visit(ChampinionVerde champinionVerde, int direccion) {
        if(direccion == ConstantesColisiones.DERECHA){
            champinionVerde.setPosicionx(champinionVerde.getPosicionX() - 4);
            champinionVerde.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }
        if(direccion == ConstantesColisiones.IZQUIERDA){
            champinionVerde.setPosicionx(champinionVerde.getPosicionX() + 4);
            champinionVerde.establecerDireccion(ConstantesEntidades.DERECHA);
        }
        if(direccion == ConstantesColisiones.ARRIBA){
            champinionVerde.tocoSuelo();
        }
    }

    @Override
    public void visit(SuperChampinion superChampinion, int direccion) {
        if(direccion == ConstantesColisiones.DERECHA){
            superChampinion.setPosicionx(superChampinion.getPosicionX() - 4);
            superChampinion.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }
        if(direccion == ConstantesColisiones.IZQUIERDA){
            superChampinion.setPosicionx(superChampinion.getPosicionX() + 4);
            superChampinion.establecerDireccion(ConstantesEntidades.DERECHA);
        }
        if(direccion == ConstantesColisiones.ARRIBA){
            superChampinion.tocoSuelo();
        }
    }

    @Override
    public void visit(FlorDeFuego florDeFuego, int direccion) {
    }

    @Override
    public void visit(Moneda moneda, int direccion) {
    }

    @Override
    public void visit(Plataforma plataforma, int direccion) {
    }

    @Override
    public void visit(Estrella estrella, int direccion) {
        if(direccion == ConstantesColisiones.DERECHA){
            estrella.setPosicionx(estrella.getPosicionX() - 4);
            estrella.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }
        if(direccion == ConstantesColisiones.IZQUIERDA){
            estrella.setPosicionx(estrella.getPosicionX() + 4);
            estrella.establecerDireccion(ConstantesEntidades.DERECHA);
        }
        if(direccion == ConstantesColisiones.ARRIBA){
            estrella.tocoSuelo();
        }
    }

    @Override
    public void visit(LadrilloRompible ladrilloRompible, int direccion) {
    }

    @Override
    public void visit(BloqueIrrompible bloqueIrrompible, int direccion) {
    }

    @Override
    public void visit(Meta meta, int direccion) {
    }

    @Override
    public void visit(Vacio vacio, int direccion) {
    }

    @Override
    public void visit(PowerUp powerUp, int direccion) {
    }

    @Override
    public void visit(BolaDeFuego bolaDeFuego, int direccion) {
        bolaDeFuego.eliminar();
        bolaDeFuego.recibirDanio(0);
    }

    @Override
    public void visit(BloquePregunta bloquePregunta, int direccion) {
    }
    
}
