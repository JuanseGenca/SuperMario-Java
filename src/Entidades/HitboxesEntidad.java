package Entidades;

import java.awt.Rectangle;

public class HitboxesEntidad {

    protected Rectangle hitbox;

    public HitboxesEntidad(int posicionX, int posicionY, int ancho, int alto) {
        hitbox = new Rectangle(posicionX, posicionY, ancho, alto);
    }

    public void actualizarHitboxes(int posicionX, int posicionY, int ancho, int alto) {
        hitbox.setBounds(posicionX, posicionY, ancho, alto);
    }

    public Rectangle getHitbox() {
        return hitbox;
    }
}
