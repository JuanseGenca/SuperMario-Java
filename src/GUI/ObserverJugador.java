package GUI;

import Entidades.EntidadLogica;
import Paneles.PanelCamara;

public class ObserverJugador extends ObserverGrafico{

	private static final long serialVersionUID = 7017967195998406908L;
	private PanelCamara PanelCamara;
	
	
	public ObserverJugador(PanelCamara PanelCamara, EntidadLogica entidadObservada) {
		super(entidadObservada);
		this.PanelCamara = PanelCamara;
		actualizar();
	}
	
	public void actualizar() {
		super.actualizar();
		//DEBE MOVER LA CAMARA HACIA EL JUGADOR
	}
}