package Plataformas;

import GUI.Sprite;
import Logica.Visitor;

public class LadrilloRompible extends Plataforma{
    public LadrilloRompible(int x, int y,Sprite sprite){
        super(x, y, sprite);
    }
    public void aceptar(Visitor v){
        v.visit(this);
    }
    public void moverDerecha() {
    }
    public void moverIzquierda() {
    }
}
