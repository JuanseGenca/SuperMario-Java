package GUI;

import Entidades.EntidadJugador;
import Entidades.EntidadLogica;
import Logica.*;
import Paneles.*;
import Puntaje.AdministradorPuntaje;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class GUI implements ControladorDeVistas, ControladorEntreJuegoVista {

    protected JFrame ventana;
    protected PanelPantallaPrincipal panelPantallaPrincipal;
    protected PanelPantallaJuego panelPantallaJuego;
    protected PanelPantallaFinDeJuego panelPantallaFinDeJuego;
    protected PanelVictoria panelVictoria;
    protected PanelPantallaPuntajes panelPantallaPuntaje;
    protected Logica miLogica;
    protected AdministradorPuntaje administradorPuntaje;
    protected PanelModoDeJuego panelModo;


    public GUI(Logica miLogica) {
        this.miLogica = miLogica;
        this.panelPantallaPrincipal = new PanelPantallaPrincipal(this);
        this.panelPantallaJuego = new PanelPantallaJuego(this);
        this.panelPantallaFinDeJuego = new PanelPantallaFinDeJuego(this);
        this.panelVictoria = new PanelVictoria(this);
        this.administradorPuntaje=new AdministradorPuntaje();
        this.panelModo = new PanelModoDeJuego(this);
        configurarVentana();
        
        registrarOyenteVentana();
    }

    private void configurarVentana() {
        ventana = new JFrame("Super Mario Bros TDP 15");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setSize(ConstantesVistas.VENTANA_ANCHO, ConstantesVistas.VENTANA_ALTO);
        ventana.setLocationRelativeTo(null);
        Image icono=null;
        try {
            icono = ImageIO.read(new File("src//Imagenes//Icono.jpg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        ventana.setIconImage(icono);
        ventana.setVisible(true);
        
        miLogica.reproducirSonido(ConstantesSonidos.MENUPRINCIPAL);
    }

    protected void registrarOyenteVentana() {
        addWindowKeyListener();
    }

    private void addWindowKeyListener() {
        ventana.addKeyListener(new KeyAdapter() {
            
            public void keyPressed(KeyEvent event) {

                int keyCode = event.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_A:
                        miLogica.setMarioDirection(ConstantesEntidades.IZQUIERDA);
                        break;
                    case KeyEvent.VK_D:
                        miLogica.setMarioDirection(ConstantesEntidades.DERECHA);
                        break;
                    case KeyEvent.VK_W:
                        miLogica.setMarioEstadoAereo(ConstantesEntidades.AIRE);
                        break;
                    case KeyEvent.VK_SPACE:
                        miLogica.shootMario();
                        break;
                    default:
                        break;
                }
            }

            public void keyReleased(KeyEvent event) {
                int keyCode = event.getKeyCode();

                if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_D) {
                    miLogica.setMarioDirection(ConstantesEntidades.QUIETO);
                }
                }
            }
        );
    }

    public void mostrarPantallaInicial() {
        ventana.setContentPane(panelPantallaPrincipal);
        refrescar();
    }

    public void reiniciarNivel(){
        miLogica.reiniciarNivel();
    }

    public Logica getLogica(){
        return miLogica;
    }

    public void accionarInicioJuego() {
        PanelPantallaInicioNivel panelInicioDeNivel = new PanelPantallaInicioNivel(this);
        ventana.setContentPane(panelInicioDeNivel);
        refrescar();
        Timer timer = new Timer(4000, (ActionEvent e) -> {
        panelPantallaJuego = new PanelPantallaJuego(GUI.this);
        ventana.setContentPane(panelPantallaJuego);
        miLogica.iniciarNivel();
        refrescar();
        ventana.requestFocusInWindow();
        });

        // Ensure the timer runs only once
        timer.setRepeats(false);
        timer.start();
    }

    public void accionarPantallaPuntajes() {
        PanelPantallaPuntajes panelPantallaPuntajes = new PanelPantallaPuntajes(this, administradorPuntaje.obtenerArrayNombresJugadores(), administradorPuntaje.obtenerArrayScoreJugadores());
        ventana.setContentPane(panelPantallaPuntajes);
        refrescar();
    }

    public Observer registrarEntidad(EntidadLogica entidadLogica) {
        Observer observerEntidad = panelPantallaJuego.incorporarEntidad(entidadLogica);
        refrescar();
        return observerEntidad;
    }

    public Observer registrarEntidad(EntidadJugador entidad) {
        Observer observerJugador = panelPantallaJuego.incorporarEntidadJugador(entidad);
        refrescar();
        return observerJugador;
    }

    public Observer registrarSilueta(EntidadLogica silueta) {
        Observer observer_silueta = panelPantallaJuego.incorporarSilueta(silueta);
        refrescar();
        return observer_silueta;
    }

    public void EliminarEntidad(ObserverEntidades observerEntidades){
        panelPantallaJuego.eliminarEntidad(observerEntidades);
    }

    public void mostrarPantallaJuego() {
        ventana.setContentPane(panelPantallaJuego);
        ventana.requestFocusInWindow();
        refrescar();
    }

    public void mostrarPantallaFinJuego() {
        ventana.setContentPane(panelPantallaFinDeJuego);
        refrescar();
    }

    public void mostrarPantallaPuntaje() {
        ventana.setContentPane(panelPantallaPuntaje);
        refrescar();
    }

    public void refrescar() {
        ventana.revalidate();
        ventana.repaint();
    
    }

    public void reproducirSonido(int nombre) {
        miLogica.reproducirSonido(nombre);
    }

    public void detenerSonido(int nombre) {
        miLogica.detenerSonido(nombre);
    }

    public int getVidas() {
       return miLogica.getVidas();
    }

    public int getNivel() {
        int lvl=1;
        if(miLogica.getNivel()!=null){lvl=miLogica.getNumeroNivel();}
        return lvl;
    }

    public void mostrarPantallaVictoria() {
        ventana.setContentPane(panelVictoria);
        ventana.requestFocusInWindow();
        refrescar();
        
    }
    public void mostrarPantallaModoDeJuego(){
        miLogica.detenerSonido(ConstantesSonidos.MENUPRINCIPAL);
        ventana.setContentPane(panelModo);
        ventana.requestFocusInWindow();
        refrescar();
    }

    public boolean top5() {
        administradorPuntaje.agregarScore(miLogica.getPuntaje());
        if (administradorPuntaje.entro_en_el_top5()) {
            boolean inputValido = false;
            String input = null;

            while (!inputValido) {
                JPanel panel = new JPanel();
                JLabel label = new JLabel("Ingrese 5 dígitos:");
                JTextField textField = new JTextField(5);
                panel.add(label);
                panel.add(textField);

                int result = JOptionPane.showConfirmDialog(ventana, panel, "Top 5", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {
                    input = textField.getText();
                    
                    // Validar que la entrada tenga exactamente 5 dígitos
                    if (input != null && input.matches(".{5}")) {
                        inputValido = true;
                    } else {
                        JOptionPane.showMessageDialog(ventana, "Entrada inválida. Por favor, ingrese exactamente 5 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    // Si el usuario cancela, salir del bucle
                    break;
                }
            }

            if (inputValido) {
                administradorPuntaje.mejorJugador(input);
                return true;
            } else {
                return false;
            }
        }
        return true; // Si no entra en el top 5, consideramos la operación exitosa
    }
}
