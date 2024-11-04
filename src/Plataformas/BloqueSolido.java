package Plataformas;

import GUI.Sprite;
import Logica.Visitor;

public class BloqueSolido extends Plataforma{
    
    public BloqueSolido(int posicionX, int posicionY, Sprite[] sprite){
        super(posicionX ,posicionY,sprite);
    }
    
    public void aceptar(Visitor visitor, int direccion){
        visitor.visit(this, direccion);
    }
}
