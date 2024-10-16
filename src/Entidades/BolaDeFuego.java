package Entidades;
import Fabricas.SpriteFactory;
import GUI.Sprite;
import Logica.Visitor;

public class BolaDeFuego extends Entidad{
    public BolaDeFuego(int x, int y,Sprite miSprite, SpriteFactory sf){
        super(x,y, miSprite, sf);
    }
    public void mover(){
        
    }
    public void aceptar(Visitor v){
        v.visit(this);
    }
}
