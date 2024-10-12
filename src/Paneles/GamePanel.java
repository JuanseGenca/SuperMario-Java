package Paneles;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel implements ActionListener {
    private Image backgroundImage;
    private int backgroundX; // The x position of the background
    private int marioX;      // The x position of Mario
    private final int SCREEN_WIDTH = 1200; // Width of the game screen
    private final int SCROLL_THRESHOLD = SCREEN_WIDTH / 3; // Midway point for Mario to trigger scrolling
    private Timer timer;

    public GamePanel() {
        try {
            // Load the background image
            backgroundImage = ImageIO.read(new File("./assets/bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        backgroundX = 0; // Start background at x = 0
        marioX = 100;    // Initial Mario position
        timer = new Timer(16, this); // Timer for game loop (60 FPS)
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Get the width of the background image
        int backgroundWidth = backgroundImage.getWidth(null);

        // Draw two instances of the background image, one following the other
        g.drawImage(backgroundImage, backgroundX, 0, this);
        g.drawImage(backgroundImage, backgroundX + backgroundWidth, 0, this);

        // Draw Mario (simplified as a rectangle here for demo purposes)
        g.fillRect(marioX, 575, 50, 50); // Mario's x position, y=500, width=50, height=50
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateGame();
        repaint(); // Repaint the panel to update the graphics
    }

    private void updateGame() {
        // Simulate Mario moving right (you can replace this with actual input logic)
        marioX += 5;

        // Get the width of the background image
        int backgroundWidth = backgroundImage.getWidth(null);

        // If Mario crosses the scrolling threshold, move the background
        if (marioX >= SCROLL_THRESHOLD) {
            backgroundX -= 5; // Move the background left
        }

        // Loop the background when it goes off screen
        if (backgroundX <= -backgroundWidth) {
            backgroundX = 0; // Reset the background position to the start
        }

        // Prevent Mario from moving past the screen width (optional)
        if (marioX > SCREEN_WIDTH/3) {
            marioX = SCREEN_WIDTH/3;
        }
    }
}