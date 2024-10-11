package ParseInt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Parserint {
    protected int nivel;
    protected String skin;
    protected FabricaEntidades fabrica;

    public Parserint(int nivel,String skin,FabricaEntidades fabrica){
        this.nivel=nivel;
        this.skin=skin;
        this.fabrica=fabrica;
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


}

