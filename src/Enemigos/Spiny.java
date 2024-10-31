package Enemigos;
import GUI.Sprite;
import Logica.Visitor;
import Visitors.VisitorSpiny;

public class Spiny extends Enemigo{
    protected int dirTickAnterior;
    public Spiny(int x, int y,Sprite[] sprite){
        super(x,y,sprite);
        puntaje=60;
        visitor=new VisitorSpiny(this);
        tocandoSuelo = false;
        //estadoAereo = ConstantesEntidades.AIRE;
        //dirTickAnterior = ConstantesEntidades.IZQUIERDA;
    }
   
    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }

    @SuppressWarnings("override")
    public void recibirDanio(int puntaje) {
        velocidadX = 0;
        spriteActual = misSprites[0];
        actualizar(direccion, estadoAereo);
     }
}
