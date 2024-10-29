package Puntaje;

import java.util.Comparator;

public class ComparadorJugador implements Comparator<Jugador> {
    public int compare(Jugador jugador1, Jugador jugador2) {
        return Integer.compare(jugador1.getScore(), jugador2.getScore());
    }
}