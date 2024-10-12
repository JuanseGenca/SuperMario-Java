package Logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import Entidades.Entidad;


public class HiloEntidades {
    private Timer timer;
    private List<Entidad> oyentes;

    public HiloEntidades(int delay) {
        this.timer = new Timer();
        this.oyentes = new ArrayList<Entidad>();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (Entidad oyente : oyentes) {
                    oyente.actualizar(); // Notificar a todos los oyentes
                }
            }
        }, 0, delay); // Iniciar inmediatamente y repetir cada 'delay' milisegundos
    }

    public void iniciar() {
        // Si el timer ya está corriendo, no hacer nada
    }

    public void parar() {
        timer.cancel();
    }

    public void addActionListener(Entidad oyente) {
        oyentes.add(oyente);
    }

    public void removeActionListener(Entidad oyente) {
        oyentes.remove(oyente);
    }
}
