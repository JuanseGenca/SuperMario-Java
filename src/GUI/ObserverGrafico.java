package GUI;

import Entidades.EntidadLogica;


public abstract class ObserverGrafico  implements Observer{
    
    protected GUI miGui;
    protected EntidadLogica entidadObservada;

    protected ObserverGrafico(EntidadLogica entidadObservada,GUI miGui)  {
		super();
		this.entidadObservada = entidadObservada;
        this.miGui = miGui;
	}

    public void actualizar(){
    
    }
}