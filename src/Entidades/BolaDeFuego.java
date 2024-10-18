package Entidades;
import GUI.Sprite;
import Logica.Visitor;

public class BolaDeFuego extends Entidad{
    public BolaDeFuego(int x, int y,Sprite[] miSprite){
        super(x,y, miSprite);
    }
    public void mover(){
        
    }
    public void aceptar(Visitor v){
        v.visit(this);
    }
}
