package Entidades;
import GUI.Sprite;
import Logica.Visitor;
import Visitors.VisitorBolaDeFuego;

public class BolaDeFuego extends Entidad{
    public BolaDeFuego(int x, int y,Sprite[] miSprite){
        super(x,y, miSprite);
        visitor = new VisitorBolaDeFuego();
    }
    public void mover(){
        
    }
    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }
}
