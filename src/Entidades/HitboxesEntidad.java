package Entidades;

import java.awt.Rectangle;

public class HitboxesEntidad {
    protected Rectangle hitboxSuperior;
    protected Rectangle hitboxInferior;
    protected Rectangle hitboxLateral;


    public HitboxesEntidad(int posicionX, int posicionY, int ancho, int alto) {
        hitboxSuperior = new Rectangle(posicionX, posicionY, ancho, alto / 4);
        hitboxInferior = new Rectangle(posicionX, posicionY + (3 * alto / 4), ancho, alto / 4);
        hitboxLateral = new Rectangle(posicionX, posicionY + (alto / 4), ancho, alto / 2);
    }

    public void actualizarHitboxes(int posicionX, int posicionY, int ancho, int alto) {
        hitboxSuperior.setBounds(posicionX, posicionY, ancho, alto / 4);
        hitboxInferior.setBounds(posicionX, posicionY + (3 * alto / 4), ancho, alto / 4);
        hitboxLateral.setBounds(posicionX, posicionY + (alto / 4), ancho, alto / 2);
    }

    public Rectangle getHitboxSuperior() {
        return hitboxSuperior;
    }

    public Rectangle getHitboxLateral() {
        return hitboxLateral;
    }

    public Rectangle getHitboxInferior() {
        return hitboxInferior;
    }

}
