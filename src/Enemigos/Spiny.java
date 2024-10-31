package Enemigos;
import GUI.Sprite;
import Logica.Visitor;
import Visitors.VisitorSpiny;

public class Spiny extends Enemigo{
    
    public Spiny(int x, int y,Sprite[] sprite){
        super(x,y,sprite);
        puntaje=60;
        visitor=new VisitorSpiny(this);
        tocandoSuelo = false;
    }
   
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }

    public void recibirDanio(int puntaje) {
        velocidadX = 0;
        spriteActual = misSprites[0];
        actualizar(direccion, estadoAereo);
     }
}
