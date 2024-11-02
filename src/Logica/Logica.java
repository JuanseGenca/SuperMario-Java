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
import PowerUps.PowerUp;
import java.awt.event.ActionEvent;
import static java.lang.Thread.sleep;
import java.util.List;
import javax.swing.Timer;


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
	protected HiloSecundario hilo2;
	protected HiloPrincipal hiloPrincipal;
	protected ManejadorDeSonidos manejadorDeSonidos;
    

    //Constructor
    public Logica() {
        fabricaSprites = new SpritesMarioModo1();
		fabricaEntidades = new EntidadesFactory(fabricaSprites);
		manejadorDeSonidos = new ManejadorDeSonidos();
        parseint = new Parserint(1,fabricaEntidades,this);
        parseint = new Parserint(2,fabricaEntidades,this);
		parseint = new Parserint(3,fabricaEntidades,this);
		lvl=1;
		vidas = 3;
    }

	public void actualizarSprites(SpriteFactory factory){
		fabricaSprites = factory;
		actualizarFabricaEntidades();
	}

	private void actualizarFabricaEntidades(){
		fabricaEntidades.setFabricaSprites(fabricaSprites);
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
		hilo2 = new HiloSecundario(this);
		hilo2.start();
		hiloPrincipal = new HiloPrincipal(this,nivelActual.getMario());
		hiloPrincipal.start();
		manejadorDeSonidos.reproducirSonido(nivelActual.getNumeroNivel());
		nivelActual.iniciarTimerLakitus();	
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
		reproducirSonido(ConstantesSonidos.SALTAR);
		nivelActual.getMario().establecerEstadoAereo(estado);
	}

    public void shootMario() {
        nivelActual.getMario().disparar();
    }

	public List<Enemigo> getEnemigos(){
		return nivelActual.getEnemigos();
	}

	public List<PowerUp> getPowerUps(){
		return nivelActual.getPowerUps();
	}

	public void actualizarVida(int i) {
		vidas = vidas + i;
	}

	public void reproducirSonido(int nombre) {
		manejadorDeSonidos.reproducirSonido(nombre);
	}

	public void detenerSonido(int  nombre) {
		manejadorDeSonidos.detenerSonido(nombre);
	}

	public void pausarSonido(int nombre) {
		manejadorDeSonidos.pausarSonido(nombre);
	}

	public void reanudarSonido(int nombre) {
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
		hilo2.parar();
		hiloPrincipal.parar();
		nivelActual.frenarTimerLakitus();
		if (vidas == 0){
			perdio();	
		}else{
			gui.accionarInicioJuego();
		}
	}

	public void siguienteNivel() {
		manejadorDeSonidos.detenerSonido(nivelActual.getNumeroNivel());
		manejadorDeSonidos.detenerSonido(ConstantesSonidos.ESTRELLA);
		manejadorDeSonidos.reproducirSonido(ConstantesSonidos.PASARNIVEL);
		nivelActual.frenarTimerLakitus();
		hilo2.parar();
		hiloPrincipal.parar();

		Timer timer = new Timer(8000, (ActionEvent e) -> {
			
			if(lvl!=3){
				lvl++;
				manejadorDeSonidos.detenerSonido(ConstantesSonidos.PASARNIVEL);
				gui.accionarInicioJuego();
				}
				else{
					gui.mostrarPantallaVictoria();
					if (gui.top5()) {
							reiniciarJuego();
						   gui.mostrarPantallaInicial();
						}
				}	
        });

		timer.setRepeats(false);
        timer.start();		
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
	    manejadorDeSonidos.pausarSonido(nivelActual.getNumeroNivel());
	    manejadorDeSonidos.reproducirSonido(ConstantesSonidos.GAMEOVER);
	    gui.mostrarPantallaFinJuego();
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	    
	    if (gui.top5()) {    
			manejadorDeSonidos.pausarSonido(nivelActual.getNumeroNivel());
			reiniciarJuego();
	        gui.mostrarPantallaInicial();
	    }

	}
	
	public void reiniciarJuego() {
		vidas=3;
		puntaje=0;
		monedas=0;
	}
}