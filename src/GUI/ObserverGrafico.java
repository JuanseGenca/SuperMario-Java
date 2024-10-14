package GUI;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidades.EntidadLogica;


public abstract class ObserverGrafico extends JLabel implements Observer{
    
    protected EntidadLogica entidadObservada;

    protected ObserverGrafico(EntidadLogica entidadObservada)  {
		super();
		this.entidadObservada = entidadObservada;
	}

	public void actualizar() {
		actualizarImagen();
		actualizarPosicionTamano();
	}

    public void actualizarImagen(){
        String rutaImagen = entidadObservada.getSprite().getRutaImagen();
		File file = new File(rutaImagen);
		ImageIcon icono = new ImageIcon(file.getAbsolutePath());
		setIcon(icono);
    }

    protected void actualizarPosicionTamano() {
		int x = AdaptadorPosicionPixel.transformarX(entidadObservada.getPosicionX());
		int y = AdaptadorPosicionPixel.transformarY(entidadObservada.getPosicionY());
		int ancho = this.getIcon().getIconWidth();
		int alto = this.getIcon().getIconHeight();
		setBounds(x, y, ancho, alto);
	}
}