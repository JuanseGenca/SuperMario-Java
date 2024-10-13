package GUI;

import java.awt.image.BufferedImage;

import Entidades.EntidadLogica;
import Paneles.PanelCamara;

public class ObserverJugador extends ObserverGrafico{

	private static final long serialVersionUID = 7017967195998406908L;
	private PanelCamara panelCamara;
    
	
	
	public ObserverJugador(PanelCamara PanelCamara, EntidadLogica entidadObservada,GUI miGui) {
		super(entidadObservada,miGui);
		this.panelCamara = PanelCamara;
		actualizar();
	}
	
	public void actualizar() {
		int direccion = entidadObservada.getDireccion();
		BufferedImage sprite;
        if(direccion == 15000){
			//Tiene que poder acceder a el sprite donde salta
            sprite = entidadObservada.getSprite()
        }
        if(direccion == 15001){
            //Tiene que poder acceder a el sprite donde salta
            sprite = entidadObservada.getSprite()
        }
        if(direccion == 15002){
            //Tiene que poder acceder a el sprite donde mira a la izq
            sprite = entidadObservada.getSprite()
        }
        if(direccion == 15003){
           //Tiene que poder acceder a el sprite donde mira a la derecha
		   sprite = entidadObservada.getSprite()
        }
		//le pasa el sprite correspondiente a la gui con la posicion de mario
		miGui.agregarSprite(sprite,entidadObservada.getPosicionX(),entidadObservada.getPosicionY());
		//actualiza la imagen de fondo
		panelCamara.actualizarFondo(entidadObservada.getPosicionX());
	}
}