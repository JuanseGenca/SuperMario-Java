package Enemigos;

import Entidades.ConstantesEntidades;
import GUI.Sprite;
import Logica.Visitor;

public class PiranhaPlant extends Enemigo{
    public PiranhaPlant(int x, int y,Sprite[] sprite){
        super(x,y,sprite);
        puntaje=30;
    }
    
    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }

    @Override
    public void mover(){
        miObserver.actualizar();
        actualizarHitboxes(posicionX, posicionY, ancho, alto);
    }

    @Override
    public int getZIndex(){
        return ConstantesEntidades.FONDO;
    }
}
