
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import Entidades.Entidad;
import Fabricas.EntidadesFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import GUI.GUI;
import Logica.ManejadorDeColisiones;

public class Parserint {
    protected int nivel;
    protected String modo;
    protected EntidadesFactory fabricaEnt;

    public Parserint(int nivel,String modo,EntidadesFactory fabricaEntidades){
        this.nivel=nivel;
        this.modo=modo;
        fabricaEnt=fabricaEntidades;
    }

    

    public Nivel cargarArchivoNivel(int nivel){
        String path = obtenerArchivoNivel(this.nivel);
        return cargarNivelDesdeArchivo(path);
        
    }

    protected String obtenerArchivoNivel(int nivel){
        String archivo;
        if(nivel == 1){
            archivo = "ruta del archivo para nivel 1"; //poner ruta real cuando tengamos el archivo
        } else{
            if(nivel == 2){
                archivo = "ruta del archivo para nivel 2";
            } else{
                archivo = "ruta del archivo para nivel 3";
            }
        }

        return archivo;

    }


    public Nivel cargarNivelDesdeArchivo(String path) {
        Nivel nivelActual = new Nivel(new GUI(),new ManejadorDeColisiones(new ArrayList<Entidad>(),nivelActual));

        try (BufferedReader lector = new BufferedReader(new FileReader(path))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                // mientras que linea sea distinto de nulo parseo
                String[] partes = linea.split(":");
                String tipo = partes[0];
                String[] parametros = partes[1].split(",");
                //divido los datos del archivo en arreglos
                
                switch (tipo) {
                    case "Mario":
                        int marioX = Integer.parseInt(parametros[0]);
                        int marioY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarMario(fabricaEnt.crearMario(marioX, marioY, modo));
                        break;

                    case "Bloque Solido":
                        int bloqueSolidoX = Integer.parseInt(parametros[0]);
                        int bloqueSolidoY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPlataforma(fabricaEnt.crearBloqueSolido(bloqueSolidoX, bloqueSolidoY,modo));
                        break;

                    case "Tuberia":
                        int tuberiaX = Integer.parseInt(parametros[0]);
                        int tuberiaY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPlataforma(fabricaEnt.crearTuberia(tuberiaX,tuberiaY,modo));
                        break;
                    case "Ladrillo Solido":
                        int ladrilloX = Integer.parseInt(parametros[0]);
                        int ladrilloY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPlataforma(fabricaEnt.crearLadrilloSolido(ladrilloX,ladrilloY,modo));
                        break;
                    case "Meta":
                        int metaX = Integer.parseInt(parametros[0]);
                        int metaY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPlataforma(fabricaEnt.crearMeta(metaX,metaY,modo));
                        break;
                    case "Vacio":
                        int vacioX = Integer.parseInt(parametros[0]);
                        int vacioY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPlataforma(fabricaEnt.crearVacio(vacioX,vacioY,modo));
                        break;

                    case "Goomba":
                        int goombaX = Integer.parseInt(parametros[0]);
                        int goombaY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarEnemigo(fabricaEnt.crearGoomba(goombaX, goombaY, modo));
                        break;
                    case "Lakitu":
                        int lakituX = Integer.parseInt(parametros[0]);
                        int lakituY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarEnemigo(fabricaEnt.crearLakitu(lakituX,lakituY, modo));
                        break;
                    case "Piranha Plant":
                        int piranhaPlantX = Integer.parseInt(parametros[0]);
                        int piranhaPlantY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarEnemigo(fabricaEnt.crearPiranhaPlant(piranhaPlantX,piranhaPlantY, modo));
                        break;
                    case "Koopa Troopa":
                        int koopaTroopaX = Integer.parseInt(parametros[0]);
                        int koopaTroopaY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarEnemigo(fabricaEnt.crearKoopaTroopa(koopaTroopaX,koopaTroopaY, modo));
                        break;
                    case "Spiny":
                        int spinyX = Integer.parseInt(parametros[0]);
                        int spinyY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarEnemigo(fabricaEnt.crearSpiny(spinyX,spinyY, modo));
                        break;
                    case "Buzzy Beetle":
                        int buzzyBeetleX = Integer.parseInt(parametros[0]);
                        int buzzyBeetleY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarEnemigo(fabricaEnt.crearBuzzyBeetle(buzzyBeetleX,buzzyBeetleY, modo));
                        break;
                    case "Moneda":
                        int monedaX = Integer.parseInt(parametros[0]);
                        int monedaY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPowerUp(fabricaEnt.crearMoneda(monedaX,monedaY, modo));
                        break;
                    case "Estrella":
                        int estrellaX = Integer.parseInt(parametros[0]);
                        int estrellaY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPowerUp(fabricaEnt.crearEstrella(estrellaX,estrellaY, modo));
                        break;
                    case "Flor de Fuego":
                        int florDeFuegoX = Integer.parseInt(parametros[0]);
                        int florDeFuegoY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPowerUp(fabricaEnt.crearFlorDeFuego(florDeFuegoX,florDeFuegoY, modo));
                        break;
                    case "Super Champinion":
                        int superChampinionX = Integer.parseInt(parametros[0]);
                        int superChampinionY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPowerUp(fabricaEnt.crearSuperChampinion(superChampinionX,superChampinionY, modo));
                        break;
                    case "Champinion Verde":
                        int champinionVerdeX = Integer.parseInt(parametros[0]);
                        int champinionVerdeY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPowerUp(fabricaEnt.crearChampinionVerde(champinionVerdeX,champinionVerdeY, modo));
                        break;

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nivelActual;
    }


}

