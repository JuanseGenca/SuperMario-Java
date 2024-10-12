import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parserint {
    protected int nivel;
    protected String skin;
    protected EntidadesFactory fabricaEnt;
    protected SpriteFactory fabricaSprite;

    public Parserint(int nivel,String skin,EntidadesFactory fabricaEntidades,SpriteFactory fabricaImagenes ){
        this.nivel=nivel;
        this.skin=skin;
        fabricaEnt=fabricaEntidades;
        fabricaSprite = fabricaImagenes;
    }

    

    public Nivel cargarArchivoNivel(int nivel,String skin){
        String path = obtenerArchivoNivel(this.nivel);
        return cargarNivelDesdeArchivo(path);
        
    }

    protected String obtenerArchivoNivel(int nivel){
        String archivo;
        if(nivel == 1){
            archivo = "ruta del archivo"; //poner ruta real cuando tengamos el archivo
        }

        return archivo;

    }


    public Nivel cargarNivelDesdeArchivo(String path) {
        Nivel nivelActual = new Nivel();

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
                        nivelActual.agregarMario(fabricaEnt.crearMario(marioX, marioY, fabricaSprite.crearSpriteMario(skin)));
                        break;

                    case "Bloque Solido":
                        int bloqueSolidoX = Integer.parseInt(parametros[0]);
                        int bloqueSolidoY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPlataforma(fabricaEnt.crearBloqueSolido(bloqueSolidoX, bloqueSolidoY,fabricaSprite.crearSpriteBloqueSolido(skin)));
                        break;

                    case "Tuberia":
                        int tuberiaX = Integer.parseInt(parametros[0]);
                        int tuberiaY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPlataforma(fabricaEnt.crearTuberia(tuberiaX,tuberiaY,fabricaSprite.crearSpriteTuberia(skin)));
                        break;
                    case "Ladrillo Solido":
                        int ladrilloX = Integer.parseInt(parametros[0]);
                        int ladrilloY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPlataforma(fabricaEnt.crearLadrilloSolido(ladrilloX,ladrilloY,fabricaSprite.crearSpriteLadrilloSolido(skin)));
                        break;
                    case "Meta":
                        int metaX = Integer.parseInt(parametros[0]);
                        int metaY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPlataforma(fabricaEnt.crearMeta(metaX,metaY,fabricaSprite.crearSpriteMeta(skin)));
                        break;
                    case "Vacio":
                        int vacioX = Integer.parseInt(parametros[0]);
                        int vacioY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPlataforma(fabricaEnt.crearVacio(vacioX,vacioY,fabricaSprite.crearSpriteVacio(skin)));
                        break;

                    case "Goomba":
                        int goombaX = Integer.parseInt(parametros[0]);
                        int goombaY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarEnemigo(fabricaEnt.crearGoomba(goombaX, goombaY, fabricaSprite.crearSpriteGoomba(skin)));
                        break;
                    case "Lakitu":
                        int lakituX = Integer.parseInt(parametros[0]);
                        int lakituY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarEnemigo(fabricaEnt.crearLakitu(lakituX,lakituY, fabricaSprite.crearSpriteLakitu(skin)));
                        break;
                    case "Piranha Plant":
                        int piranhaPlantX = Integer.parseInt(parametros[0]);
                        int piranhaPlantY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarEnemigo(fabricaEnt.crearPiranhaPlant(piranhaPlantX,piranhaPlantY, fabricaSprite.crearSpritePiranhaPlant(skin)));
                        break;
                    case "Koopa Troopa":
                        int koopaTroopaX = Integer.parseInt(parametros[0]);
                        int koopaTroopaY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarEnemigo(fabricaEnt.crearKoopaTroopa(koopaTroopaX,koopaTroopaY, fabricaSprite.crearSpriteKoopaTroopa(skin)));
                        break;
                    case "Spiny":
                        int spinyX = Integer.parseInt(parametros[0]);
                        int spinyY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarEnemigo(fabricaEnt.crearSpiny(spinyX,spinyY, fabricaSprite.crearSpriteSpiny(skin)));
                        break;
                    case "Buzzy Beetle":
                        int buzzyBeetleX = Integer.parseInt(parametros[0]);
                        int buzzyBeetleY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarEnemigo(fabricaEnt.crearBuzzyBeetle(buzzyBeetleX,buzzyBeetleY, fabricaSprite.crearSpriteBuzzyBeetle(skin)));
                        break;
                    case "Moneda":
                        int monedaX = Integer.parseInt(parametros[0]);
                        int monedaY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPowerUp(fabricaEnt.crearMoneda(monedaX,monedaY, fabricaSprite.crearSpriteMoneda(skin)));
                        break;
                    case "Estrella":
                        int estrellaX = Integer.parseInt(parametros[0]);
                        int estrellaY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPowerUp(fabricaEnt.crearEstrella(estrellaX,estrellaY, fabricaSprite.crearSpriteEstrella(skin)));
                        break;
                    case "Flor de Fuego":
                        int florDeFuegoX = Integer.parseInt(parametros[0]);
                        int florDeFuegoY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPowerUp(fabricaEnt.crearFlorDeFuego(florDeFuegoX,florDeFuegoY, fabricaSprite.crearSpriteFlorDeFuego(skin)));
                        break;
                    case "Super Champinion":
                        int superChampinionX = Integer.parseInt(parametros[0]);
                        int superChampinionY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPowerUp(fabricaEnt.crearSuperChampinion(superChampinionX,superChampinionY, fabricaSprite.crearSpriteSuperChampinion(skin)));
                        break;
                    case "Champinion Verde":
                        int champinionVerdeX = Integer.parseInt(parametros[0]);
                        int champinionVerdeY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPowerUp(fabricaEnt.crearChampinionVerde(champinionVerdeX,champinionVerdeY, fabricaSprite.crearSpriteChampinionVerde(skin)));
                        break;

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nivelActual;
    }


}

