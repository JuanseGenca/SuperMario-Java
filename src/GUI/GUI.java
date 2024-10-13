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

import Entidades.EntidadLogica;

public class GUI  extends JFrame {
    
    protected JFrame ventana;
    protected PanelPantallaPrincipal panelPantallaPrincipal;
	protected PanelPantallaCarrera panelPantallaCarrera;
    protected Logica miLogica;
    //protected Sonido miSonido;
    
    protected static final int ARRIBA = 15000;
    protected static final int ABAJO = 15001;
    protected static final int IZQUIERDA = 15002;
    protected static final int DERECHA = 15003;
    

    public GUI(Logica miLogica) {
        this.miLogica = miLogica;
        this.panelPantallaPrincipal = new PanelPantallaPrincipal(this);
        this.panelPantallaCarrera = new panelPantallaCarrera;
        configurarVentana();
        registrarOyenteVentana();
        
    }

    private void configurarVentana() {
        ventana = new JFrame("TdP :: Mini Road Fighter");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setSize(ConstantesVistas.VENTANA_ANCHO, ConstantesVistas.VENTANA_ALTO);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);

    }

    protected void registrarOyenteVentana(){

    }
   
    public void mostrarPantallaInicial() {
		ventana.setContentPane(panelPantallaPrincipal);
		refrescar();
	}

    public void accionariniciojuego() {
		miLogica.iniciar();
	}
	
    public void accionarPantallaPuntajes() {
		// To Do
	}

    public void accionarPantallaModoJuego() {
		// To Do
	}

    public void cambiar_modo_juego(int modo) {
		// To Do
		mostrarPantallaInicial();
	}

    public Observer registrar_entidad(EntidadLogica entidad_logica) {
		Observer observer_entidad = panelPantallaCarrera.incorporar_entidad(entidad_logica);
		refrescar();
		return observer_entidad;
	}
    
    public Observer registrar_entidad(EntidadJugador entidad_jugador) {
		Observer observer_jugador = panelPantallaCarrera.incorporar_entidad_jugador(entidad_jugador);
		refrescar();
		return observer_jugador;
	}

    public Observer registrar_silueta(EntidadLogica silueta) {
		Observer observer_silueta = panelPantallaCarrera.incorporar_silueta(silueta);
		refrescar();
		return observer_silueta;
	}

    public void mostrarPantallaCarrera() {
		ventana.setContentPane(panelPantallaCarrera);
		refrescar();
	}

    public void mostrar_pantalla_fin_juego() {
		// To Do
	}

    protected void refrescar() {
		ventana.revalidate();
		ventana.repaint();
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

    

}
