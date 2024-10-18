package Logica;

import Entidades.*;
import GUI.GUI;

public class HiloMario extends Thread {
    private Mario jugador;
    private ManejadorDeColisiones manejadorDeColisiones;
    private GUI miGui;
    private Logica miLogica;
    boolean ejecutando;

    public HiloMario(Mario jugador,GUI gui,Logica mLogica) {
        this.jugador = jugador;
        miGui = gui;
        miLogica = mLogica;
        ejecutando = true;
    }

    public void run() {
        while(ejecutando){
                tick();
                dibujar();
                try {
                    sleep(15);
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

    private void dibujar(){
        miGui.refrescar();
    }
    }

   

