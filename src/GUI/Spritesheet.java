package GUI;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Spritesheet {

    private BufferedImage sheet;

    // Constructor que carga la imagen (spritesheet)
    public Spritesheet(String path) {
        try {
            sheet = ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener un sprite con tamaño dinámico
    public BufferedImage getSprite(int x, int y, int width, int height) {
        return sheet.getSubimage(x * width, y * height, width, height);
    }

    public int getWidth() {
        return sheet.getWidth();
    }

    public int getHeight() {
        return sheet.getHeight();
    }
}