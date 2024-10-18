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

public class VisitorSuperChampinion extends VisitorPowerUp{
    public VisitorSuperChampinion(){

    }
    public void visit(KoopaTroopa k){}
    public void visit(Goomba g){}
    public void visit(Lakitu l){}
    public void visit(BuzzyBeetle b){}
    public void visit(PiranhaPlant p){}
    public void visit(Spiny s){}
    public void visit(Mario m){
        m.actualizarEstadoMario(ConstantesPowerUp.SUPERCHAMPINION);
    }
    public void visit(ChampinionVerde cv){}
    public void visit(SuperChampinion sc){}
    public void visit(FlorDeFuego f){}
    public void visit(Moneda m){}
    public void visit(Plataforma p){}
    public void visit(Estrella e){}
    public void visit(LadrilloRompible lr){}
    public void visit(BloqueIrrompible bi){}
    public void visit(Meta m){}
    public void visit(Vacio v){}
    public void visit(PowerUp pu){}
    public void visit(BolaDeFuego bf){}
}
