package Logica;

import Enemigos.Enemigo;
import GUI.GUI;

public class HiloSecundario extends Thread {
    private ManejadorDeColisiones manejadorDeColisiones;
    private GUI miGui;
    private Logica miLogica;
    boolean ejecutando;

    public HiloSecundario(GUI gui,Logica mLogica) {
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
       for(Enemigo e: miLogica.getEnemigos()){
        e.mover();
       }

        
    }

    private void dibujar(){
        miGui.refrescar();
    }
    }

   

