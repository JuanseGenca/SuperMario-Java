package GUI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
