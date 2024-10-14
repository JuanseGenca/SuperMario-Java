package Paneles;

import Entidades.*;
import GUI.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

public class PanelPantallaJuego extends JPanel {

	private static final long serialVersionUID = -1366756178696496543L;
	private JPanel panelJuego;
	private JPanel panelInformacion;
	private JLabel imagenFondoPanelJuego;
	private JLabel imagenFondoPanelInformacion;
	private JScrollPane panelPantallaJuego;
	private JLabel labelPuntaje;
	private int posicionXAnterior = 0;
	private int posicionYAnterior = 0;

	public PanelPantallaJuego() {
		setPreferredSize(new Dimension(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO));
		setLayout(new BorderLayout());
		agregarPanelInformacion();
		agregarPanelJuegoConFondoYScroll();
		panelPantallaJuego.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panelPantallaJuego.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		JViewport viewport = panelPantallaJuego.getViewport();
    	Dimension viewSize = panelJuego.getPreferredSize();
    	Dimension extentSize = viewport.getExtentSize();
    	viewport.setViewPosition(new Point(0, viewSize.height - extentSize.height));//no se si van aca estos dos :)
	}
	
	// Operaciones para ControladorVistas
	
	public Observer incorporarEntidad(EntidadLogica entidadLogica) {
		ObserverEntidades observerEntidad = new ObserverEntidades(entidadLogica);
		imagenFondoPanelJuego.add(observerEntidad);
		return observerEntidad;
	}
	
	public Observer incorporarEntidadJugador(EntidadJugador entidadJugador) {
		ObserverJugador observerJugador = new ObserverJugador(this, entidadJugador);
		imagenFondoPanelJuego.add(observerJugador);
		actualizarInfoJugador(entidadJugador);
		return observerJugador;
	}

	public Observer incorporarSilueta(EntidadLogica entidadLogica) {
		ObserverEntidades observerEntidad = new ObserverEntidades(entidadLogica);
		imagenFondoPanelJuego.setIcon(new ImageIcon(getClass().getClassLoader().getResource(entidadLogica.getSprite().getRutaImagen())));
		imagenFondoPanelJuego.setBounds(0,0, imagenFondoPanelJuego.getIcon().getIconWidth(), imagenFondoPanelJuego.getIcon().getIconHeight());
		panelJuego.setPreferredSize(new Dimension(imagenFondoPanelJuego.getIcon().getIconWidth(), imagenFondoPanelJuego.getIcon().getIconHeight()));
		return observerEntidad;
	}
		
	protected void actualizarInfoJugador(EntidadJugador jugador) {
		actualizarLabelsInformacion(jugador);
		actualizarScrollHaciaJugador(jugador);
	}
	
	protected void actualizarLabelsInformacion(EntidadJugador jugador) {
		labelPuntaje.setText( textoConCantidadDigitos(jugador.getPuntaje(), 5) );
	}
	
	protected String textoConCantidadDigitos(int numero, int digitos) {
		String textoAutocompletado = "";
		if (en_rango(numero, 0, 9)) {
			textoAutocompletado = "0000" + numero;
		}else {
			if (en_rango(numero, 10, 99)) {
				textoAutocompletado = "000" + numero;
			}else {
				if (en_rango(numero, 100, 999)) {
					textoAutocompletado = "00" + numero;
				}else {
					if(en_rango(numero, 1000, 9999)) {
						textoAutocompletado = "0" + numero;
					}else {
						textoAutocompletado += numero;
					}
				}
			}
		}
		return textoAutocompletado;
	}
	
	protected boolean en_rango(int numero, int piso, int techo) {
		boolean retorno;
		retorno = numero >= piso;
		retorno = retorno && (numero <= techo);
		return retorno;
	}
	
	// Operacion para observer de jugador
	
	public void actualizarScrollHaciaJugador(EntidadLogica jugador) {
		double interpolationFactor = 0.1; // Adjust this value to control smoothness
	
		int posicionInterpoladaX = (int) (posicionXAnterior + (jugador.getPosicionX() - posicionXAnterior) * interpolationFactor);
		int posicionInterpoladaY = (int) (posicionYAnterior + (jugador.getPosicionY() - posicionYAnterior) * interpolationFactor);
	
		centrarEnJugador(posicionInterpoladaX, posicionInterpoladaY);
	}

