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
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

    public class VisitorMario implements Visitor {
        protected Mario mario;

        public VisitorMario(Mario mario) {
            this.mario = mario;
        }

        @Override
        public void visit(KoopaTroopa k, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA |  direccion == ConstantesColisiones.ABAJO) {
                k.recibirDanio();
                reproducirSonido("src//Sonidos//Squish.wav");
                mario.actualizarPuntaje(90);
                k.eliminar();  
            }
        }

        @Override
        public void visit(Goomba g, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA | direccion == ConstantesColisiones.ABAJO) {
                g.recibirDanio();
                reproducirSonido("src//Sonidos//Squish.wav");
                mario.actualizarPuntaje(60);
                g.eliminar();
            }
        }

        @Override
        public void visit(Lakitu l, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA | direccion == ConstantesColisiones.ABAJO) {
                l.recibirDanio();
                reproducirSonido("src//Sonidos//Squish.wav");
                mario.actualizarPuntaje(60);
                l.eliminar();
            }
        }

        @Override
        public void visit(BuzzyBeetle b, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA | direccion == ConstantesColisiones.ABAJO) {
                b.recibirDanio();
                reproducirSonido("src//Sonidos//Squish.wav");
                mario.actualizarPuntaje(30);
                b.eliminar();
            }
        }

        @Override
        public void visit(PiranhaPlant p, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA) {
                p.recibirDanio();
                reproducirSonido("src//Sonidos//Squish.wav");
                mario.actualizarPuntaje(30);
                p.eliminar();
                
            }
        }

        @Override
        public void visit(Spiny s, int direccion) {
            if (mario.getEstado().getModificador()==ConstantesPowerUp.ESTRELLA) {
                s.recibirDanio();
                reproducirSonido("src//Sonidos//Squish.wav");
                mario.actualizarPuntaje(60);
                s.eliminar();
            }
        }

        @Override
        public void visit(Mario m, int direccion) {
        }

        @Override
        public void visit(ChampinionVerde cv, int direccion) {
            mario.actualizarPuntaje(100);
            reproducirSonido("src//Sonidos//1up.wav");
            cv.eliminar();
        }

        @Override
        public void visit(SuperChampinion sc, int direccion) {
            mario.actualizarPuntaje(puntajeSuperChampinion());
            reproducirSonido("src//Sonidos//Item.wav");
            sc.eliminar();
        }

        @Override
        public void visit(FlorDeFuego f, int direccion) {
            mario.actualizarPuntaje(puntajeFlorDeFuego());
            reproducirSonido("src//Sonidos//Item.wav");
            f.eliminar();
        }

        @Override
        public void visit(Moneda m, int direccion) {
            mario.actualizarPuntaje(5);
            reproducirSonido("src//Sonidos//Coin.wav");
            m.eliminar();
        }

        @Override
        public void visit(Plataforma p, int direccion) {
        }

        @Override
        public void visit(Estrella e, int direccion) {
            mario.actualizarPuntaje(puntajeEstrella());
            reproducirSonido("src//Sonidos//Item.wav");
            e.eliminar();
        }

        @Override
        public void visit(LadrilloRompible lr, int direccion) {
            if (direccion == ConstantesColisiones.ARRIBA && mario.getEstado().getModificador() != ConstantesPowerUp.NORMAL) {
                reproducirSonido("src//Sonidos//Break.wav");
                lr.recibirDanio();
                lr.eliminar();
            }
        }

        @Override
        public void visit(BloqueIrrompible bi, int direccion) {
            if (direccion == ConstantesColisiones.ARRIBA && mario.getEstado().getModificador() != ConstantesPowerUp.NORMAL) {
                reproducirSonido("src//Sonidos//Break.wav");
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

    private void reproducirSonido(String rutaArchivo) {
        try {
            File archivoSonido = new File(rutaArchivo);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
