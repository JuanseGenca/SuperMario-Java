package Enemigos;

import Fabricas.SpriteFactory;
import GUI.Sprite;
import Logica.Visitor;

public class KoopaTroopa extends Enemigo{
    //Atributos (saco estado mientras no este implementado para que no haya tantos errores)
    //protected EstadoKoopaTroopa estadoKoopaTroopa;

    public KoopaTroopa(int x, int y,Sprite sprite, SpriteFactory sf){
        super(x, y,sprite, sf);
    }
    
    public void aceptar(Visitor v){
        v.visit(this);
    }
    
}
