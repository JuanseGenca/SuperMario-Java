package Plataformas;

import Entidades.Entidad;
import GUI.Sprite;


import Logica.Visitor;

public abstract class BloqueIrrompible extends Plataforma{
    //ATRIBUTOS
    protected Entidad entidadContenida;

    public BloqueIrrompible(int x ,int y,Sprite sprite ){
        super(x,y,sprite);
    }
    public abstract void aceptar(Visitor v);
    public abstract Entidad getEntidadContenida();
    public abstract void setEntidadContenida(Entidad e);
    public abstract void mostrarEntidadContenida();
    public abstract void OcultarEntidad();

}
