package Logica;

import Entidades.*;
import Nivel.*;

import java.awt.Rectangle;
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
        return (entidad1.getHitbox().intersects(entidad2.getHitbox()));
    }

    private void manejarColision(Entidad entidad1, Entidad entidad2){
        Rectangle entidad1Hitbox = entidad1.getHitbox();
        Rectangle entidad2Hitbox = entidad2.getHitbox();

        int direccionEntidad1 = 0;
        int direccionEntidad2 = 0;

        int deltaIzquierda = entidad2Hitbox.x + entidad2Hitbox.width - entidad1Hitbox.x;
        int deltaDerecha = entidad1Hitbox.x + entidad1Hitbox.width - entidad2Hitbox.x;
        int deltaArriba = entidad2Hitbox.y + entidad2Hitbox.height - entidad1Hitbox.y;
        int deltaAbajo = entidad1Hitbox.y + entidad1Hitbox.height - entidad2Hitbox.y; 

        int minDelta = Math.min(Math.min(deltaIzquierda, deltaDerecha), Math.min(deltaArriba, deltaAbajo));

        if (minDelta == deltaIzquierda || minDelta == deltaDerecha) {
            direccionEntidad1 = ConstantesColisiones.LATERAL;
            direccionEntidad2 = ConstantesColisiones.LATERAL;
        } else if (minDelta == deltaArriba) {
            direccionEntidad1 = ConstantesColisiones.ARRIBA;
            direccionEntidad2 = ConstantesColisiones.ABAJO;
        } else if (minDelta == deltaAbajo) {
            direccionEntidad1 = ConstantesColisiones.ABAJO;
            direccionEntidad2 = ConstantesColisiones.ARRIBA;
        } 

        entidad1.aceptar(entidad2.getVisitor(),direccionEntidad1);
        entidad2.aceptar(entidad1.getVisitor(),direccionEntidad2);
    }
} 
    
