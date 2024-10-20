package Plataformas;

import GUI.Sprite;
import Logica.Visitor;
import Visitors.VisitorMeta;

public class Meta extends Plataforma{
    public Meta(int x, int y,Sprite[] sprite){
        super(x,y, sprite);
        visitor = new VisitorMeta();
    }

    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }

    public void mover(){
        
    }
}
