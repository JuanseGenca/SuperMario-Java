package GUI;

import javax.swing.JFrame;

import Paneles.GamePanel;


public class Main {
    public static void main(String[] args) {
        // Create the JFrame (window)
        JFrame frame = new JFrame("Los hermanos Marito");

        // Set default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the window
        frame.setSize(1200, 800); 

        // Add an instance of GamePanel to the frame
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);

        frame.setVisible(true);
    }
}