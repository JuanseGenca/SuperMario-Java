package Paneles;

import javax.swing.JPanel;
import GUI.GUI;
import Logica.Logica;

public class CentralPaneles {
    protected JPanel panelPrincipal;
    protected GUI miGUI;
    protected PanelScore miPanelScore;
    protected PanelObjetivo miPanelObjetivo;
	protected PanelVidas miPanelVidas;
	protected PanelMovimiento miPanelMovimiento;
	protected PanelReglas miPanelReglas;
	protected PanelTimer miPanelTimer;
	protected Logica miLogica;

    public CentralPaneles(GUI mi_GUI, Logica mi_logica) {
        miGUI = mi_GUI;
		miLogica = mi_logica;
    }


    public void mostrarPanelScore() {
        miPanelScore = new PanelScore(this);
		miPanelScore.crearPanel();
        miPanelScore.agregarAJFrame();
    }

	public void actualizarScore(int score) {
		miPanelScore.actualizarScore(score);
	}

	public int getScore() {
		miLogica.getPuntaje();
	}

	public void mostrarPanelCamara() {
        PanelCamara miPanelCamara = new PanelCamara(this); //TODO: implementar PanelCamara
		miPanelCamara.crearPanel();
        miPanelCamara.agregarAJFrame();
    }



	public void mostrarPanelTimer() {
        miPanelTimer = new PanelTimer(this);
		miPanelTimer.crearPanel();
        miPanelTimer.agregarAJFrame();
    }

	public void actualizarTimer(int tiempo) {
		miPanelTimer.actualizarTimer(tiempo);
	}

	public int getTiempoRestante() {
		return miLogica.getTiempoRestante();
	}

	public void mostrarPanelVidas() {
        miPanelVidas = new PanelVidas(this);
		miPanelVidas.crearPanel();
        miPanelVidas.agregarAPanelPrincipal();
    }

	public int getVidas() {
		return miGUI.getVidas();
	}

	public void actualizarVidas() {
		miPanelVidas.actualizarVidas();
	}

	public void mostrarPanelMovimiento() {
		miPanelMovimiento = new PanelMovimiento(this);
		miPanelMovimiento.crearPanel();
        miPanelMovimiento.agregarAPanelPrincipal();	
	}

	public void actualizarMovimientos(int movimientosRestantes) {
		miPanelMovimiento.actualizarMovimientos(movimientosRestantes);
	}

	public int getCantidadDeMovimientos() {
		return miGUI.getMovimientos();
	}

    public void mostrarPanelObjetivo() {
        miPanelObjetivo = new PanelObjetivo(this);
		miPanelObjetivo.crearPanel();
        miPanelObjetivo.mostrarObjetivos();
        miPanelObjetivo.agregarAPanelPrincipal();
    }

    public int getCantidadDeObjetivos() {
		return miGUI.getCantidadDeObjetivos();
	}

    public String[] obtenerInfoObjetivos() {
	    return miGUI.obtenerInfoObjetivos();
	}

    public void actualizarProgreso(int gemasRestantes, int tipoGema) {
        miPanelObjetivo.actualizarProgreso(gemasRestantes, tipoGema);
    }

    public void reiniciarProgresoObjetivos() {
        miPanelObjetivo.reiniciarProgreso();
    }

	public void agregarConGBCs(Component componenteAAgregar, GridBagConstraints gbc, int gridx, int gridy, int gridwidth,int gridheight) {
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.gridwidth = gridwidth;
		gbc.gridheight = gridheight;

		panelPrincipal.add(componenteAAgregar,gbc);
	}

    public void agregarConGBCs(Component componenteAAgregar, JPanel panelAAgregar, GridBagConstraints gbc, int gridx, int gridy, int gridwidth,int gridheight) {
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.gridwidth = gridwidth;
		gbc.gridheight = gridheight;

		panelAAgregar.add(componenteAAgregar,gbc);
	}

    public JLabel crearLabel(String texto, int tamañoFuente) {
	    JLabel label = new JLabel(texto);
	    label.setFont(new Font("Algerian", Font.PLAIN, tamañoFuente));
	    label.setForeground(Color.WHITE);
	    return label;
	}

	public JLabel crearLabelConColor(String texto, String fuente, int estilo, int tamano, Color color, int gridwidth, int gridheight) {
	    JLabel label = new JLabel(texto);
	    label.setFont(new Font(fuente, estilo, tamano));
	    label.setForeground(color);

	    GridBagConstraints c = new GridBagConstraints();
	    c.insets = new Insets(0, 20, 0, 0);
	    c.weightx = 0;
	    c.gridwidth = gridwidth;
	    c.gridheight = gridheight;

	    return label;
	}

    public JLabel crearImagen(String ruta) {
	    ImageIcon imgIcon = new ImageIcon(this.getClass().getResource(ruta));
	    Image imgEscalada = imgIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	    Icon iconoEscalado = new ImageIcon(imgEscalada);

	    JLabel label = new JLabel();
	    label.setIcon(iconoEscalado);

	    return label;
	}
}