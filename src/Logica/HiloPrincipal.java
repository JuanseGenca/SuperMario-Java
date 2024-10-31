package Logica;

import Entidades.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class HiloPrincipal extends Thread {
    private ManejadorDeColisiones manejadorDeColisiones;
    private Logica miLogica;
    private boolean ejecutando;
    private ConcurrentLinkedQueue<Entidad> entidadesAEliminar;
    private Mario mario;

    public HiloPrincipal(Logica mLogica,Mario mario) {
        miLogica = mLogica;
        ejecutando = true;
        this.mario = mario;
        manejadorDeColisiones = miLogica.getManejadorDeColisiones();
        entidadesAEliminar = new ConcurrentLinkedQueue<>();
    }

    public void run() {
        while (ejecutando) {
            tick();
            try {
                sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void parar() {
        ejecutando = false;
    }

    private void tick() {
        mario.mover();
        manejadorDeColisiones.chequearColisiones();
       eliminarEntidadesPendientes();
    }

    private void eliminarEntidadesPendientes() {
        while (!entidadesAEliminar.isEmpty()) {
            Entidad entidad = entidadesAEliminar.poll();
            manejadorDeColisiones.eliminarEntidad(entidad);
        }
    }

    public void marcarParaEliminar(Entidad entidad) {
        entidadesAEliminar.add(entidad);
    }
}
