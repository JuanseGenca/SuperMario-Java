package Entidades;
import Logica.*;
import Plataformas.Plataforma;

import GUI.Sprite;

public class Mario extends Entidad implements EntidadJugador{
    protected EstadoMario estado;
    protected Logica miLogica;
    protected static final int ARRIBA = 15000;
    protected static final int ABAJO = 15001;
    protected static final int IZQUIERDA = 15002;
    protected static final int DERECHA = 15003;

    public Mario(int x, int y,Sprite sprite){
        super(x,y,sprite);
    }
    public void mover(){
        if(direccion!=0) {
            if(direccion==IZQUIERDA) {
                System.out.println("posicionX despues de moverme a izquierda: "+posicionX);
                posicionX-=velocidad;
                System.out.println("posicionX antes de moverme a izquierda: "+posicionX);
            } else if(direccion==DERECHA) {
                System.out.println("posicionX despues de moverme a derecha: "+posicionX);
                posicionX+=velocidad;
                System.out.println("posicionX despues de moverme a derecha: "+posicionX);
            }
            else if(direccion==ARRIBA) {
                System.out.println("posicionX despues de moverme a derecha: "+posicionX);
                posicionY+=velocidad;
                System.out.println("posicionX despues de moverme a derecha: "+posicionX);
            }
            actualizar();
        } 
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
        return 0;
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

    public void setVelocidad(int velocidad) {
       this.velocidad=velocidad;
    }
    
}
