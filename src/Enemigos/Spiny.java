package Enemigos;
import Logica.Visitor;
import GUI.Sprite;

public class Spiny extends Enemigo{
    public Spiny(int x, int y,Sprite[] sprite){
        super(x,y,sprite);
    }
   
    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }
}
