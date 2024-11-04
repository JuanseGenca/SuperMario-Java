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

public class PanelInformacionJugador{

    private JPanel panelInformacion;
    private JLabel imagenFondoPanelInformacion;
    private JLabel labelPuntaje;
    private JLabel labelMonedas;
    private JLabel labelVidas;
    private JLabel labelTiempo;
    private JLabel labelNivel;
    private long startTime;
    private GUI miGui;

    public PanelInformacionJugador(GUI gui, PanelPantallaJuego miPantallaJuego) {
        miGui = gui;
        agregarPanelInformacion(miPantallaJuego);
        
    }

    public void actualizarInfoJugador(EntidadJugador jugador) {
        actualizarLabelsInformacion(jugador);
        actualizarLabelsMonedas(jugador);
        actualizarLabelsVidas(jugador);
        actualizarLabelsTiempo(jugador);
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

    protected void agregarPanelInformacion(PanelPantallaJuego miPantallaJuego) {
        panelInformacion = new JPanel();
        panelInformacion.setLayout(null);
        panelInformacion.setPreferredSize(new Dimension(ConstantesVistas.PANEL_INFORMACION_ANCHO, ConstantesVistas.PANEL_ALTO));
        agregarImagenFondoPanelInformacion();
        agregarLabelsEditablesInformacion();
        agregarLabelsEditablesMonedas();
        agregarLabelsEditablesVidas();
        agregarLabelsEditablesTiempo();
        agregarLabelsEditablesNivel();
        miPantallaJuego.add(panelInformacion, BorderLayout.EAST);
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
        labelNivel = new JLabel(String.valueOf(miGui.getNivel()));
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
