package Nivel;
import Enemigos.*;
import Entidades.BolaDeFuego;
import Entidades.Mario;
import GUI.GUI;
import Logica.*;
import Plataformas.Plataforma;
import PowerUps.PowerUp;
import java.util.ArrayList;

public class Nivel {
    protected ArrayList<Enemigo> enemigos;
    protected ArrayList<Plataforma> plataformas;
    protected ArrayList<PowerUp> powerUps;
    protected ArrayList<BolaDeFuego> bolasFuego;
    protected Mario jugador;
    protected GUI miGui;
    protected ManejadorDeColisiones manejadorColisiones;
    protected HiloEntidades hiloEntidades;
    protected int numeroNivel;

    public Nivel(GUI gui, ManejadorDeColisiones manejador, HiloEntidades hiloEntidades){
        miGui = gui;
        manejadorColisiones = manejador;
        enemigos = new ArrayList<>();
        plataformas = new ArrayList<>();
        powerUps = new ArrayList<>();
        bolasFuego = new ArrayList<>();
        this.hiloEntidades = hiloEntidades;
        //falta inicializar a Mario, como consigo los parametros?
    }
    public ArrayList<Enemigo> getEnemigos(){
        return enemigos;
    }
    public ArrayList<Plataforma> getPlataformas(){
        return plataformas;
    }
    public ArrayList<PowerUp> getPowerUps(){
        return powerUps;
    }
    public ArrayList<BolaDeFuego> getBolaDeFuego(){
        return bolasFuego;
    }
    public Mario getMario(){
        return jugador;
    }

    public int getNivel() {
        return numeroNivel;
    }

    public void setNivel(int nivel) {
        this.numeroNivel = nivel;
    }
    public void eliminarPlataforma(Plataforma plataforma){
        if(plataformas.contains(plataforma)) {
            plataformas.remove(plataforma);
            manejadorColisiones.eliminarEntidad(plataforma);
            hiloEntidades.removeActionListener(plataforma);
        }
    }
    public void eliminarMario(Mario mario){
        //como elimino a mario? le asigno null directamente?
    }
    public void eliminarPowerUp(PowerUp powerUp){
        if(powerUps.contains(powerUp)){
            powerUps.remove(powerUp);
            manejadorColisiones.eliminarEntidad(powerUp);
            hiloEntidades.removeActionListener(powerUp);
        }
    }
    public void eliminarEnemigo(Enemigo enemigo){
        if(enemigos.contains(enemigo)){
            enemigos.remove(enemigo);
            manejadorColisiones.eliminarEntidad(enemigo);
            hiloEntidades.removeActionListener(enemigo);
        }
    }
    public void eliminarBolaDeFuego(BolaDeFuego bola){
        if(bolasFuego.contains(bola)){
            bolasFuego.remove(bola);
            manejadorColisiones.eliminarEntidad(bola);
            hiloEntidades.removeActionListener(bola);
        }
    }
    public void agregarPlataforma(Plataforma plataforma){
        if(plataforma!=null) {
            plataformas.add(plataforma);
            manejadorColisiones.agregarEntidad(plataforma);
            hiloEntidades.addActionListener(plataforma);
        }
    }
    public void agregarBolaDeFuego(BolaDeFuego bola){
        if(bola!=null) {
            bolasFuego.add(bola);
            manejadorColisiones.agregarEntidad(bola);
            hiloEntidades.addActionListener(bola);
        }
    }
    public void agregarMario(Mario mario){
        if(mario!=null) {
            this.jugador = mario;
            manejadorColisiones.agregarEntidad(mario);
        }
    }
    public void agregarPowerUp(PowerUp powerUp){
        if(powerUp!=null) {
            powerUps.add(powerUp);
            manejadorColisiones.agregarEntidad(powerUp);
            hiloEntidades.addActionListener(powerUp);
        }
    }
    public void agregarEnemigo(Enemigo enemigo){
        if(enemigo!=null) { 
            enemigos.add(enemigo);
            manejadorColisiones.agregarEntidad(enemigo);
            hiloEntidades.addActionListener(enemigo);
        }
    }

}
