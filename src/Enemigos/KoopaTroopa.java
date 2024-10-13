package Enemigos;

import java.awt.image.BufferedImage;
import Logica.Visitor;

public abstract class KoopaTroopa extends Enemigo{
    //Atributos (saco estado mientras no este implementado para que no haya tantos errores)
    //protected EstadoKoopaTroopa estadoKoopaTroopa;

    public KoopaTroopa(int x, int y,BufferedImage[] sprite){
        super(x, y,sprite);
    }
    
    public void aceptar(Visitor v){
        v.visit(this);
    }
    
}
