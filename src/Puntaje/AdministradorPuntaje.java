package Puntaje;

import java.util.PriorityQueue;

public class AdministradorPuntaje {
    protected TopPuntaje topPuntaje;
    protected int scoreActual;

    public AdministradorPuntaje()
    {
        topPuntaje=new TopPuntaje();
        scoreActual=0;
    }

    public int getScore()
    {
        return scoreActual;
    }

    public void agregarScore(int puntos)
    {
        scoreActual = puntos;
    }

    public boolean entroEnElTop5()
    {
        return (scoreActual>0 && (topPuntaje.obtenerListadeJugadores().size()<5 || topPuntaje.obtenerListadeJugadores().peek().getScore()<=scoreActual));
    }

    public PriorityQueue<Jugador> obtenerListadeJugadores()
    {
      return topPuntaje.obtenerListadeJugadores();
    }
    
    public void mejorJugador(String nombre_del_Jugador)
    {
        topPuntaje.agregarJugador(nombre_del_Jugador, scoreActual);
    }

    //ambos devuelven los array en orden DESCENDENTE
    public String[] obtenerArrayNombresJugadores() {
		PriorityQueue<Jugador> jugadores = obtenerListadeJugadores();
		String[] devolver = new String[5];

		for(int i = 4 ; i >= 0 ; i--) {
			devolver[i] = jugadores.poll().getNombre().toUpperCase();
		}

		return devolver;
	}

	public int[] obtenerArrayScoreJugadores() {
		PriorityQueue<Jugador> jugadores = obtenerListadeJugadores();
		int[] devolver = new int[5];

		for(int i = 4 ; i >= 0 ; i--) {
			devolver[i] = jugadores.poll().getScore();
		}

		return devolver;
	}
}
