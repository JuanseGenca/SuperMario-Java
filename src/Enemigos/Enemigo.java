package Enemigos;

import Entidades.Entidad;
import GUI.Sprite;
import Logica.Visitor;
import Visitors.VisitorEnemigo;

public abstract class Enemigo extends Entidad{
    public Enemigo(int x, int y, Sprite[] sprite){
        super(x,y,sprite);
        visitor = new VisitorEnemigo();
    }
    @Override
    public abstract void aceptar(Visitor v, int direccion);
    
    public void mover(){
        posicionX += 1;
        miObserver.actualizar();
    }
    
}
