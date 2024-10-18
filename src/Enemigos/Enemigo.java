package Enemigos;

import Entidades.Entidad;
import Fabricas.SpriteFactory;
import GUI.Sprite;
import Logica.Visitor;

public abstract class Enemigo extends Entidad{
    public Enemigo(int x, int y, Sprite sprite, SpriteFactory sf){
        super(x,y,sprite, sf);
    }
    public abstract void aceptar(Visitor v);
    
    public void mover(){
        posicionX += 2;
        miObserver.actualizar();
    }
    
}
