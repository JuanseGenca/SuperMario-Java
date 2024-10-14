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

public class PanelPantallaCarrera extends JPanel {

	private static final long serialVersionUID = -1366756178696496543L;
	private JPanel panelCarreras;
	private JPanel panelInformacion;
	private JLabel imagenFondoPanelCarreras;
	private JLabel imagenFondoPanelInformacion;
	private JScrollPane panelScrollCarrera;
	private JLabel labelPuntaje;
	private int posicionXAnterior = 0;
	private double zoom = 1.0; // Valor inicial de zoom
    private double zoomMin = 0.5; // Zoom mínimo permitido
    private double zoomMax = 2.0; // Zoom máximo permitido

	public PanelPantallaCarrera() {
		setPreferredSize(new Dimension(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO));
		setLayout(new BorderLayout());
		agregarPanelInformacion();
		agregarPanelCarreraConFondoYScroll();
		panelScrollCarrera.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelScrollCarrera.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);//no se si van aca estos dos :)
	}
	
	// Operaciones para ControladorVistas
	
	public Observer incorporarEntidad(EntidadLogica entidadLogica) {
		ObserverEntidades observerEntidad = new ObserverEntidades(entidadLogica);
		imagenFondoPanelCarreras.add(observerEntidad);
		return observerEntidad;
	}
	
	public Observer incorporarEntidadJugador(EntidadJugador entidadJugador) {
		ObserverJugador observerJugador = new ObserverJugador(this, entidadJugador);
		imagenFondoPanelCarreras.add(observerJugador);
		actualizarInfoJugador(entidadJugador);
		return observerJugador;
	}

	public Observer incorporarSilueta(EntidadLogica entidadLogica) {
		ObserverEntidades observerEntidad = new ObserverEntidades(entidadLogica);
		imagenFondoPanelCarreras.setIcon(new ImageIcon(getClass().getClassLoader().getResource(entidadLogica.getSprite().getRutaImagen())));
		imagenFondoPanelCarreras.setBounds(0,0, imagenFondoPanelCarreras.getIcon().getIconWidth(), imagenFondoPanelCarreras.getIcon().getIconHeight());
		panelCarreras.setPreferredSize(new Dimension(imagenFondoPanelCarreras.getIcon().getIconWidth(), imagenFondoPanelCarreras.getIcon().getIconHeight()));
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
		centrarEnJugador(jugador);
		
	}

	protected void centrarEnJugador(EntidadLogica jugador) {
		int posicionXJugador = jugador.getPosicionX();
		int posicionYJugador = jugador.getPosicionY();
	
		// Solo ajustamos el viewport si la posición de Mario ha cambiado significativamente
		if (Math.abs(posicionXJugador - posicionXAnterior) > 10) {
			JViewport viewport = panelScrollCarrera.getViewport();
			
			// Asegurar valores positivos
			int newX = Math.max(0, posicionXJugador - viewport.getWidth() / 2);
			int newY = Math.max(0, panelCarreras.getPreferredSize().height - viewport.getHeight()); // Coloca en la parte inferior
			
			// Verificar límites para X
			Dimension viewSize = panelCarreras.getPreferredSize();
			Dimension extentSize = viewport.getExtentSize();
			newX = Math.min(newX, viewSize.width - extentSize.width);
			
			// Actualiza la posición del viewport
			viewport.setViewPosition(new Point(newX, newY));
			posicionXAnterior = posicionXJugador;
		}
	}
	
	// Operaciones propias para construccion de PanelPantallaCarrera
	
	protected void agregarPanelCarreraConFondoYScroll() {
		imagenFondoPanelCarreras = new JLabel();
		imagenFondoPanelCarreras.setLayout(null);
		imagenFondoPanelCarreras.setBounds(0,0, ConstantesVistas.PANEL_CARRERA_ANCHO, ConstantesVistas.PANEL_ALTO);
		
		panelCarreras = new JPanel(null);
		panelCarreras.setPreferredSize(new Dimension(ConstantesVistas.PANEL_CARRERA_ANCHO, ConstantesVistas.PANEL_ALTO));
		panelCarreras.add(imagenFondoPanelCarreras);
		
		panelScrollCarrera = new JScrollPane(panelCarreras);
		panelScrollCarrera.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panelScrollCarrera.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		panelScrollCarrera.setBounds(0, 0, ConstantesVistas.PANEL_CARRERA_ANCHO, ConstantesVistas.PANEL_ALTO);
			
		add(panelScrollCarrera, BorderLayout.CENTER);
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
