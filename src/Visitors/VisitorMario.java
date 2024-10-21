package Visitors;

import Enemigos.BuzzyBeetle;
import Enemigos.Goomba;
import Enemigos.KoopaTroopa;
import Enemigos.Lakitu;
import Enemigos.PiranhaPlant;
import Enemigos.Spiny;
import Entidades.BolaDeFuego;
import Entidades.Mario;
import Logica.ConstantesColisiones;
import Logica.Visitor;
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

public class VisitorMario implements Visitor {
    protected Mario mario;

    public VisitorMario(Mario mario) {
        this.mario = mario;
    }

    @Override
    public void visit(KoopaTroopa k, int direccion) {
        if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA |  direccion == ConstantesColisiones.ABAJO) {
            k.recibirDanio();
            k.eliminar();
            System.out.println("Mate koopa");
        }
    }

    @Override
    public void visit(Goomba g, int direccion) {
        if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA | direccion == ConstantesColisiones.ABAJO) {
            g.recibirDanio();
            g.eliminar();
            System.out.println("mate goomba");
        }
    }

    @Override
    public void visit(Lakitu l, int direccion) {
        if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA | direccion == ConstantesColisiones.ABAJO) {
            l.recibirDanio();
            l.eliminar();
            System.out.println("mate lakitu");
        }
    }

    @Override
    public void visit(BuzzyBeetle b, int direccion) {
        if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA | direccion == ConstantesColisiones.ABAJO) {
            b.recibirDanio();
            b.eliminar();
            System.out.println("mate beetle");
        }
    }

    @Override
    public void visit(PiranhaPlant p, int direccion) {
        if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA) {
            p.recibirDanio();
            p.eliminar();
            System.out.println("mate beetle");
        }
    }

    @Override
    public void visit(Spiny s, int direccion) {
        if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA) {
            s.recibirDanio();
            s.eliminar();
            System.out.println("mate beetle");
        }
    }

    @Override
    public void visit(Mario m, int direccion) {
    }

    @Override
    public void visit(ChampinionVerde cv, int direccion) {
        //cv.recibirDanio();
        cv.eliminar();
        System.out.println("agarre champverde");
    }

    @Override
    public void visit(SuperChampinion sc, int direccion) {
        //sc.recibirDanio();
        sc.eliminar();
        System.out.println("agarre superchamp");
    }

    @Override
    public void visit(FlorDeFuego f, int direccion) {
        //f.recibirDanio();
        f.eliminar();
        System.out.println("agarre flor");
    }

    @Override
    public void visit(Moneda m, int direccion) {
        //m.recibirDanio();
        m.eliminar();
        System.out.println("agarre moneda");
    }

    @Override
    public void visit(Plataforma p, int direccion) {
    }

    @Override
    public void visit(Estrella e, int direccion) {
        //e.recibirDanio();
        e.eliminar();
        System.out.println("agarre estrella");
    }

    @Override
    public void visit(LadrilloRompible lr, int direccion) {
        if (direccion == ConstantesColisiones.ARRIBA && mario.getEstado().getModificador() != ConstantesPowerUp.NORMAL) {
            lr.recibirDanio();
            lr.eliminar();
        }
    }

    @Override
    public void visit(BloqueIrrompible bi, int direccion) {
        if (direccion == ConstantesColisiones.ARRIBA && mario.getEstado().getModificador() != ConstantesPowerUp.NORMAL) {
            bi.recibirDanio();
        }
    }

    @Override
    public void visit(Meta m, int direccion) {
    }

    @Override
    public void visit(Vacio v, int direccion) {
    }

    @Override
    public void visit(PowerUp pu, int direccion) {
    }

    @Override
    public void visit(BolaDeFuego bf, int direccion) {
    }
}
