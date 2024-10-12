package GUI;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Entidades.EntidadLogica;


public abstract class ObserverGrafico extends JLabel implements Observer{
    
    protected EntidadLogica entidadObservada;

    protected ObserverGrafico(EntidadLogica entidadObservada) {
		super();
		this.entidadObservada = entidadObservada;
	}

    public void actualizar(){
        String ruta_imagen = entidadObservada.getSprite().get_ruta_imagen();
		ImageIcon icono = new ImageIcon(getClass().getClassLoader().getResource(ruta_imagen));
		setIcon(icono);
    }
}