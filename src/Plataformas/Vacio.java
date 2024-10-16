package Plataformas;

import Fabricas.SpriteFactory;
import GUI.Sprite;
import Logica.Visitor;

public class Vacio extends Plataforma{
    public Vacio(int x,int y,Sprite sprite, SpriteFactory sf){
        super(x,y, sprite, sf);
    }
    public void aceptar(Visitor v){
        v.visit(this);
    }
    public void mover(){
        
    }

}
