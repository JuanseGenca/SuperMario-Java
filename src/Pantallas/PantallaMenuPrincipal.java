package Pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



public class PantallaMenuPrincipal extends JPanel implements Pantalla {
    CentralPantallas miCentral;

    public PantallaMenuPrincipal(CentralPantallas mi_central) {
        miCentral = mi_central;
    }

    public void crearPantalla(int w, int h) {
	    setLayout(new GridBagLayout());
	    setSize(new Dimension(w,h));
	    setBackground(new Color(0, 0, 0, 120));
	}

    public void agregarComponentes() {
        JLabel titleLabel = new JLabel("Super Mario Bros - Comision 15", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36)); // Increase the font size
        add(titleLabel, BorderLayout.NORTH);

        // Create the button panel with a GridLayout to arrange buttons side by side
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 20, 10)); // 1 row, 2 columns, 20px gap

        // Create two buttons
        JButton startButton = new JButton("Start Game");
        JButton exitButton = new JButton("Exit");

        // Set smaller preferred sizes for the buttons
        startButton.setPreferredSize(new Dimension(150, 50));
        exitButton.setPreferredSize(new Dimension(150, 50));

        buttonPanel.add(startButton);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.CENTER);
	}

    public void setVisibilidad(boolean vis) {
        setVisible(vis);
    }

    public void refrescar() {
        this.repaint();
        this.revalidate();
    }
    
    private JButton crearBotonConImagen(String imagePath) {
        // Load the image and create an ImageIcon
        ImageIcon icono_imagen = new ImageIcon(this.getClass().getResource(imagePath));
		Image imagen_escalada = icono_imagen.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		Icon icono_imagen_escalado = new ImageIcon(imagen_escalada);

        // Create a JButton with the ImageIcon
        JButton boton = new JButton(icono_imagen_escalado);

        // Set the size of the button based on the size of the image
        boton.setSize(icono_imagen_escalado.getIconWidth(), icono_imagen_escalado.getIconHeight());
		boton.setOpaque(false);
		boton.setContentAreaFilled(false);
		boton.setFocusable(false);
		boton.setBorderPainted(false);
		boton.setRolloverEnabled(false);
		boton.setBackground(new Color(0,0,0,0));

        return boton;
    }
}