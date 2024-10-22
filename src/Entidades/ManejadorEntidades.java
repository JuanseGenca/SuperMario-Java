package Entidades;

import Enemigos.Enemigo;
import Fabricas.EntidadesFactory;
import Nivel.Nivel;
import Plataformas.Plataforma;
import PowerUps.PowerUp;

public class ManejadorEntidades {
    private Nivel nivel;
    private static ManejadorEntidades instancia;
    private EntidadesFactory fabricaEnt;

    // Constructor privado para evitar instanciación externa
    private ManejadorEntidades() {}

    // Método para inicializar la instancia con el nivel
    public static void inicializar(Nivel nivel,EntidadesFactory fabrica) {
        //if (instancia == null) {
            instancia = new ManejadorEntidades();
            instancia.nivel = nivel;
            instancia.fabricaEnt = fabrica;
        //}
    }

    // Método para obtener la instancia
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
    public void agregarBolaDeFuego(BolaDeFuego bola){
        if(nivel!=null){
            nivel.agregarBolaDeFuego(bola);
        } else{
            System.out.println("Nivel no inicializado");
        }
    }
    public BolaDeFuego crearBolaDeFuego(int x, int y){
        System.out.println("bola creada pa");
        return fabricaEnt.crearBolaDeFuego(x,y);
        
    }
    public void eliminarBolaDeFuego(BolaDeFuego bola){
        if (nivel != null) {
            nivel.getBolaDeFuego().remove(bola);
        } else {
            System.out.println("Nivel no inicializado");
        }
    }
}

