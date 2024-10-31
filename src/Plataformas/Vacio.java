package Plataformas;

import GUI.Sprite;
import Logica.Visitor;
import Visitors.VisitorVacio;

public class Vacio extends Plataforma{

    public Vacio(int x,int y,Sprite[] sprite){
        super(x,y, sprite);
        visitor = new VisitorVacio();
    }
    
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }

    public void mover(){ 
    }

}
