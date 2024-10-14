package GUI;

import Entidades.EntidadJugador;
import Entidades.EntidadLogica;
import Paneles.PanelPantallaCarrera;

public class ObserverJugador extends ObserverGrafico{
	
	private static final long serialVersionUID = 7017967195998406908L;
	private PanelPantallaCarrera panelPantallaCarreras;
	private EntidadJugador jugadorObservado;
	
	
	public ObserverJugador(PanelPantallaCarrera panelPantallaCarreras, EntidadJugador jugadorObservado) {
		super(jugadorObservado);
		this.panelPantallaCarreras = panelPantallaCarreras;
		this.jugadorObservado = jugadorObservado;
		actualizar();
	}
	
	public void actualizar() {
		super.actualizar();
		panelPantallaCarreras.actualizarScrollHaciaJugador(entidadObservada);
	}
}
