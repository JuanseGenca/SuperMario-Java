package Pantallas;

import javax.swing.JPanel;
import GUI.GUI;
import Logica.Logica;


public class CentralPantallas {
    protected JPanel panelPrincipal;
    protected GUI miGUI;
    protected Logica miLogica;
    private PantallaMenuPrincipal miPantallaMenuPrincipal;
    private int WIDTH = 1200;
    private int HEIGHT = 800;

    public CentralPantallas(GUI mi_GUI, Logica mi_logica) {
        miGUI = mi_GUI;
        miLogica = mi_logica;
    }

    public void mostrarMenuPrincipal() {
        miPantallaMenuPrincipal = new PantallaMenuPrincipal(this);
        miPantallaMenuPrincipal.crearPantalla(WIDTH, HEIGHT);

        agregarAGUI(miPantallaMenuPrincipal);
    }

    private void agregarFuncionalidadBotones() {
        //TODO
    }

 
    private void agregarAGUI(JPanel p) {
        miGUI.setContentPane(p);
        miGUI.revalidate();
        miGUI.repaint();
    } 
}