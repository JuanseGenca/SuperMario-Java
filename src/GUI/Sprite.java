package GUI;
import java.awt.image.BufferedImage;

public class Sprite {

    public Spritesheet sheet;
    public BufferedImage spriteActual;
    public int width, height;

    public Sprite(Spritesheet sheet, int x, int y) {
        spriteActual = sheet.getSprite(x, y, width, height);
    }

    public BufferedImage getSprite() {
        return spriteActual;
    }
}