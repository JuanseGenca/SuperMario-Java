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

import Logica.Logica;
import Fabricas.SpritesMarioModo1;
import Fabricas.SpritesMarioModo2;


public class PanelModoDeJuego extends JPanel {

    private JButton botonModo1;
    private JButton botonModo2;
    private GUI gui;

    public PanelModoDeJuego(GUI gui) {
        // Crear los botones
        this.gui = gui;
        botonModo1 = new JButton("Modo 1");
        botonModo2 = new JButton("Modo 2");

        botonModo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Se seleccionó el Modo 1");
                gui.getLogica().actualizarSprites(new SpritesMarioModo1());
                gui.accionarInicioJuego();
            }
        });

        botonModo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Se seleccionó el Modo 2");
                gui.getLogica().actualizarSprites(new SpritesMarioModo2());
                gui.accionarInicioJuego();
            }
        });

        // Agregar los botones al panel
        add(botonModo1);
        add(botonModo2);
        
    }
}
