package Logica;
import Enemigos.*;
import PowerUps.*;
import Entidades.*;
import Plataformas.*;

public interface Visitor {
    public void visit(KoopaTroopa k);
    public void visit(Goomba g);
    public void visit(Lakitu l);
    public void visit(BuzzyBeetle b);
    public void visit(PiranhaPlant p);
    public void visit(Spiny s);
    public void visit(Mario m);
    public void visit(ChampinionVerde cv);
    public void visit(SuperChampinion sc);
    public void visit(FlorDeFuego f);
    public void visit(Moneda m);
    public void visit(Plataforma p);
    public void visit(Estrella e);
    public void visit(LadrilloRompible lr);
    public void visit(BloqueIrrompible bi);
    public void visit(Meta m);
    public void visit(Vacio v);
    public void visit(PowerUp pu);
    public void visit(BolaDeFuego bf);
}
