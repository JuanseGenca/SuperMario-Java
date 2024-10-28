package Logica;

import Entidades.*;

public class HiloMario extends Thread {
    private Mario jugador;
    private ManejadorDeColisiones manejadorDeColisiones;
    private Logica miLogica;
    boolean ejecutando;

    public HiloMario(Mario jugador, Logica mLogica) {
        this.jugador = jugador;
        miLogica = mLogica;
        ejecutando = true;
    }

    public void run() {
        while(ejecutando){
            tick();
                try {
                    sleep(7);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    public void parar(){
        ejecutando = false;
    }
    private void tick(){
        jugador.mover();

    }
}

   

