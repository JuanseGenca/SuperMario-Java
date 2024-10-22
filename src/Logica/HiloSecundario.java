package Logica;

import Enemigos.Enemigo;
import Entidades.BolaDeFuego;
import GUI.GUI;
import Nivel.Nivel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class HiloSecundario extends Thread {
    private boolean ejecutando;
    private Logica miLogica;
    private GUI miGui;
    private ConcurrentLinkedQueue<Enemigo> enemigosAEliminar;

    public HiloSecundario(Logica logica, GUI gui) {
        miLogica = logica;
        miGui = gui;
        ejecutando = true;
        enemigosAEliminar = new ConcurrentLinkedQueue<>();
    }

    public void parar() {
        ejecutando = false;
    }

    public void run() {
        while (ejecutando) {
            tick();
            //dibujar();
            try {
                sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void tick() {
        for (Enemigo e : miLogica.getEnemigos()) {
            e.mover();
        }
        List<BolaDeFuego> bolasACopiar = new ArrayList<>(miLogica.getBolas());
        for (BolaDeFuego bola : bolasACopiar) {
            bola.mover();
        }
        eliminarEntidadesPendientes();
    }

    private void eliminarEntidadesPendientes() {
        Nivel nivel= miLogica.getNivel();
        while (!enemigosAEliminar.isEmpty()) {
            Enemigo enemigo = enemigosAEliminar.poll();
            nivel.eliminarEnemigo(enemigo);
        }
    }

    public void marcarParaEliminar(Enemigo enemigo) {
        enemigosAEliminar.add(enemigo);
    }

    private void dibujar() {
        miGui.refrescar();
    }
}
