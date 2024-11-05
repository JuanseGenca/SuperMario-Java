package Estados;

import Entidades.Mario;
import Logica.ConstantesSonidos;
import Visitors.ConstantesPowerUp;
import java.util.Timer;
import java.util.TimerTask;

public class EstadoMarioEstrella implements EstadoMario {
    
    protected Mario m;
    protected static final int paddingTamanio = 48;
    protected EstadoMario estadoPrevio;
    private Timer timer;
    private static final long duracionEstrella = 5000; // Duración en milisegundos (1 segundo=1000 milisegundos)

    public EstadoMarioEstrella(Mario mario) {
        m = mario;
        m.pausarSonido(m.getLogica().getNivel().getNumeroNivel());
        m.reproducirSonido(ConstantesSonidos.ESTRELLA);
        iniciarTemporizador();
    }

    public void setEstadoPrevio(EstadoMario estado) {
        this.estadoPrevio = estado;
    }
    
    public void disparar() {}
    
    public void recibirDanio(int puntaje) {}
    
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
        }, duracionEstrella);
    }

    private void finalizarEstadoEstrella() {
        m.reanudarSonido(m.getLogica().getNivel().getNumeroNivel());
        m.setEstado(estadoPrevio);
        timer.cancel();
    }

    public int getModificador() {
        return ConstantesPowerUp.ESTRELLA;
    }
}
