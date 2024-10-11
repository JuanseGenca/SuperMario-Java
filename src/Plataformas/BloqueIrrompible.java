package Plataformas;

import Entidades.Entidad;
import Logica.Visitor;

public abstract class BloqueIrrompible extends Plataforma{
    //ATRIBUTOS
    protected Entidad entidadContenida;

    public BloqueIrrompible(int x ,int y){
        super(x,y);
    }
    public abstract void aceptar(Visitor v);
    public abstract Entidad getEntidadContenida();
    public abstract void setEntidadContenida(Entidad e);
    public abstract void mostrarEntidadContenida();
    public abstract void OcultarEntidad();

}
