package Paneles;

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
    private GUI gui;
    private JLabel imagenFondo;
    private JButton botonIniciar;
    private JButton botonPuntajes;

    public PanelPantallaPrincipal(Gui gui){
        this.gui = gui;
        setSize(ConstantesVistas.PANEL_ANCHO,ConstantesVistas.PANEL_ALTO);
        setLayout(null);
        agregarImagenFondo();
        agregarBotonIniciar();
        agregarBotonPuntaje();
    }

    protected agregarImagenFondo(){
        imagenFondo = new JLabel();
        ImageIcon iconoImagen = new ImageIcon("assets/bg.png");
        Image imagenEscalada = icono.getImage().getScaledInstance(ConstantesVistas.PANEL_ANCHO,ConstantesVistas.PANEL_ALTO,Image.SCALE_SMOOTH);
        Icon iconoImagenEscalada = new ImageIcon(imagenEscalada);
        imagenFondo.setIcon(iconoImagenEscalada);
        imagenFondo.setBounds(0,0,ConstantesVistas.PANEL_ANCHO,ConstantesVistas.PANEL_ALTO);
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
        botonIniciar.setBounds((ConstantesVistas.PANEL_ANCHO / 2) - 100 ,ConstantesVistas.PANEL_ALTO - 150, 200 , 50);
    }
    protected void decorarBotonPuntajes(){
        transparentarBoton(botonPuntajes);
        boton_puntajes.setBounds((ConstantesVistas.PANEL_ANCHO / 2) - 130 ,ConstantesVistas.PANEL_ALTO - 90, 260 , 50);
    }
    protected void registrarOyenteBotonIniciar(){
        botonIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                gui.accionarInicioJuego();
            }
        });
    }
    protected void registrarOyenteBotonPuntajes(){
        botonPuntajes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
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
