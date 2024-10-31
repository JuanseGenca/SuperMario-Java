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
import Logica.ConstantesSonidos;
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

        public void visit(KoopaTroopa k, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA |  direccion == ConstantesColisiones.ABAJO) {
                k.recibirDanio();
                mario.reproducirSonido(ConstantesSonidos.MATAR);
                mario.actualizarPuntaje(90);
            }
            
            if(k.getEstado().esVulnerable()) {
                k.recibirDanio();
            }
        }

        public void visit(Goomba g, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA | direccion == ConstantesColisiones.ABAJO) {
                g.recibirDanio(0);
                mario.reproducirSonido(ConstantesSonidos.MATAR);
                mario.actualizarPuntaje(60);
                g.eliminar();
            }
        }

        public void visit(Lakitu l, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA | direccion == ConstantesColisiones.ABAJO) {
                l.recibirDanio(0);
                mario.reproducirSonido(ConstantesSonidos.MATAR);
                mario.actualizarPuntaje(60);
                l.eliminar();
            }
        }

        public void visit(BuzzyBeetle b, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA | direccion == ConstantesColisiones.ABAJO) {
                b.recibirDanio(0);
                mario.reproducirSonido(ConstantesSonidos.MATAR);
                mario.actualizarPuntaje(30);
                b.eliminar();
            }
        }

        public void visit(PiranhaPlant p, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA) {
                p.recibirDanio(0);
                mario.reproducirSonido(ConstantesSonidos.MATAR);
                mario.actualizarPuntaje(30);
                p.eliminar();   
            }
        }

        public void visit(Spiny s, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA) {
                s.recibirDanio(0);
                mario.reproducirSonido(ConstantesSonidos.MATAR);
                mario.actualizarPuntaje(60);
                s.eliminar();
            }
        }

        public void visit(Mario m, int direccion) {
            System.out.println("si alguien alguna vez llega a ver este mensaje en la terminal, es momento de dejar la carrera");
        }

        public void visit(ChampinionVerde cv, int direccion) {
            mario.actualizarPuntaje(100);
            mario.reproducirSonido(ConstantesSonidos.POWERUP); 
            cv.eliminar();
        }

        public void visit(SuperChampinion sc, int direccion) {
            mario.actualizarPuntaje(puntajeSuperChampinion());
            mario.reproducirSonido(ConstantesSonidos.POWERUP); 
            sc.eliminar();
        }

        public void visit(FlorDeFuego f, int direccion) {
            mario.actualizarPuntaje(puntajeFlorDeFuego());
            mario.reproducirSonido(ConstantesSonidos.POWERUP); 
            f.eliminar();
        }

        public void visit(Moneda m, int direccion) {
            mario.actualizarPuntaje(5);
            mario.reproducirSonido(ConstantesSonidos.MONEDA); 
            m.eliminar();
        }

        public void visit(Plataforma p, int direccion) {
        }

        public void visit(Estrella e, int direccion) {
            mario.actualizarPuntaje(puntajeEstrella());
            mario.reproducirSonido(ConstantesSonidos.POWERUP); 
            e.eliminar();
        }

        public void visit(LadrilloRompible lr, int direccion) {
            if (direccion == ConstantesColisiones.ARRIBA && mario.getEstado().getModificador() != ConstantesPowerUp.NORMAL) {
                mario.reproducirSonido(ConstantesSonidos.ROMPERPLATAFORMA); 
                lr.recibirDanio(0);
                lr.eliminar();
            }
        }

        public void visit(BloqueIrrompible bi, int direccion) {
            if (direccion == ConstantesColisiones.ARRIBA && mario.getEstado().getModificador() != ConstantesPowerUp.NORMAL) {
                bi.recibirDanio(0);
            }
        }

        public void visit(BloquePregunta bp, int direccion){
            if(direccion == ConstantesColisiones.ARRIBA){
                mario.reproducirSonido(ConstantesSonidos.ROMPERPLATAFORMA); //Agregar sonido de que sale el power up
                bp.getEntidadContenida();
                bp.recibirDanio(0);
            }
        }

        public void visit(Meta m, int direccion) {}

        public void visit(Vacio v, int direccion) {}

        public void visit(PowerUp pu, int direccion) {}

        public void visit(BolaDeFuego bf, int direccion) {}

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
