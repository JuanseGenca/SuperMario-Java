package Logica;
import Enemigos.*;
import PowerUps.*;
import Entidades.*;
import Plataformas.*;

public interface Visitor {
    public void visit(KoopaTroopa k, int direccion);
    public void visit(Goomba g, int direccion);
    public void visit(Lakitu l, int direccion);
    public void visit(BuzzyBeetle b, int direccion);
    public void visit(PiranhaPlant p, int direccion);
    public void visit(Spiny s, int direccion);
    public void visit(Mario m, int direccion);
    public void visit(ChampinionVerde cv, int direccion);
    public void visit(SuperChampinion sc, int direccion);
    public void visit(FlorDeFuego f, int direccion);
    public void visit(Moneda m, int direccion);
    public void visit(Plataforma p, int direccion);
    public void visit(Estrella e, int direccion);
    public void visit(LadrilloRompible lr, int direccion);
    public void visit(BloqueIrrompible bi, int direccion);
    public void visit(Meta m, int direccion);
    public void visit(Vacio v, int direccion);
    public void visit(PowerUp pu, int direccion);
    public void visit(BolaDeFuego bf, int direccion);
    public void visit(BloquePregunta bp,int direccion);
}
