package Plataformas;

import Entidades.Entidad;
import Fabricas.SpriteFactory;
import GUI.Sprite;
import Logica.Visitor;

public abstract class Plataforma extends Entidad{
    public Plataforma(int x, int y, Sprite sprite, SpriteFactory sf){
        super(x,y,sprite, sf);
    }
    public abstract void aceptar(Visitor v);
}
