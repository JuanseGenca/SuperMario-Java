package Plataformas;

import GUI.Sprite;
import Logica.Visitor;
import Visitors.VisitorVacio;

public class Vacio extends Plataforma{

    public Vacio(int posicionX ,int posicionY,Sprite sprite[]){
        super(posicionX,posicionY,sprite);
        visitor = new VisitorVacio();
    }
    
    public void aceptar(Visitor visitor, int direccion){
        visitor.visit(this, direccion);
    }

}
