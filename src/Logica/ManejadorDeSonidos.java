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
    private Map<String, Clip> sonidos;

    public ManejadorDeSonidos() {
        sonidos = new HashMap<>();
        cargarSonido("vida","src\\Sonidos\\1up.wav");
        cargarSonido("moneda","src\\Sonidos\\coin.wav");
        cargarSonido("bolaFuego","src\\Sonidos\\fireball.wav");
        cargarSonido("saltar","src\\Sonidos\\jump.wav");
        cargarSonido("matar","src\\Sonidos\\kick.wav");
        cargarSonido("danioMario","src\\Sonidos\\pipe.wav");
        cargarSonido("powerUp","src\\Sonidos\\powerup.wav");
        cargarSonido("muerteMario","src\\Sonidos\\Die.wav");
        cargarSonido("romperPlataforma","src\\Sonidos\\Break.wav");
        cargarSonido("musicaLvl1","src\\Sonidos\\Overworld1.wav");
        cargarSonido("musicaLvl2","src\\Sonidos\\Overworld2.wav");
        cargarSonido("musicaLvl3","src\\Sonidos\\Overworld3.wav");
        
    }

    public void cargarSonido(String nombre, String rutaArchivo) {
        try {
            File archivoSonido = new File(rutaArchivo);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            sonidos.put(nombre, clip);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void reproducirSonido(String nombre) {
        Clip clip = sonidos.get(nombre);
        if (clip != null) {
            clip.setFramePosition(0); // Reinicia el clip
            clip.start();
        }
    }

    public void detenerSonido(String nombre) {
        Clip clip = sonidos.get(nombre);
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}