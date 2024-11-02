package Visitors;
import java.util.Timer;
import java.util.TimerTask;

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
        public void visit(KoopaTroopa koopaTroopa, int direccion) {
    
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA |  direccion == ConstantesColisiones.ABAJO) {
                koopaTroopa.recibirDanio();
                mario.reproducirSonido(ConstantesSonidos.MATAR);
                mario.actualizarPuntaje(90);
            }
            
            if(koopaTroopa.getEstado().esVulnerable()) {
                koopaTroopa.recibirDanio();
            }
        }
        public void visit(Goomba goomba, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA | direccion == ConstantesColisiones.ABAJO) {
                goomba.recibirDanio(0);
                mario.reproducirSonido(ConstantesSonidos.MATAR);
                mario.actualizarPuntaje(60);
                if(mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA){
                    goomba.eliminar();
                }
                else {
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        goomba.eliminar();
                    }
                }, 300);
                }
            }
        }
        public void visit(Lakitu lakitu, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA | direccion == ConstantesColisiones.ABAJO) {
                lakitu.recibirDanio(0);
                mario.reproducirSonido(ConstantesSonidos.MATAR);
                mario.actualizarPuntaje(60);
                lakitu.eliminar();
            }
        }

        public void visit(BuzzyBeetle buzzyBeetle, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA | direccion == ConstantesColisiones.ABAJO) {
                buzzyBeetle.recibirDanio(0);
                mario.reproducirSonido(ConstantesSonidos.MATAR);
                mario.actualizarPuntaje(30);
                if(mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA){
                    buzzyBeetle.eliminar();
                }
                else {
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        buzzyBeetle.eliminar();
                    }
                }, 300);
                }
            }
        }

        public void visit(PiranhaPlant piranhaPlant, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA) {
                piranhaPlant.recibirDanio(0);
                mario.reproducirSonido(ConstantesSonidos.MATAR);
                mario.actualizarPuntaje(30);
                piranhaPlant.eliminar();   
            }
        }

        public void visit(Spiny spiny, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA) {
                spiny.recibirDanio(0);
                mario.reproducirSonido(ConstantesSonidos.MATAR);
                mario.actualizarPuntaje(60);
                spiny.eliminar();
            }
        }

        public void visit(Mario mario, int direccion) {
            System.out.println("si alguien alguna vez llega a ver este mensaje en la terminal, es momento de dejar la carrera");
        }

        public void visit(ChampinionVerde champinionVerde, int direccion) {
            mario.actualizarPuntaje(100);
            mario.reproducirSonido(ConstantesSonidos.POWERUP); 
            champinionVerde.eliminar();
        }

        public void visit(SuperChampinion superChampinion, int direccion) {
            mario.actualizarPuntaje(puntajeSuperChampinion());
            mario.reproducirSonido(ConstantesSonidos.POWERUP); 
            superChampinion.eliminar();
        }

        public void visit(FlorDeFuego florDeFuego, int direccion) {
            mario.actualizarPuntaje(puntajeFlorDeFuego());
            mario.reproducirSonido(ConstantesSonidos.POWERUP); 
            florDeFuego.eliminar();
        }

        public void visit(Moneda moneda, int direccion) {
            mario.actualizarPuntaje(5);
            mario.reproducirSonido(ConstantesSonidos.MONEDA); 
            moneda.eliminar();
        }

        public void visit(Plataforma plataforma, int direccion) {
        }

        public void visit(Estrella estrella, int direccion) {
            mario.actualizarPuntaje(puntajeEstrella());
            mario.reproducirSonido(ConstantesSonidos.POWERUP); 
            estrella.eliminar();
        }

        public void visit(LadrilloRompible ladrilloRompible, int direccion) {
            if (direccion == ConstantesColisiones.ARRIBA && mario.getEstado().getModificador() != ConstantesPowerUp.NORMAL) {
                mario.reproducirSonido(ConstantesSonidos.ROMPERPLATAFORMA); 
                ladrilloRompible.recibirDanio(0);
                ladrilloRompible.eliminar();
            }
        }

        public void visit(BloqueIrrompible bloqueIrrompible, int direccion) {
        }

        public void visit(BloquePregunta bloquePregunta, int direccion){
            if(direccion == ConstantesColisiones.ARRIBA){
                mario.reproducirSonido(ConstantesSonidos.ROMPERPLATAFORMA); //Agregar sonido de que sale el power up
                bloquePregunta.getEntidadContenida();
                bloquePregunta.recibirDanio(0);
            }
        }

        public void visit(Meta meta, int direccion) {
            meta.pasarNivel();
        }

        public void visit(Vacio vacio, int direccion) {}

        public void visit(PowerUp powerUp, int direccion) {}

        public void visit(BolaDeFuego bolaDeFuego, int direccion) {}

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

