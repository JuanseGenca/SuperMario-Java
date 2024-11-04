package Paneles;

import Entidades.*;
import GUI.*;
import Logica.ConstantesEntidades;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

public class PanelPantallaJuego extends JPanel {

    private static final long serialVersionUID = -1366756178696496543L;
    private JLayeredPane panelJuego;
    private JLabel imagenFondoPanelJuego;
    private JLabel primerLayerEntidades;
    private JScrollPane panelPantallaJuego;
    private int posicionXAnterior = 0;
    private GUI miGui;
    private PanelInformacionJugador miPanelInformacionJugador;

    public PanelPantallaJuego(GUI gui) {
        miGui = gui;
        setPreferredSize(new Dimension(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO));
        setLayout(new BorderLayout());
        miPanelInformacionJugador = new PanelInformacionJugador(gui, this);
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
        if(entidadLogica.getZIndex() == ConstantesEntidades.PRIORIDAD) {
            primerLayerEntidades.add(observerEntidad);
        } else imagenFondoPanelJuego.add(observerEntidad);

        return observerEntidad;
    }

    public Observer incorporarEntidadJugador(EntidadJugador entidadJugador) {
        ObserverJugador observerJugador = new ObserverJugador(this, entidadJugador);
        primerLayerEntidades.add(observerJugador);
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

    public void eliminarEntidad(ObserverEntidades observerEntidades){
        if(observerEntidades.getZIndex() == ConstantesEntidades.FONDO) {
            imagenFondoPanelJuego.remove(observerEntidades);
        }else {primerLayerEntidades.remove(observerEntidades);}
        
        primerLayerEntidades.repaint();
    }

    public void actualizarInfoJugador(EntidadJugador jugador) {
        miPanelInformacionJugador.actualizarInfoJugador(jugador);
        actualizarScrollHaciaJugador(jugador);
    }

    protected void actualizarLabelsVidas(EntidadJugador jugador) {
        miPanelInformacionJugador.actualizarLabelsVidas(jugador);
    }

    protected void actualizarLabelsTiempo(EntidadJugador jugador) {
        miPanelInformacionJugador.actualizarLabelsTiempo(jugador);
    }

    protected void actualizarLabelsInformacion(EntidadJugador jugador) {
        miPanelInformacionJugador.actualizarLabelsInformacion(jugador);
    }
    
    protected void actualizarLabelsMonedas(EntidadJugador jugador) {
        miPanelInformacionJugador.actualizarLabelsMonedas(jugador);
    }

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

        primerLayerEntidades = new JLabel();
        primerLayerEntidades.setLayout(null);
        primerLayerEntidades.setBounds(0, 0, 10000, 1000);


        panelJuego = new JLayeredPane();
        panelJuego.setPreferredSize(new Dimension(ConstantesVistas.PANEL_JUEGO_ANCHO, ConstantesVistas.PANEL_ALTO));
        panelJuego.add(imagenFondoPanelJuego,2);
        panelJuego.add(primerLayerEntidades,0);

        panelJuego.revalidate();
        panelJuego.repaint();

        panelPantallaJuego = new JScrollPane(panelJuego);
        panelPantallaJuego.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panelPantallaJuego.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        panelPantallaJuego.setBounds(0, 0, ConstantesVistas.PANEL_JUEGO_ANCHO, ConstantesVistas.PANEL_ALTO);

        add(panelPantallaJuego, BorderLayout.CENTER);
    }
}
