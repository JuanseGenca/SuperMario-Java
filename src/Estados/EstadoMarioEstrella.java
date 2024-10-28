package Estados;

import Entidades.Mario;
import java.util.Timer;
import java.util.TimerTask;

public class EstadoMarioEstrella implements EstadoMario {
    
    protected Mario m;
    protected static final int paddingTamanio = 48;
    protected EstadoMario estadoPrevio;
    private Timer timer;
    private static final long DURACION_ESTRELLA = 5000; // Duración en milisegundos (1 segundo=1000 milisegundos)

    public EstadoMarioEstrella(Mario mario) {
        m = mario;
        m.pausarSonido("musicaLvl"+m.getLogica().getNivel().getNumeroNivel());
        m.reproducirSonido("MarioEstrella");
        iniciarTemporizador();
    }

    public void setEstadoPrevio(EstadoMario estado) {
        this.estadoPrevio = estado;
    }
    
    @SuppressWarnings("override")
    public void disparar() {}
    
    @SuppressWarnings("override")
    public void recibirDanio(int puntaje) {}
    
    @Override
    public boolean puedeRomper() {
        return true;
    }

    @SuppressWarnings("override")
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
        m.reanudarSonido("musicaLvl"+m.getLogica().getNivel().getNumeroNivel());
        m.setEstado(estadoPrevio);
        timer.cancel();
    }

    @Override
    public int getModificador() {
        return 9;
    }
}
