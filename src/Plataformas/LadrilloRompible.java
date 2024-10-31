package Plataformas;

import GUI.Sprite;
import Logica.Visitor;
import Visitors.VisitorLadrilloRompible;

public class LadrilloRompible extends Plataforma{

    public LadrilloRompible(int x, int y,Sprite[] sprite){
        super(x, y, sprite);
        visitor= new VisitorLadrilloRompible();
    }
    
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }

    public void mover() {
    }

}
