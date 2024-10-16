package Plataformas;

import Fabricas.SpriteFactory;
import GUI.Sprite;
import Logica.Visitor;

public class LadrilloRompible extends Plataforma{
    public LadrilloRompible(int x, int y,Sprite sprite, SpriteFactory sf){
        super(x, y, sprite, sf);
    }
    public void aceptar(Visitor v){
        v.visit(this);
    }
    public void mover(){
        
    }
}
