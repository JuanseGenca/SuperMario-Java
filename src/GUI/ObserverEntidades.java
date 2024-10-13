package GUI;

import java.awt.image.BufferedImage;

import Entidades.EntidadLogica;

public class ObserverEntidades extends ObserverGrafico {
	
	private static final long serialVersionUID = -331627302579244451L;
	
	public ObserverEntidades(EntidadLogica entidadObservada) {
		super(entidadObservada);
		actualizar();
	}

	public void actualizar(){
		//le pide la imagen a la entidad
		BufferedImage sprite = entidadObservada.getSprite();
		//se lo pasa a la gui con la pos
		miGui.agregarSprite(sprite, entidadObservada.getPosicionX(), entidadObservada.getPosicionX());
	}

}