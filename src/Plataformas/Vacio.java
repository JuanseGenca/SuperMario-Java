package Plataformas;

import GUI.Sprite;
import Logica.Visitor;

public class Vacio extends Plataforma{
    public Vacio(int x,int y,Sprite sprite){
        super(x,y, sprite);
    }
    public void aceptar(Visitor v){
        v.visit(this);
    }
    public void mover(){
        
    }

}
