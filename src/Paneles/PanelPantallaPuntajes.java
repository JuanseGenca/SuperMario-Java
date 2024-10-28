package Paneles;

import GUI.ConstantesVistas;
import GUI.GUI;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public PanelPantallaPuntajes(GUI gui) {
        this.gui = gui;
        setSize(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
        setLayout(null);
        agregarImagenFondo();
        agregarBotonIniciar();
        agregarListaPuntajes();
        gui.reproducirSonido("menuPrincipal");
    }

    protected void agregarImagenFondo() {
        imagenFondo = new JLabel();
        ImageIcon iconoImagen = new ImageIcon(this.getClass().getResource("/Imagenes/pantalla-principal.png"));
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
        botonIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gui.mostrarPantallaInicial();
            }
        });
    }

    protected void transparentarBoton(JButton boton) {
        boton.setOpaque(false);
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
    }

    protected void agregarListaPuntajes() {
        labelsPuntajes = new JLabel[5];

        int startY = 200; // Y position where the list starts
        int spacing = 50; // Space between each score label

        // Example scores (replace with actual data)
        String[] nombres = {"Player1", "Player2", "Player3", "Player4", "Player5"};
        int[] puntajes = {5000, 4500, 4000, 3500, 3000};

        for (int i = 0; i < labelsPuntajes.length; i++) {
            labelsPuntajes[i] = new JLabel((i + 1) + ". " + nombres[i] + " - " + puntajes[i], SwingConstants.CENTER);
            labelsPuntajes[i].setBounds(0, startY + (i * spacing), ConstantesVistas.VENTANA_ANCHO, 30);
            labelsPuntajes[i].setFont(new Font("Arial", Font.BOLD, 24));
            System.out.println("Texto: "+labelsPuntajes[i].getText());
            System.out.println("X: "+labelsPuntajes[i].getX()+" Y: "+labelsPuntajes[i].getY());
            System.out.println("W: "+labelsPuntajes[i].getWidth()+" H: "+labelsPuntajes[i].getHeight());
            labelsPuntajes[i].setForeground(java.awt.Color.WHITE);
            add(labelsPuntajes[i]);
        }
    }
}
