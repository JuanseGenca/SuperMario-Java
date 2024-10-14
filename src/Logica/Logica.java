package Logica;

import java.util.List;

import Entidades.Entidad;
import Entidades.Mario;
import GUI.GUI;
import GUI.Observer;
import Nivel.Nivel;
import ParseInt.Parserint;
import ParseInt.*;
import Fabricas.*;

public class Logica {
    //Atributos de instancia
    protected ManejadorDeColisiones manejadorDeColisiones;
    protected int cantidadVidas;
    protected int puntaje;
    protected int monedas;
    protected int tiempoRestante;
    protected Reloj relojGlobal;
    protected Parserint parseint;
    protected EntidadesFactory fabricaEntidades;
    protected SpriteFactory fabricaSprites;
    protected GUI gui;
    protected Mario jugador;
    protected Nivel nivelActual;
    

    //Constructor
    public Logica() {
        fabricaSprites = new SpritesMarioModo1();
		fabricaEntidades = new EntidadesFactory(fabricaSprites);
        parseint = new Parserint(1,fabricaEntidades);
    }
   
    public void setControladorVistas(GUI controladorVistas) {
		gui = controladorVistas;
	}

    public void iniciar() {
		nivelActual = parseint.cargarNivelDesdeArchivo(1);
		registrarObservers();
		gui.mostrarPantallaCarrera();
	}

    protected void registrarObservers() {
		registrarObserverJugador(nivelActual.getMario());
		registrarObserversParaEntidades(nivelActual.getEnemigos());
		registrarObserversParaEntidades(nivelActual.getPowerUps());
	}

    protected void registrarObserverJugador(Mario jugador) {
		Observer observerJugador = gui.registrarEntidad(jugador);
		jugador.setObserver(observerJugador);
	}
	
	protected void registrarObserversParaEntidades(List<? extends Entidad> entidades) {
		for(Entidad entidad : entidades) {
			Observer observer = gui.registrarEntidad(entidad);
			entidad.setObserver(observer);
		}
	}

    public void setManejadorDeColisiones(ManejadorDeColisiones manejadorDeColisiones) {
        this.manejadorDeColisiones=manejadorDeColisiones;
    }

    public void setCantidadDeVidas(int vidas) {
        this.cantidadVidas=vidas;
    }

    public void setRelojGlobal(Reloj reloj) {
        this.relojGlobal=reloj;
    }

    public void setNivelActual(Nivel nivel) {
        this.nivelActual=nivel;
    }
    public GUI getGUI(){
        return gui;
    }
    
    public int getPuntaje() {
        return puntaje;
    }

    public int getTiempoRestante() {
        return tiempoRestante;
    }

    public ManejadorDeColisiones getManejadorDeColisiones() {
        return manejadorDeColisiones;
    }

    public int getCantidadDeVidas() {
        return cantidadVidas;
    }

    public Reloj getRelojGlobal() {
        return relojGlobal;
    }

    public Nivel getNivelActual() {
        return nivelActual;
    }

    public void saltarJugador() {
        jugador.saltar();
    }

    public void dispararJugador() {
        jugador.disparar();
    }

    public void establecerDireccionMario(int x){
        jugador.establecerDireccion(x);
    }

    //AGREGAR UN METODO SIMILAR, este codigo es el de fede joaquin.
    /*public void iniciar() {
		ruta_actual = generador_ruta.generar_ruta(1);
		registrar_observers();
		controlador_vistas.mostrar_pantalla_carrera();
	}*/
}