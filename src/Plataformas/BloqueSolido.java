package Plataformas;

import GUI.Sprite;
import Logica.Visitor;
import Visitors.VisitorBloqueSolido;

public class BloqueSolido extends Plataforma{
    
    public BloqueSolido(int x, int y, Sprite[] sprite){
        super(x,y,sprite);
        visitor=new VisitorBloqueSolido();
    }
    
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }

    public void mover(){
    }
}
