package Entidades;

import java.awt.image.BufferedImage;

public interface EntidadLogica{
    public BufferedImage[] getSprite();
    public int getPosicionX();
    public int getPosicionY();
    public int getDireccion();
}