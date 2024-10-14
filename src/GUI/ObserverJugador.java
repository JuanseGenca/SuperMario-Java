package GUI;

import java.awt.image.BufferedImage;

import Entidades.EntidadLogica;
import Paneles.PanelPantallaCarrera;

public class ObserverJugador extends ObserverGrafico{
	
	private PanelPantallaCarrera panelPantallaCarreras;
	
	
	public ObserverJugador(PanelPantallaCarrera panelPantallaCarreras, EntidadLogica jugadorObservado) {
		super(jugadorObservado);
		this.panelPantallaCarreras = panelPantallaCarreras;
		actualizar();
	}
	
	public void actualizar() {
		super.actualizar();
		panelPantallaCarreras.actualizarScrollHaciaJugador(entidadObservada);
	}
}
}