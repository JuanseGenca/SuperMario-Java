package Puntaje;
import java.util.Comparator;

public class ComparadorJugadores implements Comparator<PuntajeJugador> {
    @Override
    public int compare(PuntajeJugador jugador1, PuntajeJugador jugador2) {
        return Integer.compare(jugador1.getScore(), jugador2.getScore());
    }
}
