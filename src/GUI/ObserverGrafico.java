package GUI;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Entidades.EntidadLogica;
import Entidades.constantesEntidades;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;


public abstract class ObserverGrafico extends JLabel implements Observer{
    
	private static final long serialVersionUID = 1L;
    protected EntidadLogica entidadObservada;

    protected ObserverGrafico(EntidadLogica entidadObservada)  {
		super();
		this.entidadObservada = entidadObservada;
	}

	public void actualizar() {
		actualizarImagen();
		actualizarPosicionTamano();
	}

	public void actualizar(int direccion, int estadoAereo) {
		actualizarImagen(direccion, estadoAereo);
		actualizarPosicionTamano();
	}

    protected void actualizarImagen() {
		String ruta_imagen = entidadObservada.getSprite().getRutaImagen();
		ImageIcon icono = new ImageIcon(getClass().getClassLoader().getResource(ruta_imagen));
		setIcon(icono);
	}

	protected void actualizarImagen(int direccion, int estadoAereo) {
		String ruta_imagen = entidadObservada.getSprite().getRutaImagen();
		ImageIcon icono = new ImageIcon(getClass().getClassLoader().getResource(ruta_imagen));

		if(direccion != constantesEntidades.IZQUIERDA) {
			icono = rotarImagen(icono);
		}

		setIcon(icono);
	}

    protected void actualizarPosicionTamano() {
		int x = AdaptadorPosicionPixel.transformarX(entidadObservada.getPosicionX());
		int y = AdaptadorPosicionPixel.transformarY(entidadObservada.getPosicionY());
		int ancho = this.getIcon().getIconWidth();
		int alto = this.getIcon().getIconHeight();
		setBounds(x, y, ancho, alto);
	}
    
    public static ImageIcon rotarImagen(ImageIcon original) {
        Image imagenOriginal = original.getImage();
        BufferedImage imgBuffered = new BufferedImage(
            imagenOriginal.getWidth(null),
            imagenOriginal.getHeight(null),
            BufferedImage.TYPE_INT_ARGB
        );
        
        Graphics2D g2d = imgBuffered.createGraphics();
        g2d.drawImage(imagenOriginal, 0, 0, null);
        g2d.dispose();
        
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-imgBuffered.getWidth(), 0);
        
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        BufferedImage imagenRotada = op.filter(imgBuffered, null);
        
        return new ImageIcon(imagenRotada);
	}
}