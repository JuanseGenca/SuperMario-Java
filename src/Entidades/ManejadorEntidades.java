package Entidades;

import Enemigos.Enemigo;
import Enemigos.Spiny;
import Fabricas.EntidadesFactory;
import GUI.Observer;
import GUI.ObserverEntidades;
import Logica.Logica;
import Nivel.Nivel;
import Plataformas.Plataforma;
import PowerUps.ChampinionVerde;
import PowerUps.Estrella;
import PowerUps.FlorDeFuego;
import PowerUps.Moneda;
import PowerUps.PowerUp;
import PowerUps.SuperChampinion;

public class ManejadorEntidades {
    private Nivel nivel;
    private static ManejadorEntidades instancia;
    private EntidadesFactory fabricaEnt;
    private Logica miLogica;

    private ManejadorEntidades() {}

    public static void inicializar(Nivel nivel,EntidadesFactory fabrica,Logica logica) {
        instancia = new ManejadorEntidades();
        instancia.nivel = nivel;
        instancia.fabricaEnt = fabrica;
        instancia.miLogica = logica;
    }

    public static ManejadorEntidades getInstancia() {
        return instancia;
    }

    public void eliminarObserver(ObserverEntidades observerEntidad){
        miLogica.getGui().EliminarEntidad(observerEntidad);
    }

    public void eliminarEnemigo(Enemigo enemigo) {
        nivel.eliminarEnemigo(enemigo);
    }

    public void eliminarPowerUp(PowerUp powerUp){
        nivel.eliminarPowerUp(powerUp);
    }

    public void eliminarPlataforma(Plataforma plataforma){
        nivel.eliminarPlataforma(plataforma);    
    }

    public void eliminarBolaDeFuego(BolaDeFuego bola){
        nivel.eliminarBolaDeFuego(bola);
    }

    public BolaDeFuego crearBolaDeFuego(int posicionX, int posicionY, Mario mario){
        BolaDeFuego bolaDeFuego =  fabricaEnt.crearBolaDeFuego(posicionX,posicionY, mario);
        nivel.agregarBolaDeFuego(bolaDeFuego);
        Observer observerBola = miLogica.getGui().registrarEntidad(bolaDeFuego);
        bolaDeFuego.setObserver(observerBola);
        return bolaDeFuego;
    }

    public void crearMoneda(int posicionX, int posicionY){
        Moneda moneda = fabricaEnt.crearMoneda(posicionX, posicionY);
        nivel.agregarPowerUp(moneda);
        Observer observerMoneda = miLogica.getGui().registrarEntidad(moneda);
        moneda.setObserver(observerMoneda);
    }

    public void crearFlorDeFuego(int posicionX, int posicionY){
        FlorDeFuego florDeFuego = fabricaEnt.crearFlorDeFuego(posicionX, posicionY);
        nivel.agregarPowerUp(florDeFuego);
        Observer observerFlorDeFuego = miLogica.getGui().registrarEntidad(florDeFuego);
        florDeFuego.setObserver(observerFlorDeFuego);
    }

    public void crearEstrella(int posicionX, int posicionY){
        Estrella estrella = fabricaEnt.crearEstrella(posicionX, posicionY);
        nivel.agregarPowerUp(estrella);
        Observer observerEstrella = miLogica.getGui().registrarEntidad(estrella);
        estrella.setObserver(observerEstrella);
    }

    public void crearChampinionVerde(int posicionX, int posicionY){
        ChampinionVerde champinionVerde = fabricaEnt.crearChampinionVerde(posicionX, posicionY);
        nivel.agregarPowerUp(champinionVerde);
        Observer observerChampinionVerde = miLogica.getGui().registrarEntidad(champinionVerde);
        champinionVerde.setObserver(observerChampinionVerde);
    }

    public void crearSuperChampinion(int posicionX, int posicionY){
        SuperChampinion superChampinion = fabricaEnt.crearSuperChampinion(posicionX, posicionY);
        nivel.agregarPowerUp(superChampinion);
        Observer observerSuperChampinion = miLogica.getGui().registrarEntidad(superChampinion);
        superChampinion.setObserver(observerSuperChampinion);
    }

    public void crearSpiny(int posicionX, int posicionY){
        Spiny spiny = fabricaEnt.crearSpiny(posicionX, posicionY);
        nivel.agregarEnemigo(spiny);
        Observer observerSpiny = miLogica.getGui().registrarEntidad(spiny);
        spiny.setObserver(observerSpiny);
    }
}

