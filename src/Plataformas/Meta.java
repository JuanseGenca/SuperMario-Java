package Plataformas;

import GUI.Sprite;
import Logica.Visitor;
import Visitors.VisitorMeta;

public class Meta extends Plataforma{
    
    public Meta(int posicionX ,int posicionY,Sprite sprite[]){
        super(posicionX,posicionY,sprite);
        visitor = new VisitorMeta();
        actualizarHitboxes(posicionX, posicionY-24, ancho, alto);
    }

    public void aceptar(Visitor visitor, int direccion){
        visitor.visit(this, direccion);
    }

    public void pasarNivel() {
        spriteActual = misSprites[1];
        actualizar(direccion, estadoAereo);
    }

    public void mover(){
    }
}
