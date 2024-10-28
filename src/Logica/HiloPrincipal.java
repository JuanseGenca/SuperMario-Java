package Logica;

import Entidades.Entidad;
import java.util.concurrent.ConcurrentLinkedQueue;

public class HiloPrincipal extends Thread {
    private ManejadorDeColisiones manejadorDeColisiones;
    private Logica miLogica;
    boolean ejecutando;
    private ConcurrentLinkedQueue<Entidad> entidadesAEliminar;

    public HiloPrincipal(Logica mLogica) {
        miLogica = mLogica;
        ejecutando = true;
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
