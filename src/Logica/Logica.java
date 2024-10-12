package Logica;

import Entidades.Mario;
import GUI.GUI;
import Nivel.Nivel;
import Puntaje.AdministradorDePuntaje;

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
    protected GUI gui;
    protected KeyListener keyListener;
    protected Mario jugador;
    protected Nivel nivelActual;

    //Constructor
    public Logica() {}

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

    public void setKeyListener(KeyListener keyListener) {
        this.keyListener=keyListener;
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
        gui.actualizarVidas(cantidadVidas);
    }

    public void moverJugadorDerecha() {
        jugador.moverDerecha();
    }

    public void moverJugadorIzquierda() {
        jugador.moverIzquierda();
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
}