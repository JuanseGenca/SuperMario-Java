package Enemigos;

import Entidades.ManejadorEntidades;
import GUI.Sprite;
import Logica.*;

public class Goomba extends Enemigo{

    public Goomba(int x, int y,Sprite[] sprite){
        super(x,y,sprite);
        
    }
    
    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }
    public void eliminar(){
        ManejadorEntidades.getInstancia().eliminarEnemigo(this);
    }
}
