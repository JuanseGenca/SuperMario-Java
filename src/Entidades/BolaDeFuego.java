package Entidades;
import Logica.Visitor;

public class BolaDeFuego extends Entidad{
    public BolaDeFuego(int x, int y){
        super(x,y);
    }
    public void mover(){
        
    }
    public void aceptar(Visitor v){
        v.visit(this);
    }
}
