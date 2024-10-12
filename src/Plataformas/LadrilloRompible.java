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
    @Override
    public void moverDerecha() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moverDerecha'");
    }
    @Override
    public void moverIzquierda() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moverIzquierda'");
    }
}
