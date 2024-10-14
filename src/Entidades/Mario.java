package Entidades;
import Logica.*;
import Plataformas.Plataforma;

import GUI.Sprite;

public class Mario extends Entidad implements EntidadJugador{
    protected EstadoMario estado;
    protected Logica miLogica;

    public Mario(int x, int y,Sprite sprite){
        super(x,y,sprite);
    }
    //Hay que ver si conviene ponerlo en mario y para cada entidad mover() se comporta de forma diferente
    //O si conviene hacer mover() en clase entidad y que todas se muevan igual.
    public void mover(){
        
    }

    

    public void saltar(){
    }

    public void recibirDanio(){
        estado.recibirDanio();
    }
    public void disparar(){
        estado.disparar();
    }
    //¿Hace falta?
    public void chocarBloque(Plataforma bloque){
        
    }
    public void aceptar(Visitor v){
        v.visit(this);
    }
    @Override
    public int getPuntaje() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get_puntaje'");
    }
    @Override
    public int getTiempo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get_tiempo'");
    }
    @Override
    public int getVida() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get_vida'");
    }
}
