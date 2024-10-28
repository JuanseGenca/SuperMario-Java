package GUI;

import Entidades.EntidadJugador;
import Paneles.PanelPantallaJuego;

public class ObserverJugador extends ObserverGrafico{
	
	private static final long serialVersionUID = 7017967195998406908L;
	private PanelPantallaJuego panelPantallaJuego;
	private EntidadJugador jugadorObservado;
	
	
	public ObserverJugador(PanelPantallaJuego panelPantallaJuego, EntidadJugador jugadorObservado) {
		super(jugadorObservado, 0);
		this.panelPantallaJuego = panelPantallaJuego;
		this.jugadorObservado = jugadorObservado;
		actualizar();
	}
	
	public void actualizar() {
		super.actualizar();
		panelPantallaJuego.actualizarScrollHaciaJugador(entidadObservada);
	}

	public void actualizar(int direccion, int estadoAereo) {
		super.actualizar(direccion, estadoAereo);
		panelPantallaJuego.actualizarInfoJugador(jugadorObservado);
	}

	public void eliminar(){
		
	}
}
