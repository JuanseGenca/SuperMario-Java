package Enemigos;

import Estados.EstadoKoopaTroopa;
import Estados.EstadoKoopaTroopaNormal;
import GUI.Sprite;
import Logica.Visitor;

public class KoopaTroopa extends Enemigo{
    //Atributos (saco estado mientras no este implementado para que no haya tantos errores)
    protected EstadoKoopaTroopa estadoKoopaTroopa;

    public KoopaTroopa(int x, int y,Sprite[] sprite){
        super(x, y,sprite);
        puntaje=90;
        estadoKoopaTroopa = new EstadoKoopaTroopaNormal(this);
    }
    
    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }
    public void setEstado(EstadoKoopaTroopa e){
        estadoKoopaTroopa = e;
    }
    public void recibirDanio(){
        //System.out.println("xd");
        velocidadX = 0;
        spriteActual = misSprites[1];
        actualizar(direccion, estadoAereo);
        estadoKoopaTroopa.recibirDanio();
        
    }
}
