package Plataformas;

import Logica.Visitor;

public class Meta extends Plataforma{
    public Meta(int x, int y){
        super(x,y);
    }

    public void aceptar(Visitor v) {
        v.visit(this);
    }

    public void moverDerecha() {
        //NO DEBERIA PODER MOVER PLATAFORMAS
    }

    public void moverIzquierda() {
        //NO DEBERIA PODER MOVER PLATAFORMAS
    }
}
