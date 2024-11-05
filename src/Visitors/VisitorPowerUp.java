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

    public abstract class VisitorPowerUp implements Visitor {
    public VisitorPowerUp() {}

    @Override
    public void visit(KoopaTroopa koopaTroopa, int direccion) {
    }

    @Override
    public void visit(Goomba goomba, int direccion) {
    }

    @Override
    public void visit(Lakitu lakitu, int direccion) {
    }

    @Override
    public void visit(BuzzyBeetle buzzyBeetle, int direccion) {
    }

    @Override
    public void visit(PiranhaPlant piranhaPlant, int direccion) {
    }

    @Override
    public void visit(Spiny spiny, int direccion) {
    }

    @Override
    public void visit(Mario mario, int direccion) {
    }

    @Override
    public void visit(ChampinionVerde champinionVerde, int direccion) {
    }

    @Override
    public void visit(SuperChampinion superChampinion, int direccion) {
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
    }

    public void visit(BloquePregunta bloquePregunta, int direccion){
    }

}
