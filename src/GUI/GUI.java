package GUI;

import Entidades.Entidad;
import Entidades.EntidadJugador;
import Entidades.EntidadLogica;
import Entidades.Mario;
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
    //protected Sonido miSonido;
    
    protected static final int ARRIBA = 15000;
    protected static final int ABAJO = 15001;
    protected static final int IZQUIERDA = 15002;
    protected static final int DERECHA = 15003;
    

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

    protected void registrarOyenteVentana(){
        addWindowKeyListener();
    }
   
    private void addWindowKeyListener() {
        ventana.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                if (event == null) {
                    return;
                }

                int keyCode = event.getKeyCode();
                if (keyCode == KeyEvent.VK_A) {
                    miLogica.setMarioDirection(IZQUIERDA);
                    System.out.println("Izquierda");
                } else if (keyCode == KeyEvent.VK_D) {
                    miLogica.setMarioDirection(DERECHA);
                    System.err.println("Derecha");
                } else if (keyCode == KeyEvent.VK_W) {
                    miLogica.setMarioDirection(ARRIBA);
                    System.err.println("Arriba");
                } else if (keyCode == KeyEvent.VK_SPACE) {
                    //miLogica.shootMario();
                    System.out.println("Disparar");
                }
            }
        });
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

    /* 
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
    }*/

    

}
