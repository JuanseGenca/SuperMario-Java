package Logica;

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

public abstract class VisitorPlataforma implements Visitor{
    public abstract void visit(KoopaTroopa k);
    public abstract void visit(Goomba g);
    public abstract void visit(Lakitu l);
    public abstract void visit(BuzzyBeetle b);
    public abstract void visit(PiranhaPlant p);
    public abstract void visit(Spiny s);
    public abstract void visit(Mario m);
    public abstract void visit(ChampinionVerde cv);
    public abstract void visit(SuperChampinion sc);
    public abstract void visit(FlorDeFuego f);
    public abstract void visit(Moneda m);
    public void visit(Plataforma p){}
    public abstract void visit(Estrella e);
    public void visit(LadrilloRompible lr){}
    public void visit(BloqueIrrompible bi){}
    public void visit(Meta m){}
    public void visit(Vacio v){}
    public abstract void visit(PowerUp pu);
    public abstract void visit(BolaDeFuego bf);
}
