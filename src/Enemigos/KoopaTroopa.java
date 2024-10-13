package Enemigos;

import GUI.Sprite;
import Logica.Visitor;

public abstract class KoopaTroopa extends Enemigo{
    //Atributos
    protected EstadoKoopaTroopa estadoKoopaTroopa;

    public KoopaTroopa(int x, int y,Sprite sprite){
        super(x, y,sprite);
    }
    
    public void aceptar(Visitor v){
        v.visit(this);
    }
    
}
