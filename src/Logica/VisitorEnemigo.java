package Logica;

import Enemigos.*;
import Entidades.*;
import PowerUps.*;

public class VisitorEnemigo implements Visitor{

    @Override
    public void visit(KoopaTroopa k) {

    }

    @Override
    public void visit(Goomba g) {
    }

    @Override
    public void visit(Lakitu l) {
    }

    @Override
    public void visit(BuzzyBeetle b) {
    }

    @Override
    public void visit(PiranhaPlant p) {
    }

    @Override
    public void visit(Spiny s) {
    }

    @Override
    public void visit(Mario m) {
        //DAÑO O MORIR
    }

    @Override
    public void visit(ChampinionVerde cv) {
    }

    @Override
    public void visit(SuperChampinion sc) {
    }

    @Override
    public void visit(FlorDeFuego f) {
    }

    @Override
    public void visit(Moneda m) {
    }

    @Override
    public void visit(Plataforma p) {
        //CAMBIAR LA DIRECCION DE MOVIMIENTO
    }

    @Override
    public void visit(Estrella e) {
    }

    @Override
    public void visit(LadrilloRompible lr) {
        //CAMBIAR LA DIRECCION DE MOVIMIENTO
    }

    @Override
    public void visit(BloqueIrrompible bi) {
       //CAMBIAR LA DIRECCION DE MOVIMIENTO
    }

    @Override
    public void visit(Meta m) {
        
    }

    @Override
    public void visit(Vacio v) {
       //MUERE
    }

    @Override
    public void visit(PowerUp pu) {
       
    }

}
