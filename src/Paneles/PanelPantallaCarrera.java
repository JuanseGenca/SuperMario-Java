package Paneles;

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

import Entidades.*;
import GUI.*;

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
		agregar_panel_informacion();
		agregar_panel_carrera_con_fondo_y_scroll();
	}
	
	// Operaciones para ControladorVistas
	
	public Observer incorporarEntidad(EntidadLogica entidadLogica) {
		ObserverEntidades observerEntidad = new ObserverEntidades(entidadLogica);
		imagenFondoPanelCarreras.add(observerEntidad);
		return observerEntidad;
	}
	
	public Observer incorporar_entidad_jugador(Entidad entidadJugador) {
		ObserverJugador observerJugador = new ObserverJugador(this, entidadJugador);
		imagenFondoPanelCarreras.add(observerJugador);
		actualizarInfoJugador(entidadJugador);
		return observerJugador;
	}
	
	public Observer incorporar_silueta(EntidadLogica entidad_logica) {
		ObserverEntidades observer_entidad = new ObserverEntidades(entidad_logica);
		imagenFondoPanelCarreras.setIcon(new ImageIcon(getClass().getClassLoader().getResource(entidad_logica.get_sprite().get_ruta_imagen())));
		imagenFondoPanelCarreras.setBounds(0,0, imagenFondoPanelCarreras.getIcon().getIconWidth(), imagenFondoPanelCarreras.getIcon().getIconHeight());
		panelCarreras.setPreferredSize(new Dimension(imagenFondoPanelCarreras.getIcon().getIconWidth(), imagenFondoPanelCarreras.getIcon().getIconHeight()));
		return observer_entidad;
	}
		
	protected void actualizarInfoJugador(Entidad jugador) {
		actualizar_labels_informacion(jugador);
		actualizar_scroll_hacia_jugador(jugador);
	}
	
	protected void actualizar_labels_informacion(Entidad jugador) {
		labelPuntaje.setText( texto_con_cantidad_digitos(jugador.get_puntaje(), 5) );
	}
	
	protected String texto_con_cantidad_digitos(int numero, int digitos) {
		String texto_autocompletado = "";
		if (en_rango(numero, 0, 9)) {
			texto_autocompletado = "0000" + numero;
		}else {
			if (en_rango(numero, 10, 99)) {
				texto_autocompletado = "000" + numero;
			}else {
				if (en_rango(numero, 100, 999)) {
					texto_autocompletado = "00" + numero;
				}else {
					if(en_rango(numero, 1000, 9999)) {
						texto_autocompletado = "0" + numero;
					}else {
						texto_autocompletado += numero;
					}
				}
			}
		}
		return texto_autocompletado;
	}
	
	protected boolean en_rango(int numero, int piso, int techo) {
		boolean retorno;
		retorno = numero >= piso;
		retorno = retorno && (numero <= techo);
		return retorno;
	}
	
	// Operacion para observer de jugador
	
	protected void actualizar_scroll_hacia_jugador(Entidad jugador) {
		// To DO
		//panel_scroll_carrera.getVerticalScrollBar().setValue( panel_scroll_carrera.getVerticalScrollBar().getValue() + jugador.get_velocidad() );
	}
	
	// Operaciones propias para construccion de PanelPantallaCarrera
	
	protected void agregar_panel_carrera_con_fondo_y_scroll() {
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
		
	protected void agregar_panel_informacion() {
		panelInformacion = new JPanel();
		panelInformacion.setLayout(null);
		panelInformacion.setPreferredSize(new Dimension(ConstantesVistas.PANEL_INFORMACION_ANCHO, ConstantesVistas.PANEL_ALTO));
		agregar_imagen_fondo_panel_informacion();
		agregar_labels_editables_informacion();
		add(panelInformacion, BorderLayout.EAST);
	}
	
	protected void agregar_imagen_fondo_panel_informacion() {
		imagenFondoPanelInformacion = new JLabel();
		ImageIcon icono_imagen = new ImageIcon(this.getClass().getResource("/imagenes/pantalla-informacion.png"));
		Image imagen_escalada = icono_imagen.getImage().getScaledInstance(ConstantesVistas.PANEL_INFORMACION_ANCHO, ConstantesVistas.PANEL_ALTO, Image.SCALE_SMOOTH);
		Icon icono_imagen_escalado = new ImageIcon(imagen_escalada);
		imagenFondoPanelInformacion.setIcon(icono_imagen_escalado);
		imagenFondoPanelInformacion.setBounds(0,0, ConstantesVistas.PANEL_INFORMACION_ANCHO, ConstantesVistas.PANEL_ALTO);
		panelInformacion.add(imagenFondoPanelInformacion);
	}
	
	protected void agregar_labels_editables_informacion() {
		labelPuntaje = new JLabel("00000");
		decorar_labels_informacion();
		imagenFondoPanelInformacion.add(labelPuntaje);
	}	
	
	protected void decorar_labels_informacion() {
		labelPuntaje.setBounds(49, 120, 150, 50);
		
		labelPuntaje.setForeground(Color.WHITE);
		
		labelPuntaje.setFont(new Font(labelPuntaje.getFont().getName(), Font.BOLD, 24));
	}
}
