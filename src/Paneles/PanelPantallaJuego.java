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
    private JLabel labelMonedas;
    private JLabel labelVidas;
    private JLabel labelTiempo;
    private JLabel labelNivel;
    private long startTime;
    private int posicionXAnterior = 0;
    private GUI miGui;
    private final int TiempoDeJuego = (1 * 1000);

    public PanelPantallaJuego(GUI gui) {
        miGui = gui;
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
        actualizarLabelsTiempo(jugador);
        actualizarScrollHaciaJugador(jugador);
    }

    protected void actualizarLabelsVidas(EntidadJugador jugador) {
        labelVidas.setText(textoConCantidadDigitos(jugador.getVidas(), 5));
    }

    protected void actualizarLabelsTiempo(EntidadJugador jugador) {
        if((System.currentTimeMillis() - startTime)/(-1000) == 0){
            miGui.reiniciarNivel();
        }else{
            labelTiempo.setText(Long.toString((System.currentTimeMillis() - startTime)/(-1000)));
        }
        
        //labelTiempo.setText(Long.toString((System.currentTimeMillis() - startTime)/(-1000)));
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

        centrarEnJugador(posicionInterpoladaX);
    }

	protected void centrarEnJugador(int posicionXJugador) {
		JViewport viewport = panelPantallaJuego.getViewport();
		Dimension viewSize = panelJuego.getPreferredSize();
		Dimension extentSize = viewport.getExtentSize();

		int thresholdX = extentSize.width / 8;

		int nuevaPosicionX = Math.min(Math.max(posicionXJugador - thresholdX, 0), viewSize.width - extentSize.width);

		Point posicionActual = viewport.getViewPosition();
		int posicionYConstante = posicionActual.y;

		if (posicionActual.x != nuevaPosicionX) {
			viewport.setViewPosition(new Point(nuevaPosicionX, posicionYConstante));

			posicionXAnterior = posicionXJugador;

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
        agregarLabelsEditablesTiempo();
        agregarLabelsEditablesNivel();
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

    protected void agregarLabelsEditablesNivel(){
        labelNivel = new JLabel("1");
        decorarLabelsNivel();
        imagenFondoPanelInformacion.add(labelNivel);
    }

    protected void agregarLabelsEditablesTiempo() {
        startTime = System.currentTimeMillis() + (60000 * 2);
        labelTiempo = new JLabel("00000");
        decorarLabelsTiempo();
        imagenFondoPanelInformacion.add(labelTiempo);
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

    protected void decorarLabelsNivel(){
        labelNivel.setBounds(49, 70, 150, 50);
        labelNivel.setForeground(Color.WHITE);
        labelNivel.setFont(new Font(labelPuntaje.getFont().getName(), Font.BOLD, 24));
    }

    protected void decorarLabelsTiempo() {
        labelTiempo.setBounds(49, 160, 150, 50);
        labelTiempo.setForeground(Color.WHITE);
        labelTiempo.setFont(new Font(labelPuntaje.getFont().getName(), Font.BOLD, 24));
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
