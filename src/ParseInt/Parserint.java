package ParseInt;

import Fabricas.EntidadesFactory;
import GUI.GUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Logica.Logica;
import Logica.ManejadorDeColisiones;
import Nivel.Nivel;


public class Parserint {
    protected int nivel;
    protected EntidadesFactory fabricaEnt;
    protected ManejadorDeColisiones manejador;
    protected GUI gui;

    public Parserint(int nivel,EntidadesFactory fabricaEntidades){
        this.nivel=nivel;
        fabricaEnt=fabricaEntidades;
    }

    

    public Nivel cargarArchivoNivel(int nivel,ManejadorDeColisiones manejador,GUI gui){
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

        Nivel nivelActual = new Nivel(gui,manejador);

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
                        nivelActual.agregarMario(fabricaEnt.crearMario(marioX, marioY));
                        break;

                    case "Bloque Solido":
                        int bloqueSolidoX = Integer.parseInt(parametros[0]);
                        int bloqueSolidoY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPlataforma(fabricaEnt.crearBloqueSolido(bloqueSolidoX, bloqueSolidoY));
                        break;

                    case "Tuberia":
                        int tuberiaX = Integer.parseInt(parametros[0]);
                        int tuberiaY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPlataforma(fabricaEnt.crearTuberia(tuberiaX,tuberiaY));
                        break;
                    case "Ladrillo Rompible":
                        int ladrilloX = Integer.parseInt(parametros[0]);
                        int ladrilloY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPlataforma(fabricaEnt.crearLadrilloRompible(ladrilloX,ladrilloY));
                        break;
                    case "Meta":
                        int metaX = Integer.parseInt(parametros[0]);
                        int metaY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPlataforma(fabricaEnt.crearMeta(metaX,metaY));
                        break;
                    case "Vacio":
                        int vacioX = Integer.parseInt(parametros[0]);
                        int vacioY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPlataforma(fabricaEnt.crearVacio(vacioX,vacioY));
                        break;
                    case "Bloque Pregunta":
                        int bloquePreguntaX = Integer.parseInt(parametros[0]);
                        int bloquePreguntaY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPlataforma(fabricaEnt.crearBloquePregunta(bloquePreguntaX, bloquePreguntaY));
                        break;
                    case "Goomba":
                        int goombaX = Integer.parseInt(parametros[0]);
                        int goombaY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarEnemigo(fabricaEnt.crearGoomba(goombaX, goombaY));
                        break;
                    case "Lakitu":
                        int lakituX = Integer.parseInt(parametros[0]);
                        int lakituY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarEnemigo(fabricaEnt.crearLakitu(lakituX,lakituY));
                        break;
                    case "Piranha Plant":
                        int piranhaPlantX = Integer.parseInt(parametros[0]);
                        int piranhaPlantY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarEnemigo(fabricaEnt.crearPiranhaPlant(piranhaPlantX,piranhaPlantY));
                        break;
                    case "Koopa Troopa":
                        int koopaTroopaX = Integer.parseInt(parametros[0]);
                        int koopaTroopaY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarEnemigo(fabricaEnt.crearKoopaTroopa(koopaTroopaX,koopaTroopaY));
                        break;
                    case "Spiny":
                        int spinyX = Integer.parseInt(parametros[0]);
                        int spinyY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarEnemigo(fabricaEnt.crearSpiny(spinyX,spinyY));
                        break;
                    case "Buzzy Beetle":
                        int buzzyBeetleX = Integer.parseInt(parametros[0]);
                        int buzzyBeetleY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarEnemigo(fabricaEnt.crearBuzzyBeetle(buzzyBeetleX,buzzyBeetleY));
                        break;
                    case "Moneda":
                        int monedaX = Integer.parseInt(parametros[0]);
                        int monedaY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPowerUp(fabricaEnt.crearMoneda(monedaX,monedaY));
                        break;
                    case "Estrella":
                        int estrellaX = Integer.parseInt(parametros[0]);
                        int estrellaY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPowerUp(fabricaEnt.crearEstrella(estrellaX,estrellaY));
                        break;
                    case "Flor de Fuego":
                        int florDeFuegoX = Integer.parseInt(parametros[0]);
                        int florDeFuegoY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPowerUp(fabricaEnt.crearFlorDeFuego(florDeFuegoX,florDeFuegoY));
                        break;
                    case "Super Champinion":
                        int superChampinionX = Integer.parseInt(parametros[0]);
                        int superChampinionY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPowerUp(fabricaEnt.crearSuperChampinion(superChampinionX,superChampinionY));
                        break;
                    case "Champinion Verde":
                        int champinionVerdeX = Integer.parseInt(parametros[0]);
                        int champinionVerdeY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPowerUp(fabricaEnt.crearChampinionVerde(champinionVerdeX,champinionVerdeY));
                        break;

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nivelActual;
    }


}
