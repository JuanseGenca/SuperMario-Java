package Plataformas;

import java.awt.image.BufferedImage;

import Entidades.Entidad;
import Logica.Visitor;

public abstract class Plataforma extends Entidad{
    public Plataforma(int x, int y, BufferedImage[] sprite){
        super(x,y,sprite);
    }
    public abstract void aceptar(Visitor v);
}
