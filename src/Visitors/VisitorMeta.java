package Visitors;

import Enemigos.BuzzyBeetle;
import Enemigos.Goomba;
import Enemigos.KoopaTroopa;
import Enemigos.Lakitu;
import Enemigos.Spiny;
import Entidades.BolaDeFuego;
import Entidades.Mario;
import Logica.ConstantesEntidades;
import PowerUps.ChampinionVerde;
import PowerUps.Estrella;
import PowerUps.SuperChampinion;

public class VisitorMeta extends VisitorPlataforma {
    
    public VisitorMeta() {
    }

    public void visit(Mario mario, int direccion) {
        mario.actualizar(ConstantesEntidades.QUIETO, mario.getEstadoAereo());
        mario.siguienteNivel();
    }

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
    public void visit(Spiny spiny, int direccion) {
    }

    @Override
    public void visit(ChampinionVerde champinionVerde, int direccion) {
    }

    @Override
    public void visit(SuperChampinion superChampinion, int direccion) {
    }

    @Override
    public void visit(Estrella estrella, int direccion) {
    }

    @Override
    public void visit(BolaDeFuego bolaDeFuego, int direccion) {
    }
    
}
