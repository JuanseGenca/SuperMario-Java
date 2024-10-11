package Paneles;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelScore extends JPanel implements Paneles {

    private CentralPaneles miCentral;
    private JLabel scoreLabel;

    public PanelScore(CentralPaneles mi_central) {
        miCentral = mi_central;
    }

    @Override
    public void crearPanel() {
        setBackground(new Color(0,0,0,200));

		scoreLabel = new JLabel("SCORE: "+agregarPadding(miCentral.getScore()));
		scoreLabel.setFont(new Font("Algerian", Font.PLAIN, 40));
		scoreLabel.setForeground(Color.WHITE);
		add(scoreLabel);
    }

    @Override
    public void agregarAJFrame() {
        //TODO: queda pendiente hacerlo sin GridBagLayout
    }
    
    public void actualizarScore(int score)
    {
        scoreLabel.setText("SCORE: "+ agregarPadding(score));
    }

    private String agregarPadding(int score) {
		String padding ="";
        int length = String.valueOf(score).length();

		switch (length) {
            case 1:
                padding = "0000000";
                break;
            case 2:
                padding = "000000";
                break;
            case 3:
                padding = "00000";
                break;
            case 4:
                padding = "0000";
                break;
            case 5:
                padding = "000";
                break;
            case 6:
                padding = "00";
                break;
            case 7:
                padding = "0";
                break;
            default:
                padding = "";
                break;
        }
        
        String scoreConPadding = padding + score;

        return scoreConPadding;
	}
}