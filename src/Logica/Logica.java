package Logica;

import Enemigos.Enemigo;
import Entidades.BolaDeFuego;
import Entidades.Entidad;
import Entidades.Mario;
import Fabricas.*;
import GUI.GUI;
import GUI.Observer;
import Nivel.Nivel;
import Nivel.Silueta;
import ParseInt.Parserint;
import static java.lang.Thread.sleep;
import java.util.List;

//La clase tiene como 800 metodos de mario, hay que ver cuales se pueden eliminar


public class Logica {
    //Atributos de instancia

    protected Parserint parseint;
    protected EntidadesFactory fabricaEntidades;
    protected SpriteFactory fabricaSprites;
    protected GUI gui;
	protected int vidas;
	protected int monedas;
	protected int puntaje;
	protected int lvl;
    protected Nivel nivelActual;
	protected HiloMario hilo1;
	protected HiloSecundario hilo2;
	protected HiloPrincipal hiloPrincipal;
	protected ManejadorDeSonidos manejadorDeSonidos;
    

    //Constructor
    public Logica() {
        fabricaSprites = new SpritesMarioModo1();
		fabricaEntidades = new EntidadesFactory(fabricaSprites);
		manejadorDeSonidos = new ManejadorDeSonidos();
        parseint = new Parserint(1,fabricaEntidades);
        parseint = new Parserint(2,fabricaEntidades);
		parseint = new Parserint(3,fabricaEntidades);
		lvl=1;
		vidas = 3;
    }

	public GUI getGui(){
		return gui;
	}
   
    public void setControladorVistas(GUI controladorVistas) {
		gui = controladorVistas;
	}

    public void iniciarNivel() {
		if (vidas == 0){
			vidas = 3;
			monedas = 0;
			puntaje=0;
		}
		nivelActual = parseint.generarNivel(lvl);
		nivelActual.getMario().setLogica(this);
		registrarObservers();
		gui.mostrarPantallaJuego();
		hilo1 = new HiloMario(nivelActual.getMario(),this);
		hilo1.start();
		hilo2 = new HiloSecundario(this);
		hilo2.start();
		hiloPrincipal = new HiloPrincipal(this);
		hiloPrincipal.start();
		manejadorDeSonidos.reproducirSonido("musicaLvl"+nivelActual.getNumeroNivel());	
	}

    protected void registrarObservers() {
		registrarObserverJugador(nivelActual.getMario());
		registrarObserverSilueta(nivelActual.getSilueta());
		registrarObserverSilueta(nivelActual.getSilueta());
		registrarObserversParaEntidades(nivelActual.getPowerUps());
		registrarObserversParaEntidades(nivelActual.getEnemigos());
		registrarObserversParaEntidades(nivelActual.getPlataformas());
		registrarObserversParaEntidades(nivelActual.getBolaDeFuego());
	}
	
	protected void registrarObserverJugador(Mario jugador) {
		Observer observerJugador = gui.registrarEntidad(jugador);
		jugador.setObserver(observerJugador);
	}

	protected void registrarObserverSilueta(Silueta siluetaRuta) {
		Observer observer = gui.registrarSilueta(siluetaRuta);
		siluetaRuta.setObserver(observer);
		siluetaRuta.setObserver(observer);
	}
	
	protected void registrarObserversParaEntidades(List<? extends Entidad> entidades) {
		for(Entidad entidad : entidades) {
			Observer observer = gui.registrarEntidad(entidad);
			entidad.setObserver(observer);
		}
	}

	public void setMarioDirection(int direccion) {
		nivelActual.getMario().establecerDireccion(direccion);
	}

	public void setMarioEstadoAereo(int estado) {
		reproducirSonido("saltar");
		nivelActual.getMario().establecerEstadoAereo(estado);
	}

    public void shootMario() {
        nivelActual.getMario().disparar();
    }

	public List<Enemigo> getEnemigos(){
		return nivelActual.getEnemigos();
	}

	public void actualizarVida(int i) {
		vidas = vidas + i;
	}

	public void reproducirSonido(String nombre) {
		manejadorDeSonidos.reproducirSonido(nombre);
	}

	public void detenerSonido(String nombre) {
		manejadorDeSonidos.detenerSonido(nombre);
	}

	public void pausarSonido(String nombre) {
		manejadorDeSonidos.pausarSonido(nombre);
	}

	public void reanudarSonido(String nombre) {
		manejadorDeSonidos.reanudarSonido(nombre);
	}

	public void aniadirMoneda() {
        monedas++;
        if(monedas==100) {
        	actualizarVida(1);
            monedas=0;
        }
    }

	public void actualizarPuntaje(int puntaje) {
		this.puntaje = this.puntaje + puntaje;
	}

	public ManejadorDeColisiones getManejadorDeColisiones() {
		return nivelActual.getManejadorDeColisiones();
	}

	public int getVidas() {
		return vidas;
	}

	public int getMonedas(){
		return monedas;
	}
	public List<BolaDeFuego> getBolas(){
		return nivelActual.getBolaDeFuego();
	}

	public void reiniciarNivel(){
		vidas--;
		hilo1.parar();
		hilo2.parar();
		hiloPrincipal.parar();
		if (vidas == 0){
			perdio();	
		}else{
			gui.accionarInicioJuego();
		}
	}

	public void siguienteNivel() {
		manejadorDeSonidos.pausarSonido("musicaLvl"+nivelActual.getNumeroNivel());
		manejadorDeSonidos.reproducirSonido("PasarNivel");
		hilo1.parar();
		hilo2.parar();
		hiloPrincipal.parar();
		if(lvl!=3){
			lvl++;
			gui.accionarInicioJuego();
			}
			else{
				gui.mostrarPantallaVictoria();
				try {
					sleep(5000);
				} catch (InterruptedException e) {
				System.err.println(e.getMessage());
				}
				boolean top5Concretado = gui.top5();
	    		if (top5Concretado) {    
	       			gui.mostrarPantallaInicial();
	   			 }
			}
		//gui.accionarInicioJuego();				
	}

	public int getPuntaje() {
		return puntaje;
	}

	public Nivel getNivel() {
		return nivelActual;
	}

	public int getNumeroNivel(){
		return lvl;
	}

	private void perdio() {
	    manejadorDeSonidos.pausarSonido("musicaLvl" + nivelActual.getNumeroNivel());
	    manejadorDeSonidos.reproducirSonido("GameOver");
	    gui.mostrarPantallaFinJuego();
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	    
	    boolean top5Concretado = gui.top5();
	    
	    if (top5Concretado) {    
	        gui.mostrarPantallaInicial();
	    }
	}
	
}