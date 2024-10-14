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
    protected int numeroNivel;
    protected int chequep;

    public Nivel(int numero){
        numeroNivel = numero;
        enemigos = new ArrayList<>();
        plataformas = new ArrayList<>();
        powerUps = new ArrayList<>();
        bolasFuego = new ArrayList<>();
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

    public void eliminarPlataforma(Plataforma plataforma){
        if(plataformas.contains(plataforma)) {
            plataformas.remove(plataforma);
        }
    }
    public void eliminarMario(Mario mario){
        //como elimino a mario? le asigno null directamente?
    }
    public void eliminarPowerUp(PowerUp powerUp){
        if(powerUps.contains(powerUp)){
            powerUps.remove(powerUp);
        }
    }
    public void eliminarEnemigo(Enemigo enemigo){
        if(enemigos.contains(enemigo)){
            enemigos.remove(enemigo);
        }
    }
    public void eliminarBolaDeFuego(BolaDeFuego bola){
        if(bolasFuego.contains(bola)){
            bolasFuego.remove(bola);
        }
    }
    public void agregarPlataforma(Plataforma plataforma){
        if(plataforma!=null) {
            plataformas.add(plataforma);
        }
    }
    public void agregarBolaDeFuego(BolaDeFuego bola){
        if(bola!=null) {
            bolasFuego.add(bola);
        }
    }
    public void agregarMario(Mario mario){
        if(mario!=null) {
            this.jugador = mario;
        }
    }
    public void agregarPowerUp(PowerUp powerUp){
        if(powerUp!=null) {
            powerUps.add(powerUp);
        }
    }
    public void agregarEnemigo(Enemigo enemigo){
        if(enemigo!=null) { 
            enemigos.add(enemigo);
        }
    }

}
