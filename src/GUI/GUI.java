package GUI;

import Entidades.EntidadJugador;
import Entidades.EntidadLogica;
import Logica.*;
import Paneles.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class GUI implements ControladorDeVistas, ControladorEntreJuegoVista {

    protected JFrame ventana;
    protected PanelPantallaPrincipal panelPantallaPrincipal;
    protected PanelPantallaCarrera panelPantallaCarrera;
    protected Logica miLogica;
    private boolean isMovingRight = false;
    private boolean isMovingLeft = false;
    //protected Sonido miSonido;

    protected static final int ARRIBA = 15000;
    protected static final int ABAJO = 15001;
    protected static final int IZQUIERDA = 15002;
    protected static final int DERECHA = 15003;
    protected static final int QUIETO = 0;

    public GUI(Logica miLogica) {
        this.miLogica = miLogica;
        this.panelPantallaPrincipal = new PanelPantallaPrincipal(this);
        this.panelPantallaCarrera = new PanelPantallaCarrera();
        configurarVentana();
        registrarOyenteVentana();
    }

    private void configurarVentana() {
        ventana = new JFrame("Super Mario Bros TDP 15");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setSize(ConstantesVistas.VENTANA_ANCHO, ConstantesVistas.VENTANA_ALTO);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    protected void registrarOyenteVentana() {
        addWindowKeyListener();
    }

    private void addWindowKeyListener() {
        ventana.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {

                int keyCode = event.getKeyCode();
                if (keyCode == KeyEvent.VK_A) {
                    isMovingLeft = true;
                    miLogica.setMarioDirection(IZQUIERDA);
                    mover();
                } else if (keyCode == KeyEvent.VK_D) {
                    isMovingRight = true;
                    miLogica.setMarioDirection(DERECHA);
                    mover();
                } else if (keyCode == KeyEvent.VK_W) {
                    miLogica.setMarioDirection(ARRIBA);
                } else if (keyCode == KeyEvent.VK_SPACE) {
                    //miLogica.shootMario();
                }
            }

            @Override
            public void keyReleased(KeyEvent event) {
                int keyCode = event.getKeyCode();
                if (keyCode == KeyEvent.VK_A) {
                    isMovingLeft = false;
                } else if (keyCode == KeyEvent.VK_D) {
                    isMovingRight = false;
                }
                if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_D) {
                    miLogica.setMarioDirection(QUIETO);
                } // Detener el movimiento cuando se suelta la tecla
                }
            }
        );
    }

    private void updateMarioVelocity() {
        double acceleration = 0.5;
        double deceleration = 0.2;
        double maxVelocity = 10;
        double currentVelocity = miLogica.getMarioVelocidad();

        if (isMovingRight) {
            currentVelocity = Math.min(currentVelocity + acceleration, maxVelocity);
        } else if (isMovingLeft) {
            currentVelocity = Math.min(currentVelocity + acceleration, maxVelocity);
        } else {
            if (currentVelocity > 0) {
                currentVelocity = Math.max(currentVelocity - deceleration, 0);
            } else if (currentVelocity < 0) {
                currentVelocity = Math.min(currentVelocity + deceleration, 0);
            }

        }

        miLogica.setMarioVelocidad(currentVelocity);
    }

    
    

    public void mover() {
        updateMarioVelocity();
        refrescar();
    }


    public void mostrarPantallaInicial() {
        ventana.setContentPane(panelPantallaPrincipal);
        refrescar();
    }

    public void accionarInicioJuego() {
        miLogica.iniciar();
    }

    public void accionarPantallaPuntajes() {
        // To Do
    }

    public void accionarPantallaModoJuego() {
        // To Do
    }

    public void cambiarModoJuego(int modo) {
        // To Do
        mostrarPantallaInicial();
    }

    public Observer registrarEntidad(EntidadLogica entidadLogica) {
        Observer observerEntidad = panelPantallaCarrera.incorporarEntidad(entidadLogica);
        refrescar();
        return observerEntidad;
    }

    public Observer registrarEntidad(EntidadJugador entidad) {
        Observer observerJugador = panelPantallaCarrera.incorporarEntidadJugador(entidad);
        refrescar();
        return observerJugador;
    }

    public Observer registrarSilueta(EntidadLogica silueta) {
        Observer observer_silueta = panelPantallaCarrera.incorporarSilueta(silueta);
        refrescar();
        return observer_silueta;
    }

    public void mostrarPantallaCarrera() {
        ventana.setContentPane(panelPantallaCarrera);
        refrescar();
    }

    public void mostrarPantallaFinJuego() {
        // To Do
    }

    protected void refrescar() {
        ventana.revalidate();
        ventana.repaint();
    }
}