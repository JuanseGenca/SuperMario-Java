package Nivel;
import Enemigos.Enemigo;
import Entidades.BolaDeFuego;
import Entidades.Mario;
import GUI.GUI;
import Logica.ManejadorDeColisiones;
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
    protected int numero;

    public Nivel(GUI gui, ManejadorDeColisiones manejador){
        miGui = gui;
        manejadorColisiones = manejador;
        enemigos = new ArrayList<>();
        plataformas = new ArrayList<>();
        powerUps = new ArrayList<>();
        bolasFuego = new ArrayList<>();
        //falta inicializar a Mario, como consigo los parametros?
        //falta el numero de nivel, la logica se lo pasa?
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
        boolean encontre = false;
        for(int i=0;i<plataformas.size() && !encontre;i++){
            if(plataformas.get(i) == plataforma){
                encontre = true;
                plataformas.remove(i);
            }
        }
    }
    public void eliminarMario(Mario mario){
        //como elimino a mario? le asigno null directamente?
    }
    public void eliminarPowerUp(PowerUp powerUp){
        boolean encontre = false;
        for(int i=0;i<powerUps.size() && !encontre;i++){
            if(powerUps.get(i) == powerUp){
                encontre = true;
                powerUps.remove(i);
            }
        }
    }
    public void eliminarEnemigo(Enemigo enemigo){
        boolean encontre = false;
        for(int i=0;i<enemigos.size() && !encontre;i++){
            if(enemigos.get(i) == enemigo){
                encontre = true;
                enemigos.remove(i);
            }
        }
    }
    public void eliminarBolaDeFuego(BolaDeFuego bola){
        boolean encontre = false;
        for(int i=0;i<bolasFuego.size() && !encontre;i++){
            if(bolasFuego.get(i) == bola){
                encontre = true;
                bolasFuego.remove(i);
            }
        }
    }
    public void agregarPlataforma(Plataforma plataforma){
        plataformas.addLast(plataforma);
        //unicamente esto? revisar todos los agregar
    }
    public void agregarBolaDeFuego(BolaDeFuego bola){
        bolasFuego.addLast(bola);
    }
    public void agregarMario(Mario mario){
        jugador = mario;
    }
    public void agregarPowerUp(PowerUp powerUp){
        powerUps.addLast(powerUp);
    }
    public void agregarEnemigo(Enemigo enemigo){
        enemigos.addLast(enemigo);
    }
    public void pasarEntidades(HiloEntidades hiloEntidades){
        //terminar esto
    }
}
