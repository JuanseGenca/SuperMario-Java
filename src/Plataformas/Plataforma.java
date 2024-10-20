package Plataformas;

import Entidades.Entidad;
import GUI.Sprite;
import Logica.Visitor;

public abstract class Plataforma extends Entidad{
    public Plataforma(int x, int y, Sprite[] sprite){
        super(x,y,sprite);
    }
    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }
}
