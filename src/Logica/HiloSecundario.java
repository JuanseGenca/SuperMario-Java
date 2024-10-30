package Logica;

import Enemigos.Enemigo;
import Entidades.BolaDeFuego;
import Nivel.Nivel;
import PowerUps.PowerUp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class HiloSecundario extends Thread {
    private boolean ejecutando = true;
    private Logica miLogica;
    private ConcurrentLinkedQueue<Enemigo> enemigosAEliminar;

    public HiloSecundario(Logica miLogica) {
        this.miLogica = miLogica;
        enemigosAEliminar = new ConcurrentLinkedQueue<>();
    }

    public void parar() {
        ejecutando = false;
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

    private void tick() {
        List<Enemigo> enemigosACopiar;
        
        synchronized (miLogica.getEnemigos()) {
            enemigosACopiar = new ArrayList<>(miLogica.getEnemigos());
        }
        
        for (Enemigo e : enemigosACopiar) {
            e.mover();
        }

        List<PowerUp> powerUpsACopiar;
        
        synchronized (miLogica.getPowerUps()) {
            powerUpsACopiar = new ArrayList<>(miLogica.getPowerUps());
        }
        
        for (PowerUp p : powerUpsACopiar) {
            p.mover();
        }
        
        List<BolaDeFuego> bolasACopiar = new ArrayList<>(miLogica.getBolas());
        for (BolaDeFuego bola : bolasACopiar) {
            bola.mover();
        }

        // Es necesario? esta el mismo metodo en el otro hilo
       eliminarEntidadesPendientes();
    }

    private void eliminarEntidadesPendientes() {
        Nivel nivel = miLogica.getNivel();
        while (!enemigosAEliminar.isEmpty()) {
            Enemigo enemigo = enemigosAEliminar.poll();
            nivel.eliminarEnemigo(enemigo);
        }
    }

    public void marcarParaEliminar(Enemigo enemigo) {
        enemigosAEliminar.add(enemigo);
    }
}
