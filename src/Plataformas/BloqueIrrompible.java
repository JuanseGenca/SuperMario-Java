package Plataformas;

import Entidades.Entidad;
import GUI.Sprite;
import Logica.Visitor;

public abstract class BloqueIrrompible extends Plataforma{
    
    protected Entidad entidadContenida;

    public BloqueIrrompible(int posicionX ,int posicionY,Sprite sprite[]){
        super(posicionX,posicionY,sprite);
    }
    
    public abstract void aceptar(Visitor visitor, int direccion);
    public abstract Entidad getEntidadContenida();
    public abstract void setEntidadContenida(Entidad entidad);
    public abstract void mostrarEntidadContenida();
    public abstract void OcultarEntidad();

}
