package Visitors;

import Enemigos.BuzzyBeetle;
import Enemigos.Goomba;
import Enemigos.KoopaTroopa;
import Enemigos.Lakitu;
import Enemigos.Spiny;
import Entidades.Mario;
import Logica.ConstantesColisiones;
import Logica.ConstantesEntidades;
import PowerUps.ChampinionVerde;
import PowerUps.Estrella;
import PowerUps.SuperChampinion;

public class VisitorVacio extends VisitorPlataforma{
    public VisitorVacio(){
    }
    
    public void visit(KoopaTroopa koopaTroopa, int direccion){
        if(koopaTroopa.getPosicionY() == 0){
            koopaTroopa.cayoAlVacio = true;
        }
        koopaTroopa.aplicarGravedad();
    }
    
    public void visit(Goomba goomba, int direccion){
        if(goomba.getPosicionY() == 0){
            goomba.cayoAlVacio = true;
        }
        goomba.aplicarGravedad();
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
    }
    
    public void visit(BuzzyBeetle buzzyBeetle, int direccion){
        if(buzzyBeetle.getPosicionY() == 0){
            buzzyBeetle.cayoAlVacio = true;
        }
        buzzyBeetle.aplicarGravedad();
    }
    
    public void visit(Spiny spiny, int direccion){
        if(spiny.getPosicionY() == 0){
            spiny.cayoAlVacio = true;
        }
        spiny.aplicarGravedad();
    }
    
    public void visit(Mario mario, int direccion){
        if(mario.sobreY0()){
            mario.cayoAlVacio = true;
        }
        mario.aplicarGravedad();
    }
    
    public void visit(ChampinionVerde champinionVerde, int direccion){
        if(champinionVerde.getPosicionY() == 0){
            champinionVerde.cayoAlVacio = true;
        }
        champinionVerde.aplicarGravedad();
    }
    
    public void visit(SuperChampinion superChampinion, int direccion){
        if(superChampinion.getPosicionY() == 0){
            superChampinion.cayoAlVacio = true;
        }
        superChampinion.aplicarGravedad();
    }
    
    public void visit(Estrella estrella, int direccion){
        if(estrella.getPosicionY() == 0){
            estrella.cayoAlVacio = true;
        }
        estrella.aplicarGravedad();
    }
    
}
