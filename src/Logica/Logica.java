package Logica;

import Enemigos.Enemigo;
import Entidades.BolaDeFuego;
import Entidades.Entidad;
import Entidades.Mario;
import Fabricas.*;
import GUI.GUI;
import GUI.Observer;
import Nivel.Nivel;
import ParseInt.Parserint;
import Plataformas.Plataforma;
import PowerUps.PowerUp;
import java.util.List;

public class Logica {
    //Atributos de instancia

    protected Parserint parseint;
    protected EntidadesFactory fabricaEntidades;
    protected SpriteFactory fabricaSprites;
    protected GUI gui;
    protected Nivel nivelActual;
    

    //Constructor
    public Logica() {
        fabricaSprites = new SpritesMarioModo1();
		fabricaEntidades = new EntidadesFactory(fabricaSprites);
        parseint = new Parserint(fabricaEntidades);
       
    }
   
    public void setControladorVistas(GUI controladorVistas) {
		gui = controladorVistas;
	}


    public void iniciar() {
		nivelActual = parseint.generar_ruta_harcoding(1);
		registrarObservers();
		gui.mostrarPantallaCarrera();
	}

    protected void registrarObservers() {
		registrarObserverJugador(nivelActual.getMario());
		registrar_observer_silueta(nivelActual.getSilueta());
		registrarObserversParaEntidades(nivelActual.getPowerUps());
		registrarObserversParaEntidades(nivelActual.getEnemigos());
		registrarObserversParaEntidades(nivelActual.getPlataformas());
	}
	
	protected void registrarObserverJugador(Mario jugador) {
		Observer observerJugador = gui.registrarEntidadJugador(jugador);
		jugador.setObserver(observerJugador);
	}

	protected void registrarObserverSilueta(Silueta siluetaRuta) {
		Observer observer = gui.registrarSilueta(siluetaRuta);
		siluetaRuta.registrarObserver(observer);
	}
	
	protected void registrarObserversParaEntidades(List<? extends Entidad> entidades) {
		for(Entidad entidad : entidades) {
			Observer observer = gui.registrarEntidad(entidad);
			entidad.setObserver(observer);
		}
	}

}