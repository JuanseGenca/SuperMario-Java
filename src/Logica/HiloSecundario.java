package Logica;

import Enemigos.Enemigo;
import Entidades.BolaDeFuego;
import PowerUps.PowerUp;

import java.util.ArrayList;
import java.util.List;

public class HiloSecundario extends Thread {
    private boolean ejecutando = true;
    private Logica miLogica;

    public HiloSecundario(Logica miLogica) {
        this.miLogica = miLogica;
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
    }
}
