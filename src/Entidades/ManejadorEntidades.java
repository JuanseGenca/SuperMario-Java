package Entidades;

import Enemigos.Enemigo;
import Nivel.Nivel;

public class ManejadorEntidades {
    private Nivel nivel;
    private static ManejadorEntidades instancia;

    // Constructor privado para evitar instanciación externa
    private ManejadorEntidades() {}

    // Método para inicializar la instancia con el nivel
    public static void inicializar(Nivel nivel) {
        if (instancia == null) {
            instancia = new ManejadorEntidades();
            instancia.nivel = nivel;
        }
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
}
