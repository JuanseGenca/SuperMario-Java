package Entidades;

import Enemigos.Enemigo;
import Fabricas.EntidadesFactory;
import GUI.Observer;
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

    public void eliminarEnemigo(Enemigo enemigo) {
        nivel.eliminarEnemigo(enemigo);
       
    }

    public void eliminarPowerUp(PowerUp powerUp){
        nivel.eliminarPowerUp(powerUp);
    }

    public void eliminarPlataforma(Plataforma plataforma){
        nivel.eliminarPlataforma(plataforma);    
    }

    //metodos bola de fuego

    public BolaDeFuego crearBolaDeFuego(int x, int y, Mario mario){
        BolaDeFuego bolaDeFuego =  fabricaEnt.crearBolaDeFuego(x,y, mario);
        nivel.agregarBolaDeFuego(bolaDeFuego);
        Observer observerBola = miLogica.getGui().registrarEntidad(bolaDeFuego);
        bolaDeFuego.setObserver(observerBola);
        return bolaDeFuego;
    }

    public void eliminarBolaDeFuego(BolaDeFuego bola){
        nivel.eliminarBolaDeFuego(bola);
    }

    public void crearMoneda(int x, int y){
        Moneda moneda = fabricaEnt.crearMoneda(x, y);
        nivel.agregarPowerUp(moneda);
        Observer observerMoneda = miLogica.getGui().registrarEntidad(moneda);
        moneda.setObserver(observerMoneda);
    }

    public void crearFlorDeFuego(int x, int y){
        FlorDeFuego florDeFuego = fabricaEnt.crearFlorDeFuego(x, y);
        nivel.agregarPowerUp(florDeFuego);
        Observer observerFlorDeFuego = miLogica.getGui().registrarEntidad(florDeFuego);
        florDeFuego.setObserver(observerFlorDeFuego);
    }

    public void crearEstrella(int x, int y){
        Estrella estrella = fabricaEnt.crearEstrella(x, y);
        nivel.agregarPowerUp(estrella);
        Observer observerEstrella = miLogica.getGui().registrarEntidad(estrella);
        estrella.setObserver(observerEstrella);
    }

    public void crearChampinionVerde(int x, int y){
        ChampinionVerde champinionVerde = fabricaEnt.crearChampinionVerde(x, y);
        nivel.agregarPowerUp(champinionVerde);
        Observer observerChampinionVerde = miLogica.getGui().registrarEntidad(champinionVerde);
        champinionVerde.setObserver(observerChampinionVerde);
    }

    public void crearSuperChampinion(int x, int y){
        SuperChampinion superChampinion = fabricaEnt.crearSuperChampinion(x, y);
        nivel.agregarPowerUp(superChampinion);
        Observer observerSuperChampinion = miLogica.getGui().registrarEntidad(superChampinion);
        superChampinion.setObserver(observerSuperChampinion);
    }


}

