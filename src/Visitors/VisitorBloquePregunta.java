package Visitors;

import Enemigos.BuzzyBeetle;
import Enemigos.Goomba;
import Enemigos.KoopaTroopa;
import Enemigos.Lakitu;
import Enemigos.Spiny;
import Entidades.BolaDeFuego;
import Entidades.Mario;
import Logica.ConstantesColisiones;
import Logica.ConstantesEntidades;
import PowerUps.ChampinionVerde;
import PowerUps.Estrella;
import PowerUps.SuperChampinion;

public class VisitorBloquePregunta extends VisitorPlataforma{

    public VisitorBloquePregunta(){
    }
    
    public void visit(Mario mario, int direccion){
        if(direccion == ConstantesColisiones.DERECHA){
            mario.setVelocidadX(0);
            mario.setPosicionx(mario.getPosicionX() - 2);
        }
        if(direccion == ConstantesColisiones.IZQUIERDA){
            mario.setVelocidadX(0);
            mario.setPosicionx(mario.getPosicionX() + 2);
        }
        if(direccion == ConstantesColisiones.ABAJO){
            if(mario.getVelocidadY() >= 0) 
                mario.setVelocidadY(0);
        }
        if(direccion == ConstantesColisiones.ARRIBA){
            mario.tocoSuelo();
        }
    }

    public void visit(Estrella estrella,int direccion){
        if(direccion == ConstantesColisiones.DERECHA){
            estrella.setPosicionx(estrella.getPosicionX() - 4);
            estrella.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }
        if(direccion == ConstantesColisiones.IZQUIERDA){
            estrella.setPosicionx(estrella.getPosicionX() + 4);
            estrella.establecerDireccion(ConstantesEntidades.DERECHA);
        }
        if(direccion == ConstantesColisiones.ARRIBA){
            estrella.tocoSuelo();
        } 
    }

    public void visit(ChampinionVerde champinionverde,int direccion){
        if(direccion == ConstantesColisiones.DERECHA){
            champinionverde.setPosicionx(champinionverde.getPosicionX() - 4);
            champinionverde.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }
        if(direccion == ConstantesColisiones.IZQUIERDA){
            champinionverde.setPosicionx(champinionverde.getPosicionX() + 4);
            champinionverde.establecerDireccion(ConstantesEntidades.DERECHA);
        }
        if(direccion == ConstantesColisiones.ARRIBA){
            champinionverde.tocoSuelo();
        }
    }

    public void visit(SuperChampinion superchampinion,int direccion){
        if(direccion == ConstantesColisiones.DERECHA){
            superchampinion.setPosicionx(superchampinion.getPosicionX() - 4);
            superchampinion.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }
        if(direccion == ConstantesColisiones.IZQUIERDA){
            superchampinion.setPosicionx(superchampinion.getPosicionX() + 4);
            superchampinion.establecerDireccion(ConstantesEntidades.DERECHA);
        }
        if(direccion == ConstantesColisiones.ARRIBA){
            superchampinion.tocoSuelo();
        }
    }

    public void visit(BolaDeFuego bolaDeFuego, int direccion) {
        bolaDeFuego.eliminar();
        bolaDeFuego.recibirDanio(0);
    }

    public void visit(KoopaTroopa koopatroopa, int direccion){
        if(direccion == ConstantesColisiones.DERECHA){
            koopatroopa.setPosicionx(koopatroopa.getPosicionX() - 4);
            koopatroopa.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }
        if(direccion == ConstantesColisiones.IZQUIERDA){
            koopatroopa.setPosicionx(koopatroopa.getPosicionX() + 4);
            koopatroopa.establecerDireccion(ConstantesEntidades.DERECHA);
        }
        if(direccion == ConstantesColisiones.ARRIBA){
            koopatroopa.tocoSuelo();
        }
    }

    public void visit(Goomba goomba, int direccion){
        if(direccion == ConstantesColisiones.DERECHA){
            goomba.setPosicionx(goomba.getPosicionX() - 4);
            goomba.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }
        if(direccion == ConstantesColisiones.IZQUIERDA){
            goomba.setPosicionx(goomba.getPosicionX() + 4);
            goomba.establecerDireccion(ConstantesEntidades.DERECHA);
        }
        if(direccion == ConstantesColisiones.ARRIBA){
            goomba.tocoSuelo();
        }
    }
    
    public void visit(Lakitu lakitu, int direccion){
        if(direccion == ConstantesColisiones.DERECHA){
            lakitu.setPosicionx(lakitu.getPosicionX() - 4);
            lakitu.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }
        if(direccion == ConstantesColisiones.IZQUIERDA){
            lakitu.setPosicionx(lakitu.getPosicionX() + 4);
            lakitu.establecerDireccion(ConstantesEntidades.DERECHA);
        }
        if(direccion == ConstantesColisiones.ARRIBA){
            lakitu.tocoSuelo();
        }
    }
    
    public void visit(BuzzyBeetle buzzybeetle, int direccion){
        if(direccion == ConstantesColisiones.DERECHA){
            buzzybeetle.setPosicionx(buzzybeetle.getPosicionX() - 4);
            buzzybeetle.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }
        if(direccion == ConstantesColisiones.IZQUIERDA){
            buzzybeetle.setPosicionx(buzzybeetle.getPosicionX() + 4);
            buzzybeetle.establecerDireccion(ConstantesEntidades.DERECHA);
        }
        if(direccion == ConstantesColisiones.ARRIBA){
            buzzybeetle.tocoSuelo();
        }
    }
    
    public void visit(Spiny spiny, int direccion){
        if(direccion == ConstantesColisiones.DERECHA){
            spiny.setPosicionx(spiny.getPosicionX() - 4);
            spiny.establecerDireccion(ConstantesEntidades.IZQUIERDA);
        }
        if(direccion == ConstantesColisiones.IZQUIERDA){
            spiny.setPosicionx(spiny.getPosicionX() + 4);
            spiny.establecerDireccion(ConstantesEntidades.DERECHA);
        }
        if(direccion == ConstantesColisiones.ARRIBA){
            spiny.tocoSuelo();
        }
    }
}
