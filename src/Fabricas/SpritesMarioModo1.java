package Fabricas;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import GUI.Spritesheet;

public class SpritesMarioModo1 implements SpriteFactory {
    public SpritesMarioModo1(){

    }

    public BufferedImage[] crearSpriteChampinionVerde(){
        Spritesheet spritesheetEntidad = new Spritesheet("assets/PowerUps/champinion_verde.png");

        return subdividirSpritesheet(1,1, spritesheetEntidad);
    }
    
    public BufferedImage[] crearSpriteSuperChampinion(){
        Spritesheet spritesheetEntidad = new Spritesheet("assets/PowerUps/super_champinion.png");

        return subdividirSpritesheet(1,1, spritesheetEntidad);
    }

    public BufferedImage[] crearSpriteFlorDeFuego(){
        Spritesheet spritesheetEntidad = new Spritesheet("assets/PowerUps/flor_de_fuego.png");

        return subdividirSpritesheet(4,1, spritesheetEntidad);
    }

    public BufferedImage[] crearSpriteMoneda(){
        Spritesheet spritesheetEntidad = new Spritesheet("assets/PowerUps/moneda.png");

        return subdividirSpritesheet(4,1, spritesheetEntidad);
    }

    public BufferedImage[] crearSpriteEstrella(){
        Spritesheet spritesheetEntidad = new Spritesheet("assets/PowerUps/estrella.png");

        return subdividirSpritesheet(4,1, spritesheetEntidad);
    }

    public BufferedImage[] crearSpriteMario(){
        Spritesheet spritesheetEntidad = new Spritesheet("assets/Mario.png");

        return subdividirSpritesheet(1, spritesheetEntidad);
    }

    public BufferedImage[] crearSpriteBuzzyBeetle(){
        Spritesheet spritesheetEntidad = new Spritesheet("assets/Enemigos/buzzy_beetle.png");

        return subdividirSpritesheet(3,1, spritesheetEntidad);
    }
    
    public BufferedImage[] crearSpriteSpiny(){
        Spritesheet spritesheetEntidad = new Spritesheet("assets/Enemigos/spiny.png");

        return subdividirSpritesheet(1,2, spritesheetEntidad);
    }

    public BufferedImage[] crearSpriteLakitu(){
        Spritesheet spritesheetEntidad = new Spritesheet("assets/Enemigos/lakitu.png");

        return subdividirSpritesheet(2, 1,spritesheetEntidad);
    }

    public BufferedImage[] crearSpriteGoomba(){
        Spritesheet spritesheetEntidad = new Spritesheet("assets/Enemigos/goomba.png");

        return subdividirSpritesheet(3, 1,spritesheetEntidad);
    }

    public BufferedImage[] crearSpritePiranhaPlant(){
        Spritesheet spritesheetEntidad = new Spritesheet("assets/Enemigos/piranha_plant.png");

        return subdividirSpritesheet(2, 1,spritesheetEntidad);
    }

    public BufferedImage[] crearSpriteKoopaTroopa(){
        Spritesheet spritesheetEntidad = new Spritesheet("assets/Enemigos/koopa_troopa.png");

        return subdividirSpritesheet(4, 1,spritesheetEntidad);
    }

    public BufferedImage[] crearSpriteBloqueSolido(){
        Spritesheet spritesheetEntidad = new Spritesheet("assets/Plataforma/bloque_ladrillo.png");

        return subdividirSpritesheet(3, 1,spritesheetEntidad);
    }

    public BufferedImage[] crearSpriteTuberia(){

    }

    public BufferedImage[] crearSpriteMeta(){
        Spritesheet spritesheetEntidad = new Spritesheet("assets/Plataforma/meta.png");

        return subdividirSpritesheet(2, 1,spritesheetEntidad);
    }

    public BufferedImage[] crearSpriteVacio(){

    }

    public BufferedImage[] crearSpriteLadrilloRompible(){
        Spritesheet spritesheetEntidad = new Spritesheet("assets/Plataforma/bloque_ladrillo.png");

        return subdividirSpritesheet(3, 1,spritesheetEntidad);
    }

    public BufferedImage[] crearSpriteBloquePregunta(){
        Spritesheet spritesheetEntidad = new Spritesheet("assets/Plataforma/bloque_pregunta.png");

        return subdividirSpritesheet(4, 1,spritesheetEntidad);
    }

    private BufferedImage[] subdividirSpritesheet(int cantX, int cantY, Spritesheet spritesheetEntidad) {
        BufferedImage[] sprites = new BufferedImage[cantX*cantY];

        for (int i = 0; i < cantX*cantY; i++) {
            sprites[i] = spritesheetEntidad.getSprite(i-1, cantY-1, spritesheetEntidad.getWidth(), spritesheetEntidad.getHeight());
        }

        return sprites;
    }
    
}
