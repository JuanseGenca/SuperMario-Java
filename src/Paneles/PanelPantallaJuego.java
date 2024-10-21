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
import javax.swing.SwingUtilities;

public class PanelPantallaJuego extends JPanel {

    private static final long serialVersionUID = -1366756178696496543L;
    private JPanel panelJuego;
    private JPanel panelInformacion;
    private JLabel imagenFondoPanelJuego;
    private JLabel imagenFondoPanelInformacion;
    private JScrollPane panelPantallaJuego;
    private JLabel labelPuntaje;
    private JLabel labelMonedas;
    private JLabel labelVidas;
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
        viewport.setViewPosition(new Point(0, viewSize.height - extentSize.height)); // Ajusta la vista al inicio
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
        imagenFondoPanelJuego.setBounds(0, 0, imagenFondoPanelJuego.getIcon().getIconWidth(), imagenFondoPanelJuego.getIcon().getIconHeight());
        panelJuego.setPreferredSize(new Dimension(imagenFondoPanelJuego.getIcon().getIconWidth(), imagenFondoPanelJuego.getIcon().getIconHeight()));
        return observerEntidad;
    }

    public void actualizarInfoJugador(EntidadJugador jugador) {
        actualizarLabelsInformacion(jugador);
        actualizarLabelsMonedas(jugador);
        actualizarLabelsVidas(jugador);
        actualizarScrollHaciaJugador(jugador);
    }

    protected void actualizarLabelsVidas(EntidadJugador jugador) {
        labelVidas.setText(textoConCantidadDigitos(jugador.getVidas(), 5));
    }

    protected void actualizarLabelsInformacion(EntidadJugador jugador) {
        labelPuntaje.setText(textoConCantidadDigitos(jugador.getPuntaje(), 5));
    }
    
    protected void actualizarLabelsMonedas(EntidadJugador jugador) {
        labelMonedas.setText(textoConCantidadDigitos(jugador.getMonedas(), 5));
    }

    protected String textoConCantidadDigitos(int numero, int digitos) {
        String textoAutocompletado = "";
        if (en_rango(numero, 0, 9)) {
            textoAutocompletado = "0000" + numero;
        } else {
            if (en_rango(numero, 10, 99)) {
                textoAutocompletado = "000" + numero;
            } else {
                if (en_rango(numero, 100, 999)) {
                    textoAutocompletado = "00" + numero;
                } else {
                    if (en_rango(numero, 1000, 9999)) {
                        textoAutocompletado = "0" + numero;
                    } else {
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
        double interpolationFactor = 0.3; // Controla la suavidad

        int posicionInterpoladaX = (int) (posicionXAnterior + (jugador.getPosicionX() - posicionXAnterior) * interpolationFactor);
        //int posicionInterpoladaY = (int) (posicionYAnterior + (jugador.getPosicionY() - posicionYAnterior) * interpolationFactor);

        centrarEnJugador(posicionInterpoladaX);
    }

	protected void centrarEnJugador(int posicionXJugador) {
		JViewport viewport = panelPantallaJuego.getViewport();
		Dimension viewSize = panelJuego.getPreferredSize();
		Dimension extentSize = viewport.getExtentSize();
	
		// Define el umbral para mover el viewport
		int thresholdX = extentSize.width / 8;
	
		// Calculamos la nueva posición X para centrar al jugador
		int nuevaPosicionX = Math.min(Math.max(posicionXJugador - thresholdX, 0), viewSize.width - extentSize.width);
	
		// Mantenemos la posición Y actual sin cambios
		Point posicionActual = viewport.getViewPosition();
		int posicionYConstante = posicionActual.y;
	
		// Solo cambiamos la vista si la nueva posición X es diferente de la actual
		if (posicionActual.x != nuevaPosicionX) {
			// Actualizamos solo la posición X, manteniendo la Y constante
			viewport.setViewPosition(new Point(nuevaPosicionX, posicionYConstante));
	
			// Actualizamos la posición anterior
			posicionXAnterior = posicionXJugador;
	
			// Revalidamos y repintamos solo si es necesario
			viewport.revalidate();
			viewport.repaint();
		}
	}
	
	
	
	
    // Operaciones propias para construccion de PanelPantallaJuego

    protected void agregarPanelJuegoConFondoYScroll() {
        imagenFondoPanelJuego = new JLabel();
        imagenFondoPanelJuego.setLayout(null);
        imagenFondoPanelJuego.setBounds(0, 0, ConstantesVistas.PANEL_JUEGO_ANCHO, ConstantesVistas.PANEL_ALTO);

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
        agregarLabelsEditablesMonedas();
        agregarLabelsEditablesVidas();
        add(panelInformacion, BorderLayout.EAST);
    }

    protected void agregarImagenFondoPanelInformacion() {
        imagenFondoPanelInformacion = new JLabel();
        ImageIcon iconoImagen = new ImageIcon(this.getClass().getResource("/Imagenes/pantalla-informacion.png"));
        Image imagenEscalada = iconoImagen.getImage().getScaledInstance(ConstantesVistas.PANEL_INFORMACION_ANCHO, ConstantesVistas.VENTANA_ALTO, Image.SCALE_SMOOTH);
        Icon iconoImagenEscalado = new ImageIcon(imagenEscalada);
        imagenFondoPanelInformacion.setIcon(iconoImagenEscalado);
        imagenFondoPanelInformacion.setBounds(0, 0, ConstantesVistas.PANEL_INFORMACION_ANCHO, ConstantesVistas.VENTANA_ALTO);
        panelInformacion.add(imagenFondoPanelInformacion);
    }

    protected void agregarLabelsEditablesVidas() {
        labelVidas = new JLabel("00000");
        decorarLabelsVidas();
        imagenFondoPanelInformacion.add(labelVidas);
    }

    protected void agregarLabelsEditablesInformacion() {
        labelPuntaje = new JLabel("00000");
        decorarLabelsInformacion();
        imagenFondoPanelInformacion.add(labelPuntaje);
    }

    protected void decorarLabelsVidas() {
        labelVidas.setBounds(49, 365, 150, 50);
        labelVidas.setForeground(Color.WHITE);
        labelVidas.setFont(new Font(labelPuntaje.getFont().getName(), Font.BOLD, 24));
    }

    protected void decorarLabelsInformacion() {
        labelPuntaje.setBounds(49, 255, 150, 50);
        labelPuntaje.setForeground(Color.WHITE);
        labelPuntaje.setFont(new Font(labelPuntaje.getFont().getName(), Font.BOLD, 24));
    }

    protected void agregarLabelsEditablesMonedas() {
        labelMonedas = new JLabel("00000");
        decorarLabelsMonedas();
        imagenFondoPanelInformacion.add(labelMonedas);
    }

    protected void decorarLabelsMonedas() {
        labelMonedas.setBounds(49, 475, 150, 50);
        labelMonedas.setForeground(Color.WHITE);
        labelMonedas.setFont(new Font(labelMonedas.getFont().getName(), Font.BOLD, 24));
    }
}
