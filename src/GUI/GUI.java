package GUI;

import Logica.*;
import Paneles.CentralPaneles;
import Pantallas.CentralPantallas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class GUI  extends JFrame {
    protected CentralPaneles miCentralPaneles;
    protected CentralPantallas miCentralPantallas; 
    protected Logica miLogica;
    //protected Sonido miSonido;
    protected NivelGrafico miNivelGrafico;
    protected static final int ARRIBA = 15000;
    protected static final int ABAJO = 15001;
    protected static final int IZQUIERDA = 15002;
    protected static final int DERECHA = 15003;
    private List<Sprite> sprites = new ArrayList<>();

    public GUI(Logica mi_logica) {
        miLogica = mi_logica;
        
        inicializarGUI();
    }

    private void inicializarGUI() {
        miCentralPaneles = new CentralPaneles(this, miLogica);
        miCentralPantallas = new CentralPantallas(this, miLogica);

        setearJFrame();

        miCentralPantallas.mostrarMenuPrincipal();
    }

    private void setearJFrame() {
        setTitle("Proyecto Super Mario Bros - Comision 15");
		setSize(1200,800);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void agregarSprite(BufferedImage imagen, int posX, int posY) {
        Sprite sprite = new Sprite(imagen, posX, posY);
        sprites.add(sprite);
        repaint();
    }
    //Replantear donde se almacenan los sprites por el tema de nivel grafico
    public void eliminarSprite(BufferedImage sprite) {
        for (Sprite spr : sprites) {
            if (spr.getImagen() == sprite) {
                sprites.remove(spr);
                break;
            }
        }
        repaint();
    }

    public void inicializarPaneles() {
        miCentralPaneles.mostrarPanelScore();
        miCentralPaneles.mostrarPanelCamara();
        miCentralPaneles.mostrarPanelTimer();
        miCentralPaneles.mostrarPanelVidas();
    }

    public void mostrarMenuPrincipal() {
        miCentralPantallas.mostrarMenuPrincipal();
    }

    public void mostrarPantallaVictoria() {
        miCentralPantallas.mostrarPantallaVictoria();
    }
 
    public void mostrarPantallaSigNivel() {
        miCentralPantallas.mostrarPantallaSigNivel();
    }

    public void mostrarPantallaTopScore() {
        miCentralPantallas.mostrarPantallaTopScore();
    }

    public void mostrarPantallaVidaPerdida() {
        miCentralPantallas.mostrarPantallaVidaPerdida();
    }

    public void limpiarGUI() {
        miNivelGrafico.limpiarNivel();
        miCentralPaneles.limpiarPaneles();
        miCentralPantallas.limpiarPantallas();
    }

    public void inicializarNivel() {
        miNivelGrafico.inicializarNivel();
    }
    public void resetear() {
        this.limpiarGUI();
        this.inicializarGUI();
        this.inicializarNivel();
        this.inicializarPaneles();
    }

    public void inicializarTeclado() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT -> miLogica.establecerDireccionMario(IZQUIERDA);
                    case KeyEvent.VK_RIGHT -> miLogica.establecerDireccionMario(DERECHA);
                    case KeyEvent.VK_UP -> miLogica.establecerDireccionMario(ARRIBA);
                    case KeyEvent.VK_SPACE -> miLogica.dispararJugador();
                }
            }
        });
    }

    public void actualizarEntidad(Sprite entidad) {
        miNivelGrafico.actualizar(entidad);
    }

    public void actualizarVidas() {
        miCentralPaneles.actualizarVidas();
    }
}
