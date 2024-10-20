package Enemigos;

import Estados.EstadoKoopaTroopa;
//import Estados.EstadoKoopaTroopa;
import GUI.Sprite;
import Logica.Visitor;

public class KoopaTroopa extends Enemigo{
    //Atributos (saco estado mientras no este implementado para que no haya tantos errores)
    //protected EstadoKoopaTroopa estadoKoopaTroopa;

    public KoopaTroopa(int x, int y,Sprite[] sprite){
        super(x, y,sprite);
    }
    
    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }
    public void setEstado(EstadoKoopaTroopa e){
        //estadoKoopaTroopa = e;
    }
}
