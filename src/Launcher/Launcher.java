package Launcher;

import java.awt.EventQueue;

import Logica.Logica;
import GUI.*;


public class Launcher {
	
	public static void main(String [] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logica juego = new Logica();
					GUI controladorVistas = new GUI(juego);
					juego.setControladorVistas(controladorVistas);
					controladorVistas.mostrarPantallaInicial();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
