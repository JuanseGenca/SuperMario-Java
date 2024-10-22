package Enemigos;
import GUI.Sprite;
import Logica.Visitor;

public class Spiny extends Enemigo{
    public Spiny(int x, int y,Sprite[] sprite){
        super(x,y,sprite);
        puntaje=60;
    }
   
    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }
}