	protected void centrarEnJugador(int posicionXJugador, int posicionYJugador) {
	
		// Solo ajustamos el viewport si la posición de Mario ha cambiado significativamente
		if (Math.abs(posicionXJugador - posicionXAnterior) > 10) {
			JViewport viewport = panelPantallaJuego.getViewport();
			
			// Asegurar valores positivos
			int newX = Math.max(0, posicionXJugador - viewport.getWidth() / 2);
			int newY = 800; // Coloca en la parte inferior
			
			// Verificar límites para X
			Dimension viewSize = panelJuego.getPreferredSize();
			Dimension extentSize = viewport.getExtentSize();
			newX = Math.min(newX, viewSize.width - extentSize.width);
			
			// Actualiza la posición del viewport
			viewport.setViewPosition(new Point(newX, newY));
			posicionXAnterior = posicionXJugador;
		}
	}
	
	// Operaciones propias para construccion de PanelPantallaJuego
	
	protected void agregarPanelJuegoConFondoYScroll() {
		imagenFondoPanelJuego = new JLabel();
		imagenFondoPanelJuego.setLayout(null);
		imagenFondoPanelJuego.setBounds(0,0, ConstantesVistas.PANEL_JUEGO_ANCHO, ConstantesVistas.PANEL_ALTO);
		
		panelJuego = new JPanel(null);
		panelJuego.setPreferredSize(new Dimension(ConstantesVistas.PANEL_JUEGO_ANCHO, ConstantesVistas.PANEL_ALTO));
		panelJuego.add(imagenFondoPanelJuego);
		
		panelPantallaJuego = new JScrollPane(panelJuego);
		panelPantallaJuego.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panelPantallaJuego.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		panelPantallaJuego.setBounds(0, 0, ConstantesVistas.PANEL_JUEGO_ANCHO, ConstantesVistas.PANEL_ALTO);
			
		add(panelPantallaJuego, BorderLayout.CENTER);
	}
	
	
	protected void agregarPanelInformacion() {
		panelInformacion = new JPanel();
		panelInformacion.setLayout(null);
		panelInformacion.setPreferredSize(new Dimension(ConstantesVistas.PANEL_INFORMACION_ANCHO, ConstantesVistas.PANEL_ALTO));
		agregarImagenFondoPanelInformacion();
		agregarLabelsEditablesInformacion();
		add(panelInformacion, BorderLayout.EAST);
	}
	
	protected void agregarImagenFondoPanelInformacion() {
		imagenFondoPanelInformacion = new JLabel();
		ImageIcon iconoImagen = new ImageIcon(this.getClass().getResource("/Imagenes/pantalla-informacion.png"));
		Image imagenEscalada = iconoImagen.getImage().getScaledInstance(ConstantesVistas.PANEL_INFORMACION_ANCHO, ConstantesVistas.PANEL_ALTO, Image.SCALE_SMOOTH);
		Icon iconoImagenEscalado = new ImageIcon(imagenEscalada);
		imagenFondoPanelInformacion.setIcon(iconoImagenEscalado);
		imagenFondoPanelInformacion.setBounds(0,0, ConstantesVistas.PANEL_INFORMACION_ANCHO, ConstantesVistas.PANEL_ALTO);
		panelInformacion.add(imagenFondoPanelInformacion);
	}

	
	protected void agregarLabelsEditablesInformacion() {
		labelPuntaje = new JLabel("00000");
		decorarLabelsInformacion();
		imagenFondoPanelInformacion.add(labelPuntaje);
	}	
	
	protected void decorarLabelsInformacion() {
		labelPuntaje.setBounds(49, 120, 150, 50);
		
		labelPuntaje.setForeground(Color.WHITE);
		
		labelPuntaje.setFont(new Font(labelPuntaje.getFont().getName(), Font.BOLD, 24));
	}
}
