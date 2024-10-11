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
                String modoDeJuego = parametros[2];
                switch (tipo) {
                    case "Mario":
                        int marioX = Integer.parseInt(parametros[0]);
                        int marioY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarMario(fabricaEnt.crearMario(marioX, marioY, fabricaSprite.crearSpriteMario(modoDeJuego)));
                        break;

                    case "Bloque Solido":
                        int bloqueSolidoX = Integer.parseInt(parametros[0]);
                        int bloqueSolidoY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPlataforma(fabricaEnt.crearBloqueSolido(bloqueSolidoX, bloqueSolidoY,fabricaSprite.crearSpriteBloqueSolido(modoDeJuego)));
                        break;

                    case "Goomba":
                        int goombaX = Integer.parseInt(parametros[0]);
                        int goombaY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarEnemigo(fabricaEnt.crearGoomba(goombaX, goombaY, fabricaSprite.crearSpriteGoomba(modoDeJuego)));
                        break;
                    case "Tuberia":
                        int tuberiaX = Integer.parseInt(parametros[0]);
                        int tuberiaY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPlataforma(fabricaEnt.crearTuberia(tuberiaX,tuberiaY,fabricaSprite.crearSpriteTuberia(modoDeJuego)));
                        break;
                    case "Ladrillo Solido":
                        int ladrilloX = Integer.parseInt(parametros[0]);
                        int ladrilloY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPlataforma(fabricaEnt.crearLadrilloSolido(ladrilloX,ladrilloY,fabricaSprite.crearSpriteLadrilloSolido(modoDeJuego)));
                        break;
                    case "Meta":
                        int metaX = Integer.parseInt(parametros[0]);
                        int metaY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPlataforma(fabricaEnt.crearMeta(metaX,metaY,fabricaSprite.crearSpriteMeta(modoDeJuego)));
                        break;
                    case "Vacio":
                        int vacioX = Integer.parseInt(parametros[0]);
                        int vacioY = Integer.parseInt(parametros[1]);
                        nivelActual.agregarPlataforma(fabricaEnt.crearVacio(vacioX,vacioY,fabricaSprite.crearSpriteVacio(modoDeJuego)));
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nivelActual;
    }


}

