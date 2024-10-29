package Launcher;

import GUI.*;
import Logica.Logica;
import java.awt.EventQueue;


public class Launcher {
	
	public static void main(String [] args) {
		EventQueue.invokeLater(new Runnable() {
            @Override
			public void run() {
				try {
					Logica juego = new Logica();
					GUI controladorVistas = new GUI(juego);
					juego.setControladorVistas(controladorVistas);
					controladorVistas.mostrarPantallaInicial();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});
	}
}
