package Pantallas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import GUI.GUI;
import Logica.Logica;


public class CentralPantallas {
    protected JPanel panelPrincipal;
    protected GUI miGUI;
    protected Logica miLogica;

    public CentralPantallas(GUI mi_GUI, Logica mi_logica) {
        miGUI = mi_GUI;
        miLogica = mi_logica;
    }

    public void mostrarMenuPrincipal() {
        panelPrincipal = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Super Mario Bros - Comision 15", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36)); 
        panelPrincipal.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 20, 10)); 
        JButton startButton = new JButton("Start Game");
        JButton exitButton = new JButton("Exit");

        startButton.setPreferredSize(new Dimension(150, 50));
        exitButton.setPreferredSize(new Dimension(150, 50));


        buttonPanel.add(startButton);
        buttonPanel.add(exitButton);
        panelPrincipal.add(buttonPanel, BorderLayout.CENTER);

        agregarFuncionalidadBotones();

        miGUI.setContentPane(panelPrincipal);
        miGUI.revalidate();
        miGUI.repaint();
    }

    private void agregarFuncionalidadBotones() {
        //TODO
    }

 
}