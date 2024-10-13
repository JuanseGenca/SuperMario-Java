package GUI;

import java.awt.image.BufferedImage;

public  class Sprite {

    private BufferedImage imagen;
    private int posicionX, posicionY;

    public Sprite(BufferedImage imagen, int x, int y) {
        this.imagen = imagen;
        this.posicionX = x;
        this.posicionY = y;
    }

    public BufferedImage getImagen() {
        return imagen;
    }

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int x) {
        this.posicionX = x;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int y) {
        this.posicionY = y;
    }
}
