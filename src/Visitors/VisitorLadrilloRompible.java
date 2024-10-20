package Visitors;

import Enemigos.BuzzyBeetle;
import Enemigos.Goomba;
import Enemigos.KoopaTroopa;
import Enemigos.Lakitu;
import Enemigos.PiranhaPlant;
import Enemigos.Spiny;
import Entidades.BolaDeFuego;
import Entidades.Mario;
import Plataformas.BloqueIrrompible;
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

public class VisitorLadrilloRompible extends VisitorPlataforma{
    public VisitorLadrilloRompible() {
    }
    @Override
    public void visit(KoopaTroopa k, int direccion){}
    @Override
    public void visit(Goomba g, int direccion){}
    @Override
    public void visit(Lakitu l, int direccion){}
    @Override
    public void visit(BuzzyBeetle b, int direccion){}
    @Override
    public void visit(PiranhaPlant p, int direccion){}
    @Override
    public void visit(Spiny s, int direccion){}
    @Override
    public void visit(Mario m, int direccion){}
    @Override
    public void visit(ChampinionVerde cv, int direccion){}
    @Override
    public void visit(SuperChampinion sc, int direccion){}
    @Override
    public void visit(FlorDeFuego f, int direccion){}
    @Override
    public void visit(Moneda m, int direccion){}
    @Override
    public void visit(Plataforma p, int direccion){}
    @Override
    public void visit(Estrella e, int direccion){}
    @Override
    public void visit(LadrilloRompible lr, int direccion){}
    @Override
    public void visit(BloqueIrrompible bi, int direccion){}
    @Override
    public void visit(Meta m, int direccion){}
    @Override
    public void visit(Vacio v, int direccion){}
    @Override
    public void visit(PowerUp pu, int direccion){}
    @Override
    public void visit(BolaDeFuego bf, int direccion){}
}
