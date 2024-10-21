package Estados;

import Entidades.Mario;
import java.util.Timer;
import java.util.TimerTask;

public class EstadoMarioEstrella implements EstadoMario {
    
    protected Mario m;
    protected static final int paddingTamanio = 48;
    protected EstadoMario estadoPrevio;
    private Timer timer;
    private static final long DURACION_ESTRELLA = 5000; // Duración en milisegundos (5 segundos)

    public EstadoMarioEstrella(Mario mario) {
        m = mario;
        iniciarTemporizador();
    }

    public void setEstadoPrevio(EstadoMario estado) {
        this.estadoPrevio = estado;
    }
    
    public void disparar() {}
    
    public void recibirDanio() {}
    
    public boolean puedeRomper() {
        return true;
    }

    public int getPaddingTamanio() {
        return paddingTamanio;
    }

    private void iniciarTemporizador() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                finalizarEstadoEstrella();
            }
        }, DURACION_ESTRELLA);
    }

    private void finalizarEstadoEstrella() {
        m.setEstado(estadoPrevio);
        timer.cancel();
    }

    @Override
    public int getModificador() {
        return 9;
        //Cambiar por el int adecuado una vez terminado el estado de estrella
    }
}
