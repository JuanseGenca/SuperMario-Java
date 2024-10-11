import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

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

    

    public Nivel cargarNivel(int nivel,String skin){
        Nivel nivelActual = new Nivel();
        if(nivel == 1)
            nivelActual = generarNivel1(skin);
        else {
            if (nivel == 2)
                nivelActual = generarNivel2(skin);
            else
                nivelActual = generarNivel3(skin);
        }
        return nivelActual;
    }

    protected Nivel generarNivel1(String skin){
        Nivel nivelGenerado = new Nivel();//que parametros paso?

        nivelGenerado.agregarMario(fabricaEnt.crearMario(2,2,fabricaSprite.crearSpriteMario(skin)));
        
        for(int i=0;i<10;i++){
            nivelGenerado.agregarPlataforma(fabricaEnt.crearBloqueSolido(i,1));
        }

        for(int i=6;i<9;i++){
            nivelGenerado.agregarPlataforma(fabricaEnt.crearBloqueSolido(i,4));
        }
        
        nivelGenerado.agregarEnemigo(fabricaEnt.crearGoomba(4,2,skin));
        nivelGenerado.agregarEnemigo(fabricaEnt.crearGoomba(7,2,skin));
        
       return nivelGenerado;

    }

}

