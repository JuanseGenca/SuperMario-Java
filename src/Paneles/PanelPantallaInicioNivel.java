package Paneles;

import GUI.ConstantesVistas;
import GUI.GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPantallaInicioNivel extends JPanel{
    private static final long serialVersionUID = -3884090044789061650L;
    private GUI miGUI;
    private JLabel imagenFondo;

    public PanelPantallaInicioNivel(GUI gui){
        miGUI = gui;
        setSize(ConstantesVistas.PANEL_ANCHO,ConstantesVistas.PANEL_ALTO);
        setLayout(null);
        agregarImagenFondo();
    }

    protected void agregarImagenFondo() {
        // Set up the background image
        imagenFondo = new JLabel();
        ImageIcon iconoImagen = new ImageIcon(this.getClass().getResource("/Imagenes/pantalla-nivel.png"));
        Image imagenEscalada = iconoImagen.getImage().getScaledInstance(ConstantesVistas.VENTANA_ANCHO, ConstantesVistas.VENTANA_ALTO, Image.SCALE_SMOOTH);
        Icon iconoImagenEscalada = new ImageIcon(imagenEscalada);
        imagenFondo.setIcon(iconoImagenEscalada);
        imagenFondo.setBounds(0, 0, ConstantesVistas.VENTANA_ANCHO, ConstantesVistas.VENTANA_ALTO);
    
        int nivel = miGUI.getNivel();
        String mundo = "1";
        JLabel etiquetaNivel = new JLabel(mundo + " - " + nivel);
        etiquetaNivel.setForeground(Color.WHITE);
        etiquetaNivel.setFont(new Font("SansSerif", Font.BOLD, 48));
        etiquetaNivel.setBounds(600, 200, 100, 50);
    

        int vidas = miGUI.getVidas();
        JLabel etiquetaVidas = new JLabel(""+vidas);
        etiquetaVidas.setForeground(Color.WHITE);
        etiquetaVidas.setFont(new Font("SansSerif", Font.BOLD, 40));
        etiquetaVidas.setBounds(610, 315, 100, 50);
    
        imagenFondo.add(etiquetaNivel);
        imagenFondo.add(etiquetaVidas);
        
        add(imagenFondo);
    }

}
