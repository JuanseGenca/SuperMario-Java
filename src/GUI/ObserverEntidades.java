package GUI;

import Entidades.EntidadLogica;

public class ObserverEntidades extends ObserverGrafico {
	
	private static final long serialVersionUID = -331627302579244451L;
	
	public ObserverEntidades(EntidadLogica entidadObservada) {
		super(entidadObservada, entidadObservada.getZIndex());
		actualizar();
	}

}