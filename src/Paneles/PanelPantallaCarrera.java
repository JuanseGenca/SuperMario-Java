package Paneles;

import Entidades.*;
import GUI.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelPantallaCarrera extends JPanel {

	private static final long serialVersionUID = -1366756178696496543L;
	private JPanel panelCarreras;
	private JPanel panelInformacion;
	private JLabel imagenFondoPanelCarreras;
	private JLabel imagenFondoPanelInformacion;
	private JScrollPane panelScrollCarrera;
	private JLabel labelPuntaje;

	public PanelPantallaCarrera() {
		setPreferredSize(new Dimension(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO));
		setLayout(new BorderLayout());
		agregarPanelInformacion();
		agregarPanelCarreraConFondoYScroll();
	}
	
	// Operaciones para ControladorVistas
	
	public Observer incorporarEntidad(EntidadLogica entidadLogica) {
		ObserverEntidades observerEntidad = new ObserverEntidades(entidadLogica);
		imagenFondoPanelCarreras.add(observerEntidad);
		return observerEntidad;
	}
	
	public Observer incorporarEntidadJugador(Entidad entidadJugador) {
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
		
	protected void actualizarInfoJugador(Entidad jugador) {
		actualizarLabelsInformacion(jugador);
		actualizarScrollHaciaJugador(jugador);
	}
	
	protected void actualizarLabelsInformacion(Entidad jugador) {
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
		// To DO
		//panel_scroll_carrera.getVerticalScrollBar().setValue( panel_scroll_carrera.getVerticalScrollBar().getValue() + jugador.get_velocidad() );
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
		panelScrollCarrera.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
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
		if (panelInformacion == null) {
			return;
		}
		imagenFondoPanelInformacion = new JLabel();
		try {
			ImageIcon iconoImagen = new ImageIcon(this.getClass().getResource("/imagenes/pantalla-informacion.png"));
			if (iconoImagen == null) {
				throw new NullPointerException();
			}
			Image imagenEscalada = iconoImagen.getImage().getScaledInstance(ConstantesVistas.PANEL_INFORMACION_ANCHO, ConstantesVistas.PANEL_ALTO, Image.SCALE_SMOOTH);
			Icon iconoImagenEscalado = new ImageIcon(imagenEscalada);
			imagenFondoPanelInformacion.setIcon(iconoImagenEscalado);
			imagenFondoPanelInformacion.setBounds(0,0, ConstantesVistas.PANEL_INFORMACION_ANCHO, ConstantesVistas.PANEL_ALTO);
			panelInformacion.add(imagenFondoPanelInformacion);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
