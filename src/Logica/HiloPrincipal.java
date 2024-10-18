package Logica;

import Enemigos.Enemigo;
import GUI.GUI;

public class HiloPrincipal extends Thread {
    private ManejadorDeColisiones manejadorDeColisiones;
    private GUI miGui;
    private Logica miLogica;
    boolean ejecutando;

    public HiloPrincipal(GUI gui,Logica mLogica) {
        miGui = gui;
        miLogica = mLogica;
        ejecutando = true;
        manejadorDeColisiones=miLogica.getManejadorDeColisiones();
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
        manejadorDeColisiones.chequearColisiones();  
    }

    private void dibujar(){
        miGui.refrescar();
    }
    }

   

