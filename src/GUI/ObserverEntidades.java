package GUI;

import Entidades.EntidadLogica;
import Entidades.ManejadorEntidades;

public class ObserverEntidades extends ObserverGrafico {
	
	private static final long serialVersionUID = -331627302579244451L;
	
	public ObserverEntidades(EntidadLogica entidadObservada) {
		super(entidadObservada, entidadObservada.getZIndex());
		actualizar();
	}

	public void eliminar(){
		ManejadorEntidades.getInstancia().eliminarObserver(this);
	}
}