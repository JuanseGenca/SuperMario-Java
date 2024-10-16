package Pantallas;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import Paneles.PanelCamara;
import Paneles.PanelScore;
import Paneles.PanelTiempo;
import Paneles.PanelVidas;

public class PantallaJuego extends JLabel {
    private PanelCamara miPanelCamara;
    private PanelScore miPanelScore;
    private PanelTiempo miPanelTiempo;
    private PanelVidas miPanelVidas;

    public PantallaJuego(PanelCamara pc, PanelScore ps, PanelTiempo pt, PanelVidas pv) {
        miPanelCamara = pc;
        miPanelScore = ps;
        miPanelTiempo = pt;
        miPanelVidas = pv;

        // Configuración del layout del PantallaJuego
        setLayout(new BorderLayout());

        agregarComponentes();
    }

    private void agregarComponentes() {
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelSuperior.add(miPanelScore);
        panelSuperior.add(miPanelTiempo);
        panelSuperior.add(miPanelVidas);

        
        add(panelSuperior, BorderLayout.NORTH);

        
        add(miPanelCamara, BorderLayout.CENTER);
    }
}
