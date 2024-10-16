package Entidades;
import GUI.Sprite;
import Logica.*;
import Plataformas.Plataforma;

public class Mario extends Entidad implements EntidadJugador{
    protected EstadoMario estado;
    protected Logica miLogica;
    

    public Mario(int x, int y,Sprite sprite){
        super(x,y,sprite);
    }
    public void mover(){
        if(direccion!= QUIETO || estadoAereo == AIRE) {
            if(direccion==IZQUIERDA) {
                posicionX-=velocidadX;
            } else if(direccion==DERECHA) {
                posicionX+=velocidadX;
            }

            if(estadoAereo == AIRE) {
                System.out.println("actualizo posicion Mario");
                System.out.println("Velocidad Mario Y:"+velocidadY);
                posicionY += velocidadY;
            }

            actualizar();
        }

        System.err.println("X: "+posicionX+" Y: "+posicionY);
        System.err.println("Direccion:"+direccion);
        System.err.println("Estado:"+estadoAereo);
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

    //Vamos a tener que cambiarlo cuando agreguemos colisiones con plataformas, esta implementacion solo funciona si Mario pisa el suelo
    public void tocoSuelo() {
        posicionY = 0;
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
    
}
