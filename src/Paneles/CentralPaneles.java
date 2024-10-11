package Paneles;

import javax.swing.JPanel;
import GUI.GUI;
import Logica.Logica;

public class CentralPaneles {
    protected JPanel panelPrincipal;
    protected GUI miGUI;
	protected PanelVidas miPanelVidas;
    protected PanelScore miPanelScore;
    protected PanelCamara miPanelCamara;
	protected PanelTiempo miPanelTiempo;
	protected Logica miLogica;

    public CentralPaneles(GUI mi_GUI, Logica mi_logica) {
        miGUI = mi_GUI;
		miLogica = mi_logica;
    }


    public void mostrarPanelScore() {
        miPanelScore = new PanelScore(this);
		miPanelScore.crearPanel();
        miPanelScore.agregarAJFrame();
    }

	public void actualizarScore(int score) {
		miPanelScore.actualizarScore(score);
	}

	public int getScore() {
		return miLogica.getPuntaje();
	}

	public void mostrarPanelCamara() {
        PanelCamara miPanelCamara = new PanelCamara(this); //TODO: implementar PanelCamara
		miPanelCamara.crearPanel();
        miPanelCamara.agregarAJFrame();
    }



	public void mostrarPanelTimer() {
        miPanelTiempo = new PanelTiempo(this);
		miPanelTiempo.crearPanel();
        miPanelTiempo.agregarAJFrame();
    }

	public void actualizarTimer(int tiempo) {
		miPanelTiempo.actualizarTimer(tiempo);
	}

	public int getTiempoRestante() {
		return miLogica.getTiempoRestante();
	}

	public void mostrarPanelVidas() {
        miPanelVidas = new PanelVidas(this);
		miPanelVidas.crearPanel();
        miPanelVidas.agregarAJFrame();
    }

	public int getVidas() {
		return miLogica.getCantidadDeVidas();
	}

	public void actualizarVidas() {
		miPanelVidas.actualizarVidas();
	}

}