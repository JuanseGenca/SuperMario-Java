package Paneles;

import GUI.ConstantesVistas;
import GUI.GUI;
import Logica.ConstantesSonidos;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Fabricas.SpritesMarioModo1;
import Fabricas.SpritesMarioModo2;

public class PanelModoDeJuego extends JPanel{
    private static final long serialVersionUID = -3884090044789061650L;
    private GUI gui;
    private JLabel imagenFondo;
    private JButton botonModo1;
    private JButton botonModo2;

    public PanelModoDeJuego(GUI gui){
        this.gui = gui;
        setSize(ConstantesVistas.PANEL_ANCHO,ConstantesVistas.PANEL_ALTO);
        setLayout(null);
        agregarImagenFondo();
        agregarBotonModo1();
        agregarBotonModo2();
    }

    protected void agregarImagenFondo(){
        imagenFondo = new JLabel();
        ImageIcon iconoImagen = new ImageIcon(this.getClass().getResource("/Imagenes/pantalla-modos.png"));
        Image imagenEscalada = iconoImagen.getImage().getScaledInstance(ConstantesVistas.VENTANA_ANCHO,ConstantesVistas.VENTANA_ALTO,Image.SCALE_SMOOTH);
        Icon iconoImagenEscalada = new ImageIcon(imagenEscalada);
        imagenFondo.setIcon(iconoImagenEscalada);
        imagenFondo.setBounds(0,0,ConstantesVistas.VENTANA_ANCHO,ConstantesVistas.VENTANA_ALTO);
        add(imagenFondo);
    }
    
    protected void agregarBotonModo1(){
        botonModo1 = new JButton();
        decorarBotonModo1();
        registrarOyenteBotonModo1();
        add(botonModo1);
    }

    protected void agregarBotonModo2(){
        botonModo2 = new JButton();
        decorarBotonModo2();
        registrarOyenteBotonModo2();
        add(botonModo2);
    }

    protected void decorarBotonModo1(){
        transparentarBoton(botonModo1);
        botonModo1.setBounds(100 ,190, 450 , 360);
    }

    protected void decorarBotonModo2(){
        transparentarBoton(botonModo2);
        botonModo2.setBounds(650 ,190, 450 , 360);
    }

    protected void registrarOyenteBotonModo1(){
        botonModo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.getLogica().actualizarSprites(new SpritesMarioModo1());
                gui.accionarInicioJuego();
                gui.detenerSonido(ConstantesSonidos.MUSICALVL2);
                gui.reproducirSonido(ConstantesSonidos.INICIOJUEGO);
            }
        });
    }

    protected void registrarOyenteBotonModo2(){
        botonModo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.getLogica().actualizarSprites(new SpritesMarioModo2());
                gui.accionarInicioJuego();
                gui.detenerSonido(ConstantesSonidos.MUSICALVL2);
                gui.reproducirSonido(ConstantesSonidos.INICIOJUEGO);
            }
        });
    }
    
    protected void transparentarBoton(JButton boton){
        boton.setOpaque(false);
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
    }

}