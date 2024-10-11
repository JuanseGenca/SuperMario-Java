package Paneles;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelVidas extends JPanel implements Paneles {
private CentralPaneles miCentral;
    private JLabel timerLabel;

    public PanelVidas(CentralPaneles mi_central) {
        miCentral = mi_central;
    }

    public void crearPanel() {

        timerLabel = new JLabel("Vidas restante: "+ miCentral.getVidas());
		timerLabel.setFont(new Font("Algerian", Font.PLAIN, 20));
        add(timerLabel);
    }

    public void agregarAJFrame() {
		//TODO: queda pendiente hacerlo sin GridBagLayout
    }
    
    public void actualizarVidas() {	
	    timerLabel.setText("Vidas restantes: " +  miCentral.getVidas());
		repaint();
        revalidate();
	}
	
}
