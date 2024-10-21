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
    protected Nivel nivelActual;
	protected HiloMario hilo1;
	protected HiloSecundario hilo2;
	protected HiloPrincipal hiloPrincipal;
    

    //Constructor
    public Logica() {
        fabricaSprites = new SpritesMarioModo1();
		fabricaEntidades = new EntidadesFactory(fabricaSprites);
        parseint = new Parserint(1,fabricaEntidades);
        parseint = new Parserint(1,fabricaEntidades);
		vidas = 3;
    }
   
    public void setControladorVistas(GUI controladorVistas) {
		gui = controladorVistas;
	}


    public void iniciar() {
		if (vidas == 0){
			vidas = 3;
		}
		nivelActual = parseint.generarNivel(1);
		nivelActual.getMario().setLogica(this);
		registrarObservers();
		gui.mostrarPantallaJuego();
		hilo1 = new HiloMario(nivelActual.getMario(),gui,this);
		hilo1.start();
		hilo2 = new HiloSecundario(gui,this);
		hilo2.start();
		hiloPrincipal = new HiloPrincipal(gui,this);
		hiloPrincipal.start();
		
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

	public int getMarioPosicionY() {
		return nivelActual.getMario().getPosicionY();
	}

	public int getMarioEstadoAereo() {
		return nivelActual.getMario().getEstadoAereo();
	}

	public void setMarioEstadoAereo(int estado) {
		nivelActual.getMario().establecerEstadoAereo(estado);
	}

	public void actualizarVelocidadXMario() {
		nivelActual.getMario().actualizarVelocidadXMario();
	}

	public void actualizarVelocidadYMario() {
		nivelActual.getMario().actualizarVelocidadYMario();
	}

	public void setMarioVelocidadX(double velocidad) {
		nivelActual.getMario().setVelocidadX(velocidad);
	}

	public double getMarioVelocidadX() {
		return nivelActual.getMario().getVelocidadX();
	}

	public void setMarioVelocidadY(double velocidad) {
		nivelActual.getMario().setVelocidadY(velocidad);
	}

	public double getMarioVelocidadY() {
		return nivelActual.getMario().getVelocidadY();
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

	public void aniadirMoneda() {
        monedas++;
        if(monedas==100) {
        	actualizarVida(1);
            monedas=0;
        }
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

	//esta incompleto
	public void reiniciarNivel(){
		vidas--;
		hilo1.parar();
		hilo2.parar();
		hiloPrincipal.parar();
		if (vidas == 0){
			gui.mostrarPantallaInicial();
		}else{
			gui.accionarInicioJuego();
		}
	}
}	