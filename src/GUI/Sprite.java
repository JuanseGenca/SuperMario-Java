package GUI;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Sprite {
	
	protected String rutaImagen;
	private Icon icono;
	
	public Sprite (String rutaImagen) {
		this.rutaImagen = rutaImagen;
		icono = new ImageIcon(getClass().getClassLoader().getResource(rutaImagen));
	}
	
	public String getRutaImagen() {
		return rutaImagen;
	}

	public int getWidth() {
		return icono.getIconWidth();
	}

	public int getHeight() {
		return icono.getIconHeight();
	}

}
