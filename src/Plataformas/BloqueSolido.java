package Plataformas;

import GUI.Sprite;
import Logica.Visitor;
import Visitors.VisitorBloqueSolido;

public class BloqueSolido extends Plataforma{
    
    public BloqueSolido(int posicionX, int posicionY, Sprite[] sprite){
        super(posicionX ,posicionY,sprite);
        visitor=new VisitorBloqueSolido();
    }
    
    public void aceptar(Visitor visitor, int direccion){
        visitor.visit(this, direccion);
    }

    public void mover(){
    }
}
