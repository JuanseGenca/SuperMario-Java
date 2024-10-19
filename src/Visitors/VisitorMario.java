package Visitors;

import Enemigos.BuzzyBeetle;
import Enemigos.Goomba;
import Enemigos.KoopaTroopa;
import Enemigos.Lakitu;
import Enemigos.PiranhaPlant;
import Enemigos.Spiny;
import Entidades.BolaDeFuego;
import Entidades.Mario;
import Entidades.ConstantesEntidades;
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

public class VisitorMario implements Visitor{
    protected Mario mario;
    public VisitorMario(){

    }
    //DEFINIR TODAS MENOS LA DE MARIO :)
    public void visit(KoopaTroopa k){
        if(mario.getDireccion()==ConstantesColisiones.ABAJO) {
            k.recibirDanio();

        }
    }
    public void visit(Goomba g){
        if(mario.getDireccion()==ConstantesColisiones.ABAJO) {
            g.recibirDanio();

        }
    }
    public void visit(Lakitu l){
        if(mario.getDireccion()==ConstantesColisiones.ABAJO) {
            l.recibirDanio();

        }
    }
    public void visit(BuzzyBeetle b){
        if(mario.getDireccion()==ConstantesColisiones.ABAJO) {
            b.recibirDanio();

        }
    }
    public void visit(PiranhaPlant p){}
    public void visit(Spiny s){}
    public void visit(Mario m){}
    public void visit(ChampinionVerde cv){
        cv.recibirDanio();
    }
    public void visit(SuperChampinion sc){
        sc.recibirDanio();
    }
    public void visit(FlorDeFuego f){
        f.recibirDanio();
    }
    public void visit(Moneda m){
        m.recibirDanio();
    }
    public void visit(Plataforma p){}
    public void visit(Estrella e){
        e.recibirDanio();
    }
    //Reveer esto, ¿no es un instance of?, dejo planteada mi solucion, no se si es del todo correcta.
    public void visit(LadrilloRompible lr){
        if(mario.getDireccion()==ConstantesColisiones.ARRIBA && mario.getEstado()!=ConstantesPowerUp.NORMAL) {
            lr.recibirDanio();
        }
        //if(mario.getDireccion()==ConstantesColisiones.ARRIBA && mario.getEstado().puedeRomper() == true), es el mismo caso.
        //Si quedan dudas mirar las clases de los estados de mario, capaz es medio chancha la solucion.
        //Otra solucion seria que los estados implementes interfaces, puede romper y no puede romper, y de ahi resolver. Seria lo mas correcto.
    }
    public void visit(BloqueIrrompible bi){
        if(mario.getDireccion()==ConstantesColisiones.ARRIBA && mario.getEstado()!=ConstantesPowerUp.NORMAL) {
            bi.recibirDanio();
        }
    }
    public void visit(Meta m){}
    public void visit(Vacio v){}
    public void visit(PowerUp pu){}
    public void visit(BolaDeFuego bf){}
}
