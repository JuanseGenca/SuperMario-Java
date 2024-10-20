package Logica;

import Entidades.*;
import Nivel.*;
import Visitors.VisitorMario;

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
        for(int i=0;i<entidades.size();i++){
            Entidad entidadComprobar = entidades.get(i);
            for(int j=i+1;j<entidades.size();j++){
                Entidad entidadActual = entidades.get(j);
                if(hayColision(entidadComprobar,entidadActual)){
                    manejarColision(entidadComprobar,entidadActual);
                }
            }
        }
    }
      
    private boolean hayColision(Entidad entidad1, Entidad entidad2){
        return (entidad1.getHitbox().getHitboxLateral().intersects(entidad2.getHitbox().getHitboxLateral()) || entidad1.getHitbox().getHitboxInferior().intersects(entidad2.getHitbox().getHitboxInferior()) || entidad1.getHitbox().getHitboxLateral().intersects(entidad2.getHitbox().getHitboxInferior()) || entidad1.getHitbox().getHitboxSuperior().intersects(entidad2.getHitbox().getHitboxInferior()) || entidad1.getHitbox().getHitboxInferior().intersects(entidad2.getHitbox().getHitboxLateral()) || entidad1.getHitbox().getHitboxInferior().intersects(entidad2.getHitbox().getHitboxSuperior()));
    }

    private void manejarColision(Entidad entidad1, Entidad entidad2){
        int direccionEntidad1 = 0;
        int direccionEntidad2 = 0;
        if(entidad1.getHitbox().getHitboxLateral().intersects(entidad2.getHitbox().getHitboxLateral())){
            direccionEntidad1=ConstantesColisiones.LATERAL;
            direccionEntidad2=ConstantesColisiones.LATERAL;
        }
        else if(entidad1.getHitbox().getHitboxInferior().intersects(entidad2.getHitbox().getHitboxSuperior())){
            direccionEntidad1=ConstantesColisiones.ABAJO;
            direccionEntidad2=ConstantesColisiones.ARRIBA;
        }
        else if(entidad2.getHitbox().getHitboxInferior().intersects(entidad1.getHitbox().getHitboxSuperior())){
            direccionEntidad2=ConstantesColisiones.ABAJO;
            direccionEntidad1=ConstantesColisiones.ARRIBA;
        }
        entidad1.aceptar(entidad2.getVisitor(),direccionEntidad1);
        entidad2.aceptar(entidad1.getVisitor(),direccionEntidad2);
    } 
    
}
