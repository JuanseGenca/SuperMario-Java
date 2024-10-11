package Puntaje;

import GUI.CentralPaneles;
import java.util.PriorityQueue;

public class AdministradorDePuntaje {
    protected TopPuntaje topPuntaje;
    protected int scoreActual;
    protected CentralPaneles centralPaneles;

    public AdministradorDePuntaje(CentralPaneles centralPaneles) {
        this.topPuntaje=new TopPuntaje();
        scoreActual=0;
        this.centralPaneles=centralPaneles;
    }

    public int getScore() {
        return scoreActual;
    }

    public void actualizarScore(int puntos)  {
         scoreActual=scoreActual+puntos;
        //Falta conectar con logica
    }

    public boolean entro_en_el_top5() {
        boolean hayMenosDeCinco=(topPuntaje.obtenerListadeJugadores().size()<5);
        boolean elScoreEstaEntreLosCincoMejores=(topPuntaje.obtenerListadeJugadores().peek().getScore()<=scoreActual);

        return (scoreActual>0 && (hayMenosDeCinco || elScoreEstaEntreLosCincoMejores));
    }

    public PriorityQueue<PuntajeJugador> obtenerListadeJugadores() {
      return topPuntaje.obtenerListadeJugadores();
    }
    
    public void mejorJugador(String nombre_del_Jugador) {
        topPuntaje.agregarJugador(nombre_del_Jugador, scoreActual);
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
