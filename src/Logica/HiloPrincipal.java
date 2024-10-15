package Logica;

import Entidades.*;
import java.util.Timer;
import java.util.TimerTask;

public class HiloPrincipal {
    private Timer timer;
    private Mario jugador;
    private ManejadorDeColisiones manejadorDeColisiones;

    public HiloPrincipal(int delay, Mario jugador, ManejadorDeColisiones manejadorDeColisiones) {
        this.timer = new Timer();
        this.manejadorDeColisiones=manejadorDeColisiones;
        this.jugador = jugador;

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
               //manejadorDeColisiones.chequearColisiones();
               jugador.actualizar();
            }
        }, 0, delay); // Iniciar inmediatamente y repetir cada 'delay' milisegundos
    }

    public void iniciar() {
        // Si el timer ya está corriendo, no hacer nada
    }

    public void parar() {
        timer.cancel();
    }

}
