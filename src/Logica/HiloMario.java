package Logica;

import Entidades.*;

public class HiloMario extends Thread {
    private final Mario jugador;
    boolean ejecutando;

    public HiloMario(Mario jugador, Logica mLogica) {
        this.jugador = jugador;
        ejecutando = true;
    }

    @SuppressWarnings("override")
    public void run() {
        while(ejecutando){
            tick();
                try {
                    sleep(15);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
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

   

