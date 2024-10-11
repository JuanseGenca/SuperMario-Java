package Plataformas;

import Logica.Visitor;

public class LadrilloRompible extends Plataforma{
    public LadrilloRompible(int x, int y){
        super(x, y);
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
