package Logica;

import Entidades.Mario;
import GUI.GUI;
import Nivel.Nivel;
import ParseInt.Parserint;
import Puntaje.AdministradorDePuntaje;
import ParseInt.*;
import Fabricas.*;

public class Logica {
    //Atributos de instancia
    protected ManejadorDeColisiones manejadorDeColisiones;
    protected AdministradorDePuntaje administradorDePuntaje;
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
        fabricaSprites = new SpriteFactory();
		fabricaEntidades = new EntidadesFactory(fabricaSprites);
        parseint = new Parseint(nivelActual,fabricaEntidades);
    }
   
    public void setControladorVistas(GUI controladorVistas) {
		gui = controladorVistas;
	}

    public void iniciar() {
		nivelActual = parseint.cargarNivelDesdeArchivo(1);
		registrarObservers();
		gui.mostrarPantallaCarrera();
	}

    public void setManejadorDeColisiones(ManejadorDeColisiones manejadorDeColisiones) {
        this.manejadorDeColisiones=manejadorDeColisiones;
    }

    public void setAdministradorDePuntaje(AdministradorDePuntaje administradorDePuntaje) {
        this.administradorDePuntaje=administradorDePuntaje;
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

    public AdministradorDePuntaje getAdministradorDePuntaje() {
        return administradorDePuntaje;
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

    public void actualizarVidas() {
        gui.actualizarVidas();
    }

    public void saltarJugador() {
        jugador.saltar();
    }

    public void dispararJugador() {
        jugador.disparar();
    }

    public void actualizarPuntaje(int puntajeExtra) {
        puntaje=puntaje+puntajeExtra;
        administradorDePuntaje.actualizarPuntaje(puntajeExtra);
    }

    public void ganarVidas() {
        cantidadVidas=cantidadVidas+1;
        this.actualizarVidas();
    }

    public void perderVidas() {
        cantidadVidas=cantidadVidas-1;
        this.actualizarVidas();

        if(cantidadVidas==0) {
            //Mensaje a la gui de terminar juego
            if(administradorDePuntaje.entro_en_el_top5()) {
                //Ver como conseguir el nombre del jugador
                administradorDePuntaje.mejorJugador(jugador.getNombre());
            }
        }
    }

    public void agregarMoneda() {
        monedas=monedas+1;
        if(monedas==100) {
            this.ganarVidas();
            monedas=0;
        }
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