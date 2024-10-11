package Puntaje;

import java.util.PriorityQueue;

import GUI.CentralPaneles;

public class AdministradorDePuntaje {
    protected TopPuntaje topPuntaje;
    protected int scoreActual;
    protected CentralPaneles centralPaneles;

    public AdministradorDePuntaje(CentralPaneles centralPaneles)
    {
        this.topPuntaje=new TopPuntaje();
        scoreActual=0;
        this.centralPaneles=centralPaneles;
    }

    public int getScore()
    {
        return scoreActual;
    }

    public void actualizarScore(int puntos)
    {
        scoreActual=scoreActual+puntos;
        centralPaneles.actualizarScore(scoreActual);
    }

    public boolean entro_en_el_top5()
    {
        return (scoreActual>0 && (TopPuntaje.obtenerListadeJugadores().size()<5 || TopPuntaje.obtenerListadeJugadores().peek().getScore()<=scoreActual));
    }

    public PriorityQueue<PuntajeJugador> obtenerListadeJugadores()
    {
      return TopPuntaje.obtenerListadeJugadores();
    }
    
    public void mejorJugador(String nombre_del_Jugador)
    {
        TopPuntaje.agregarJugador(nombre_del_Jugador, scoreActual);
    }

    //ambos devuelven los array en orden DESCENDENTE
    public String[] obtenerArrayNombresJugadores() {
		PriorityQueue<PuntajeJugador> jugadores = obtenerListadeJugadores();
		String[] devolver = new String[5];

		for(int i = 4 ; i >= 0 ; i--) {
			devolver[i] = jugadores.poll().getNombre().toUpperCase();
		}

		return devolver;
	}

	public int[] obtenerArrayScoreJugadores() {
		PriorityQueue<PuntajeJugador> jugadores = obtenerListadeJugadores();
		int[] devolver = new int[5];

		for(int i = 4 ; i >= 0 ; i--) {
			devolver[i] = jugadores.poll().getScore();
		}

		return devolver;
	}
}
