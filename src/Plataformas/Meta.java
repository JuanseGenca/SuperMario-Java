package Plataformas;

import GUI.Sprite;
import Logica.Visitor;
import Visitors.VisitorMeta;

public class Meta extends Plataforma{
    
    public Meta(int x, int y,Sprite[] sprite){
        super(x,y, sprite);
        visitor = new VisitorMeta();
        actualizarHitboxes(posicionX, posicionY-24, ancho, alto);
    }

    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }

    public void pasarNivel() {
        spriteActual = misSprites[1];
        actualizar(direccion, estadoAereo);
    }

    public void mover(){
    }
}
