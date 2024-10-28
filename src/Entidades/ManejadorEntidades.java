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

    private ManejadorEntidades() {}

    public static void inicializar(Nivel nivel,EntidadesFactory fabrica) {
            instancia = new ManejadorEntidades();
            instancia.nivel = nivel;
            instancia.fabricaEnt = fabrica;
    }

    public static ManejadorEntidades getInstancia() {
        if (instancia == null) {
            throw new IllegalStateException("El ManejadorEntidades no ha sido inicializado");
        }
        return instancia;
    }

    public void eliminarEnemigo(Enemigo enemigo) {
        if (nivel != null) {
            nivel.eliminarEnemigo(enemigo);
        } else {
            System.out.println("Nivel no inicializado");
        }
    }

    public void eliminarPowerUp(PowerUp powerUp){
        if (nivel != null) {
            nivel.eliminarPowerUp(powerUp);
        } else {
            System.out.println("Nivel no inicializado");
        }
    }

    public void eliminarPlataforma(Plataforma plataforma){
        if (nivel != null) {
            nivel.eliminarPlataforma(plataforma);
        } else {
            System.out.println("Nivel no inicializado");
        }
    }

    //metodos bola de fuego
    public void agregarBolaDeFuego(BolaDeFuego bola){
        if(nivel!=null){
            nivel.agregarBolaDeFuego(bola);
        } else{
            System.out.println("Nivel no inicializado");
        }
    }

    public BolaDeFuego crearBolaDeFuego(int x, int y, Mario mario){
        return fabricaEnt.crearBolaDeFuego(x,y, mario);
    }

    public void eliminarBolaDeFuego(BolaDeFuego bola){
        if (nivel != null) {
            nivel.eliminarBolaDeFuego(bola);
        } else {
            System.out.println("Nivel no inicializado");
        }
    }

    //metodos power ups
    public void agregarMoneda(Moneda moneda){
        nivel.agregarPowerUp(moneda);
    }

    public Moneda crearMoneda(int x, int y){
        return fabricaEnt.crearMoneda(x, y);
    }

    public void agregarFlorDeFuego(FlorDeFuego florDeFuego){
        nivel.agregarPowerUp(florDeFuego);
    }

    public FlorDeFuego crearFlorDeFuego(int x, int y){
        return fabricaEnt.crearFlorDeFuego(x, y);
    }

    public void agregarEstrella(Estrella estrella){
        nivel.agregarPowerUp(estrella);
    }

    public Estrella crearEstrella(int x, int y){
        return fabricaEnt.crearEstrella(x, y);
    }

    public void agregarChampinionVerde(ChampinionVerde champinionVerde){
        nivel.agregarPowerUp(champinionVerde);
    }

    public ChampinionVerde crearChampinionVerde(int x, int y){
        return fabricaEnt.crearChampinionVerde(x, y);
    }

    public void agregarSuperChampinion(SuperChampinion superChampinion){
        nivel.agregarPowerUp(superChampinion);
    }

    public SuperChampinion crearSuperChampinion(int x, int y){
        return fabricaEnt.crearSuperChampinion(x, y);
    }


}

