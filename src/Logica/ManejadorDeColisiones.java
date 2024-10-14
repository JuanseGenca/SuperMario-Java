package Logica;

import Entidades.*;
import Nivel.*;
import java.util.*;

public class ManejadorDeColisiones {
    protected LinkedList<Entidad> entidades;
    protected Nivel nivelActual;

    public ManejadorDeColisiones() {
        this.entidades = new LinkedList<Entidad>();
    }

    public void eliminarEntidad(Entidad entidad) {
        entidades.remove(entidad);
    }

    public void agregarEntidad(Entidad entidad) {
        entidades.offerFirst(entidad);
    }

    public void setNivel(Nivel nivelActual) {
        this.nivelActual=nivelActual;
    }

    public Nivel getNivel() {
        return nivelActual;
    }

    public void chequearColisiones() { 
        LinkedList<Entidad> entidadesAux= entidades;
        for(Entidad entidadC:entidadesAux) {
            Entidad entidadComprobar=entidadC;
            for(Entidad entidad:entidadesAux) {
              /*   if(entidad.getHitBox().intersects(entidadComprobar.getHitBox())) {
                    //Mensaje a entidad y entidadComprobar de colision
                } */
            }       
        }
    }
}
