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
                mario.actualizarPuntaje(90);
                k.eliminar();
                System.out.println("Mate koopa");
            }
        }

        @Override
        public void visit(Goomba g, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA | direccion == ConstantesColisiones.ABAJO) {
                g.recibirDanio();
                mario.actualizarPuntaje(60);
                g.eliminar();
                System.out.println("mate goomba");
            }
        }

        @Override
        public void visit(Lakitu l, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA | direccion == ConstantesColisiones.ABAJO) {
                l.recibirDanio();
                mario.actualizarPuntaje(60);
                l.eliminar();
                System.out.println("mate lakitu");
            }
        }

        @Override
        public void visit(BuzzyBeetle b, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA | direccion == ConstantesColisiones.ABAJO) {
                b.recibirDanio();
                mario.actualizarPuntaje(30);
                b.eliminar();
                System.out.println("mate beetle");
            }
        }

        @Override
        public void visit(PiranhaPlant p, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA) {
                p.recibirDanio();
                mario.actualizarPuntaje(30);
                p.eliminar();
                System.out.println("mate beetle");
            }
        }

        @Override
        public void visit(Spiny s, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA) {
                s.recibirDanio();
                mario.actualizarPuntaje(60);
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
            mario.actualizarPuntaje(100);
            cv.eliminar();
            System.out.println("agarre champverde");
        }

        @Override
        public void visit(SuperChampinion sc, int direccion) {
            //sc.recibirDanio();
            int puntaje=0;
            if(mario.getEstado().getModificador()==ConstantesPowerUp.SUPERCHAMPINION){
                puntaje=50;
            } else {
                puntaje=10;
            }
            mario.actualizarPuntaje(puntaje);
            sc.eliminar();
            System.out.println("agarre superchamp");
        }

        @Override
        public void visit(FlorDeFuego f, int direccion) {
            int puntos = 0;
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

            mario.actualizarPuntaje(puntos);
            f.eliminar();
        }

        @Override
        public void visit(Moneda m, int direccion) {
            //m.recibirDanio();
            mario.actualizarPuntaje(5);
            m.eliminar();
            System.out.println("agarre moneda");
        }

        @Override
        public void visit(Plataforma p, int direccion) {
        }

        @Override
        public void visit(Estrella e, int direccion) {
            //e.recibirDanio();
            int puntos = 0;
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
            mario.actualizarPuntaje(puntos);
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
