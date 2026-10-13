package Paneles;

import GUI.ConstantesVistas;
import GUI.GUI;
import Logica.ConstantesSonidos;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelPantallaPuntajes extends JPanel {
    
    private static final long serialVersionUID = -3884090044789061650L;
    private GUI gui;
    private JLabel imagenFondo;
    private JButton botonIniciar;
    private JLabel[] labelsPuntajes;

    public PanelPantallaPuntajes(GUI gui, String[] nombreJugadores, int[] puntajeJugadores) {
        this.gui = gui;
        setSize(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
        setLayout(null);
        agregarImagenFondo();
        agregarListaPuntajes(nombreJugadores, puntajeJugadores);
        agregarBotonIniciar();
    }

    protected void agregarImagenFondo() {
        imagenFondo = new JLabel();
        ImageIcon iconoImagen = new ImageIcon(this.getClass().getResource("/Imagenes/pantalla-puntajes.png"));
        Image imagenEscalada = iconoImagen.getImage().getScaledInstance(ConstantesVistas.VENTANA_ANCHO, ConstantesVistas.VENTANA_ALTO, Image.SCALE_SMOOTH);
        Icon iconoImagenEscalada = new ImageIcon(imagenEscalada);
        imagenFondo.setIcon(iconoImagenEscalada);
        imagenFondo.setBounds(0, 0, ConstantesVistas.VENTANA_ANCHO, ConstantesVistas.VENTANA_ALTO);
        add(imagenFondo);
    }

    protected void agregarBotonIniciar() {
        botonIniciar = new JButton();
        decorarBotonIniciar();
        registrarOyenteBotonIniciar();
        add(botonIniciar);
    }

    protected void decorarBotonIniciar() {
        transparentarBoton(botonIniciar);
        botonIniciar.setBounds(370, 600, 500, 100);
    }

    protected void registrarOyenteBotonIniciar() {
        botonIniciar.addActionListener((ActionEvent e) -> {
            gui.mostrarPantallaInicial();
            gui.detenerSonido(ConstantesSonidos.MUSICALVL3);
            gui.reproducirSonido(ConstantesSonidos.MENUPRINCIPAL);
        });
    }

    protected void transparentarBoton(JButton boton) {
        boton.setOpaque(false);
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
    }

    protected void agregarListaPuntajes(String[] nombreJugadores, int[] puntajeJugadores) {
        labelsPuntajes = new JLabel[5];

        int startY = 200; // posicion donde comienza la lista
        int spacing = 75; // espacio entre cada label

        for (int i = 0; i < labelsPuntajes.length; i++) {
            labelsPuntajes[i] = new JLabel((i + 1) + ". " + nombreJugadores[i] + " - " + puntajeJugadores[i], SwingConstants.CENTER);
            labelsPuntajes[i].setBounds(0, startY + (i * spacing), 1200, 50);
            labelsPuntajes[i].setFont(new Font("Helvetica", Font.BOLD, 42));
            labelsPuntajes[i].setForeground(java.awt.Color.WHITE);
            imagenFondo.add(labelsPuntajes[i]);
        }
    }
}
