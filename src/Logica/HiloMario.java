package Logica;

import Entidades.*;

public class HiloMario extends Thread {
    private final Mario jugador;
    boolean ejecutando;

    public HiloMario(Mario jugador, Logica mLogica) {
        this.jugador = jugador;
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

   

