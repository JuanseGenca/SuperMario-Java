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

    public class VisitorMario implements Visitor {
        protected Mario mario;

        public VisitorMario(Mario mario) {
            this.mario = mario;
        }

        @Override
        public void visit(KoopaTroopa k, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA |  direccion == ConstantesColisiones.ABAJO) {
                k.recibirDanio();
                mario.reproducirSonido("matar");
                mario.actualizarPuntaje(90);
                //k.eliminar();  
            }
        }

        @Override
        public void visit(Goomba g, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA | direccion == ConstantesColisiones.ABAJO) {
                g.recibirDanio(0);
                mario.reproducirSonido("matar");
                mario.actualizarPuntaje(60);
                g.eliminar();
            }
        }

        @Override
        public void visit(Lakitu l, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA | direccion == ConstantesColisiones.ABAJO) {
                l.recibirDanio(0);
                mario.reproducirSonido("matar");
                mario.actualizarPuntaje(60);
                l.eliminar();
            }
        }

        @Override
        public void visit(BuzzyBeetle b, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA | direccion == ConstantesColisiones.ABAJO) {
                b.recibirDanio(0);
                mario.reproducirSonido("matar");
                mario.actualizarPuntaje(30);
                b.eliminar();
            }
        }

        @Override
        public void visit(PiranhaPlant p, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA) {
                p.recibirDanio(0);
                mario.reproducirSonido("matar");
                mario.actualizarPuntaje(30);
                p.eliminar();   
            }
        }

        @Override
        public void visit(Spiny s, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA) {
                s.recibirDanio(0);
                mario.reproducirSonido("matar");
                mario.actualizarPuntaje(60);
                s.eliminar();
            }
        }

        @Override
        public void visit(Mario m, int direccion) {
            System.out.println("si alguien alguna vez llega a ver este mensaje en la terminal, es momento de dejar la carrera");
        }

        @Override
        public void visit(ChampinionVerde cv, int direccion) {
            mario.actualizarPuntaje(100);
            mario.reproducirSonido("vida");
            cv.eliminar();
        }

        @Override
        public void visit(SuperChampinion sc, int direccion) {
            mario.actualizarPuntaje(puntajeSuperChampinion());
            mario.reproducirSonido("powerUp");
            sc.eliminar();
        }

        @Override
        public void visit(FlorDeFuego f, int direccion) {
            mario.actualizarPuntaje(puntajeFlorDeFuego());
            mario.reproducirSonido("powerUp");
            f.eliminar();
        }

        @Override
        public void visit(Moneda m, int direccion) {
            mario.actualizarPuntaje(5);
            mario.reproducirSonido("moneda");
            m.eliminar();
        }

        @Override
        public void visit(Plataforma p, int direccion) {
        }

        @Override
        public void visit(Estrella e, int direccion) {
            mario.actualizarPuntaje(puntajeEstrella());
            mario.reproducirSonido("powerUp");
            e.eliminar();
        }

        @Override
        public void visit(LadrilloRompible lr, int direccion) {
            if (direccion == ConstantesColisiones.ARRIBA && mario.getEstado().getModificador() != ConstantesPowerUp.NORMAL) {
                mario.reproducirSonido("romperPlataforma");
                lr.recibirDanio(0);
                lr.eliminar();
            }
        }

        @Override
        public void visit(BloqueIrrompible bi, int direccion) {
            if (direccion == ConstantesColisiones.ARRIBA && mario.getEstado().getModificador() != ConstantesPowerUp.NORMAL) {
                bi.recibirDanio(0);
            }
        }

        @SuppressWarnings("override")
        public void visit(BloquePregunta bp, int direccion){
            if(direccion == ConstantesColisiones.ARRIBA){
                mario.reproducirSonido("romperPlataforma"); //Agregar sonido de que sale el power up
                bp.getEntidadContenida();
                bp.recibirDanio(0);
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

    private int puntajeEstrella() {
        int puntos;
            switch (mario.getEstado().getModificador()) {
                case ConstantesPowerUp.ESTRELLA:
                    puntos = 35;
                    break;
                case ConstantesPowerUp.SUPERCHAMPINION:
                    puntos = 30;
                    break;
                default:
                    puntos = 20;
            }
            return puntos;
    }

    private int puntajeFlorDeFuego() {
        int puntos;
        switch (mario.getEstado().getModificador()) {
            case ConstantesPowerUp.FLORDEFUEGO:
                puntos = 50;
                break;
            case ConstantesPowerUp.SUPERCHAMPINION:
                puntos = 30;
                break;
            default:
                puntos = 10;
        }
        return puntos;
    }

    private int puntajeSuperChampinion() {
        int puntaje;
            if(mario.getEstado().getModificador()==ConstantesPowerUp.SUPERCHAMPINION){
                puntaje=50;
            } else {
                puntaje=10;
            }
        return puntaje;
    }
}
