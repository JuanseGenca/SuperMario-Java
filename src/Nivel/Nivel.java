package Nivel;
import Enemigos.*;
import Entidades.BolaDeFuego;
import Entidades.Entidad;
import Entidades.Mario;
import Logica.ManejadorDeColisiones;
import Plataformas.Plataforma;
import PowerUps.PowerUp;
import java.util.ArrayList;

public class Nivel {
    protected ArrayList<Enemigo> enemigos;
    protected ArrayList<Plataforma> plataformas;
    protected ArrayList<PowerUp> powerUps;
    protected ArrayList<BolaDeFuego> bolasFuego;
    protected ArrayList<Lakitu> lakitus;
    protected Mario jugador;
    protected Silueta silueta;
    protected int numeroNivel;
    protected ManejadorDeColisiones manejadorDeColisiones;

    public Nivel(Silueta silueta,int numero){
        this.silueta = silueta;
        numeroNivel = numero;
        enemigos = new ArrayList<>();
        plataformas = new ArrayList<>();
        powerUps = new ArrayList<>();
        bolasFuego = new ArrayList<>();
        lakitus = new ArrayList<>();
        manejadorDeColisiones = new ManejadorDeColisiones();
    }

    public Silueta getSilueta(){
		return silueta;
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

    public int getNumeroNivel(){
        return numeroNivel;
    }

    public ManejadorDeColisiones getManejadorDeColisiones(){
        return manejadorDeColisiones;
    }

    public void eliminarPlataforma(Plataforma plataforma){
        if(plataformas.contains(plataforma)) {
            plataformas.remove(plataforma);
            manejadorDeColisiones.eliminarEntidad(plataforma);
        }
    }
    public void eliminarMario(Mario mario){
        //como elimino a mario? le asigno null directamente?
    }
    public void eliminarPowerUp(PowerUp powerUp){
        if(powerUps.contains(powerUp)){
            powerUps.remove(powerUp);
            manejadorDeColisiones.eliminarEntidad(powerUp);
        }
    }
    public void eliminarEnemigo(Enemigo enemigo){
        if(enemigos.contains(enemigo)){
            enemigos.remove(enemigo);
            manejadorDeColisiones.eliminarEntidad(enemigo);
        }
    }
    public void agregarPlataforma(Plataforma plataforma){
        if(plataforma!=null) {
            plataformas.add(plataforma);
            manejadorDeColisiones.agregarEntidad(plataforma);
        }
    }
    public void agregarMario(Mario mario){
        if(mario!=null) {
            this.jugador = mario;
            manejadorDeColisiones.agregarEntidad(mario);
        }
    }
    public void agregarPowerUp(PowerUp powerUp){
        if(powerUp!=null) {
            powerUps.add(powerUp);
            manejadorDeColisiones.agregarEntidad(powerUp);
        }
    }
    public void agregarEnemigo(Enemigo enemigo){
        if(enemigo!=null) { 
            enemigos.add(enemigo);
            manejadorDeColisiones.agregarEntidad(enemigo);
        }
    }
    public void agregarBolaDeFuego(BolaDeFuego bola){
        if(bola!=null){
            bolasFuego.add(bola);
            manejadorDeColisiones.agregarEntidad(bola);
        }
    }
    public void eliminarBolaDeFuego(BolaDeFuego bola){
        if(bolasFuego.contains(bola)){
            bolasFuego.remove(bola);
            manejadorDeColisiones.eliminarEntidad(bola);
        }
    }

    public void agregarLakitu(Lakitu lakitu){
        if(lakitu!=null){
            lakitus.add(lakitu);
        }
    }

    public void iniciarTimerLakitus() {
        for (Lakitu l : lakitus) {
            l.iniciarReloj(5000);
        }
    }

    public void eliminarEntidad(Entidad entidad) {}

}
