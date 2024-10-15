package Paneles;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class PanelCamara extends JPanel implements Paneles{
   // private CentralPaneles miCentral;
    private Image backgroundImage;
    private int fondoX;
    private final int ANCHO_PANTALLA = 1200;

    public PanelCamara() {
    } 

    public void crearPanel() {
        fondoX = 0;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int backgroundWidth = backgroundImage.getWidth(null);

        g.drawImage(backgroundImage, fondoX, 0, this);
        g.drawImage(backgroundImage, fondoX + backgroundWidth, 0, this);
    }

    public void agregarAJFrame() {
        try {
            backgroundImage = ImageIO.read(new File("./assets/bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        repaint();
    }

    public void actualizarFondo(int marioX) {
        int backgroundWidth = backgroundImage.getWidth(null);

        if (marioX >= ANCHO_PANTALLA) {
            fondoX -= 5;
        }

        if (fondoX <= -backgroundWidth) {
            fondoX = 0;
        }
    }
}
