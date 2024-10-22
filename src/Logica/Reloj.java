package Logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Reloj {
    private Timer timer;
    private List<ActionListener> oyentes;

    public Reloj(int delay) {
        this.timer = new Timer();
        this.oyentes = new ArrayList<>();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (ActionListener oyente : oyentes) {
                    oyente.actionPerformed(null);
                }
            }
        }, 0, delay);
    }

    public void iniciar() {
        // Si el timer ya está corriendo, no hacer nada
    }

    public void parar() {
        timer.cancel();
    }

    public void addActionListener(ActionListener oyente) {
        oyentes.add(oyente);
    }

    public void removeActionListener(ActionListener oyente) {
        oyentes.remove(oyente);
    }

    public interface ActionListener {
        void actionPerformed(java.awt.event.ActionEvent e);
    }
}
