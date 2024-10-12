package GUI;

import Entidades.EntidadLogica;
import Paneles.PanelCamara;

public class ObserverJugador extends ObserverGrafico{

	private static final long serialVersionUID = 7017967195998406908L;
	private PanelCamara panelCamara;
    
	
	
	public ObserverJugador(PanelCamara PanelCamara, EntidadLogica entidadObservada) {
		super(entidadObservada);
		this.panelCamara = PanelCamara;
		actualizar();
	}
	
	public void actualizar() {
		super.actualizar();
		panelCamara.actualizarFondo(entidadObservada.getPosicionX());
	}
}