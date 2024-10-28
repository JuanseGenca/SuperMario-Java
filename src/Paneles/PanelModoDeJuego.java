package Paneles;


import GUI.ConstantesVistas;
import GUI.GUI;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelModoDeJuego extends JPanel {

    private JButton modo1Button;
    private JButton modo2Button;
    private GUI gui;

    public PanelModoDeJuego(GUI gui) {
        // Crear los botones
        this.gui = gui;
        modo1Button = new JButton("Modo 1");
        modo2Button = new JButton("Modo 2");

        // Agregar un ActionListener a cada botón
        modo1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí se ejecutaría el código para iniciar el modo 1
                System.out.println("Se seleccionó el Modo 1");
                gui.accionarInicioJuego();
            }
        });

        modo2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí se ejecutaría el código para iniciar el modo 2
                System.out.println("Se seleccionó el Modo 2");
                gui.accionarInicioJuego();
            }
        });

        // Agregar los botones al panel
        add(modo1Button);
        add(modo2Button);
        
    }
}
