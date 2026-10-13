package Logica;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ManejadorDeSonidos {
    
    protected final Map<Integer, Clip> sonidos;
    protected final Map<Integer, Integer> posicionesPausadas;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public ManejadorDeSonidos() {
        sonidos = new HashMap<>();
        posicionesPausadas = new HashMap<>();
        cargarSonido(ConstantesSonidos.VIDA, "src/Sonidos/1up.wav");
        cargarSonido(ConstantesSonidos.MONEDA, "src/Sonidos/Coin.wav");
        cargarSonido(ConstantesSonidos.BOLAFUEGO, "src/Sonidos/fireball.wav");
        cargarSonido(ConstantesSonidos.SALTAR, "src/Sonidos/Jump.wav");
        cargarSonido(ConstantesSonidos.MATAR, "src/Sonidos/Kick.wav");
        cargarSonido(ConstantesSonidos.DANIOMARIO, "src/Sonidos/pipe.wav");
        cargarSonido(ConstantesSonidos.POWERUP, "src/Sonidos/powerup.wav");
        cargarSonido(ConstantesSonidos.MUERTEMARIO, "src/Sonidos/Die.wav");
        cargarSonido(ConstantesSonidos.ROMPERPLATAFORMA, "src/Sonidos/Break.wav");
        cargarSonido(ConstantesSonidos.MUSICALVL1, "src/Sonidos/Overworld1.wav");
        cargarSonido(ConstantesSonidos.MUSICALVL2, "src/Sonidos/Overworld2.wav");
        cargarSonido(ConstantesSonidos.MUSICALVL3, "src/Sonidos/Overworld3.wav");
        cargarSonido(ConstantesSonidos.MENUPRINCIPAL, "src/Sonidos/MenuPrincipal.wav");
        cargarSonido(ConstantesSonidos.INICIOJUEGO, "src/Sonidos/HereWeGo.wav");
        cargarSonido(ConstantesSonidos.ESTRELLA, "src/Sonidos/MarioEstrella.wav");
        cargarSonido(ConstantesSonidos.PASARNIVEL, "src/Sonidos/LevelClear.wav");
        cargarSonido(ConstantesSonidos.GAMEOVER, "src/Sonidos/Game Over.wav");
    }

    public void cargarSonido(int nombre, String rutaArchivo) {
        try {
            File archivoSonido = new File(rutaArchivo);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            sonidos.put(nombre, clip);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println(e.getMessage());
        }
    }

    public void reproducirSonido(int  nombre) {
        Clip clip = sonidos.get(nombre);
        if (clip != null) {
            clip.setFramePosition(0); // Reinicia el clip
            clip.start();
        }
    }

    public void detenerSonido(int nombre) {
        Clip clip = sonidos.get(nombre);
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public void pausarSonido(int nombre) {
        Clip clip = sonidos.get(nombre);
        if (clip != null && clip.isRunning()) {
            posicionesPausadas.put(nombre, clip.getFramePosition());
            clip.stop();
        }
    }


    public void reanudarSonido(int nombre) {
        Clip clip = sonidos.get(nombre);
        Integer posicion = posicionesPausadas.get(nombre);
        if (clip != null && posicion != null) {
            clip.setFramePosition(posicion);
            clip.start();
        }
    }
}