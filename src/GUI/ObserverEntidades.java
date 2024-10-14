package GUI;

import Entidades.EntidadLogica;

public class ObserverEntidades extends ObserverGrafico {
	
	
	public ObserverEntidades(EntidadLogica entidadObservada) {
		super(entidadObservada);
		actualizar();
	}

}