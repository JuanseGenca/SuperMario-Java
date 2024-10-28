package Paneles;

import GUI.ConstantesVistas;
import GUI.GUI;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPantallaPrincipal extends JPanel{
    private static final long serialVersionUID = -3884090044789061650L;
    private GUI gui;
    private JLabel imagenFondo;
    private JButton botonIniciar;
    private JButton botonPuntajes;

    public PanelPantallaPrincipal(GUI gui){
        this.gui = gui;
        setSize(ConstantesVistas.PANEL_ANCHO,ConstantesVistas.PANEL_ALTO);
        setLayout(null);
        agregarImagenFondo();
        agregarBotonIniciar();
        agregarBotonPuntaje();
        gui.reproducirSonido("menuPrincipal");
    }

    protected void agregarImagenFondo(){
        imagenFondo = new JLabel();
        ImageIcon iconoImagen = new ImageIcon(this.getClass().getResource("/Imagenes/pantalla-principal.png"));
        Image imagenEscalada = iconoImagen.getImage().getScaledInstance(ConstantesVistas.VENTANA_ANCHO,ConstantesVistas.VENTANA_ALTO,Image.SCALE_SMOOTH);
        Icon iconoImagenEscalada = new ImageIcon(imagenEscalada);
        imagenFondo.setIcon(iconoImagenEscalada);
        imagenFondo.setBounds(0,0,ConstantesVistas.VENTANA_ANCHO,ConstantesVistas.VENTANA_ALTO);
        add(imagenFondo);
    }
    
    protected void agregarBotonIniciar(){
        botonIniciar = new JButton();
        decorarBotonIniciar();
        registrarOyenteBotonIniciar();
        add(botonIniciar);
    }
    protected void agregarBotonPuntaje(){
        botonPuntajes = new JButton();
        decorarBotonPuntajes();
        registrarOyenteBotonPuntajes();
        add(botonPuntajes);
    }
    protected void decorarBotonIniciar(){
        transparentarBoton(botonIniciar);
        botonIniciar.setBounds(370 ,510, 430 , 50);
    }
    protected void decorarBotonPuntajes(){
        transparentarBoton(botonPuntajes);
        botonPuntajes.setBounds(410 ,650, 300 , 50);
    }
    protected void registrarOyenteBotonIniciar(){
        botonIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                gui.detenerSonido("menuPrincipal");
                gui.reproducirSonido("InicioJuego");
                gui.accionarInicioJuego();
            }
        });
    }
    protected void registrarOyenteBotonPuntajes(){
        botonPuntajes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("Puntajes");
                gui.accionarPantallaPuntajes();
            }
        });
    }
    protected void transparentarBoton(JButton boton){
        boton.setOpaque(false);
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
    }


}
