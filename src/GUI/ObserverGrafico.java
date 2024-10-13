package GUI;

import Entidades.EntidadLogica;


public abstract class ObserverGrafico  implements Observer{
    
    protected EntidadLogica entidadObservada;

    protected ObserverGrafico(EntidadLogica entidadObservada) {
		super();
		this.entidadObservada = entidadObservada;
	}

    public void actualizar(){
        
    }
}