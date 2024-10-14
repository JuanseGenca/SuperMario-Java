package GUI;

import Entidades.EntidadJugador;
import Entidades.EntidadLogica;
import Paneles.PanelPantallaCarrera;

public class ObserverJugador extends ObserverGrafico{
	
	private PanelPantallaCarrera panelPantallaCarreras;
	
	
	public ObserverJugador(PanelPantallaCarrera panelPantallaCarreras, EntidadJugador jugadorObservado) {
		super(jugadorObservado);
		this.panelPantallaCarreras = panelPantallaCarreras;
		actualizar();
	}
	
	public void actualizar() {
		super.actualizar();
		//panelPantallaCarreras.actualizarScrollHaciaJugador(entidadObservada);
	}
}
