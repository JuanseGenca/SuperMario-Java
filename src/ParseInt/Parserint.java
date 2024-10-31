package ParseInt;

import Enemigos.Lakitu;
import Entidades.ManejadorEntidades;
import Fabricas.EntidadesFactory;
import Logica.Logica;
import Nivel.Nivel;
import Nivel.Silueta;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Parserint {
    protected EntidadesFactory fabricaEnt;
    protected Logica miLogica;

    public Parserint(int nivel,EntidadesFactory fabricaEntidades,Logica log){
        fabricaEnt=fabricaEntidades;
        miLogica = log;
    }

    public Nivel generarNivel(int nivel){
        String path = obtenerArchivoNivel(nivel);
        return cargarNivelDesdeArchivo(path,nivel);
    }

    protected String obtenerArchivoNivel(int nivel){
        String archivo;
        if(nivel == 1){
            archivo = "src/Niveles/NivelMario.txt"; 
        } else{
            if(nivel == 2){
                archivo = "src/Niveles/NivelMario2.txt";
            } else{
                archivo = "src/Niveles/NivelMario3.txt";
            }
        }
        return archivo; 

    }


    public Nivel cargarNivelDesdeArchivo(String path,int numero) {

        Silueta silueta = fabricaEnt.getSilueta(numero);
		Nivel nivelActual = new Nivel(silueta, numero);
        ManejadorEntidades.inicializar(nivelActual,fabricaEnt,miLogica);

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
                        nivelActual.agregarPlataforma(fabricaEnt.crearBloquePregunta(bloquePreguntaX, bloquePreguntaY,miLogica,getRandomInt()));
                        break;
                    case "Goomba":
                        int goombaX = Integer.parseInt(parametros[0]);
                        int goombaY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarEnemigo(fabricaEnt.crearGoomba(goombaX, goombaY));
                        break;
                    case "Lakitu":
                        int lakituX = Integer.parseInt(parametros[0]);
                        int lakituY = Integer.parseInt(parametros[1]);
                        Lakitu lakitu = fabricaEnt.crearLakitu(lakituX, lakituY);
                        nivelActual.agregarEnemigo(lakitu);
                        nivelActual.agregarLakitu(lakitu);
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

    private int getRandomInt() {
        int numero = (int) (Math.random() * 5 + 1);
        return numero;
      }
}
