package GUI;

import Entidades.EntidadJugador;
import Paneles.PanelPantallaJuego;

public class ObserverJugador extends ObserverGrafico{
	
	private static final long serialVersionUID = 7017967195998406908L;
	private PanelPantallaJuego panelPantallaJuego;
	private EntidadJugador jugadorObservado;
	
	
	public ObserverJugador(PanelPantallaJuego panelPantallaJuego, EntidadJugador jugadorObservado) {
		super(jugadorObservado);
		this.panelPantallaJuego = panelPantallaJuego;
		this.jugadorObservado = jugadorObservado;
		actualizar();
	}
	
	public void actualizar() {
		super.actualizar();
		panelPantallaJuego.actualizarScrollHaciaJugador(entidadObservada);
	}
}
