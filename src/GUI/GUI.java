package GUI;

import Logica.Logica;
import Paneles.CentralPaneles;
import Pantallas.CentralPantallas;
import javax.swing.JFrame;

public class GUI  extends JFrame {
    protected CentralPaneles miCentralPaneles;
    protected CentralPantallas miCentralPantallas; 
    protected Logica miLogica;
    //protected Sonido miSonido;
    //protected PositionList<Sprites> sprites;
    //protected NivelGrafico miNivelGrafico;
    protected KeyListener keyListener;

    public static final int ARRIBA = 15000;
    public static final int ABAJO = 15001;
    public static final int IZQUIERDA = 15002;
    public static final int DERECHA = 15003;


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



}
