package Entidades;
import Logica.*;

public class Mario extends Entidad{
    protected EstadoMario estado;
    protected Logica miLogica;

    public Mario(int x, int y){
        super(x,y);
    }
    public void moverDerecha(){
        posicionX += velocidadX;
    }
    public void moverIzquierda(){
        posicionX -= velocidadX;
    }
    public void saltar(){
        posicionY += velocidadY;
    }
    public void recibirDanio(){
        estado.recibirDanio();
    }
    public void disparar(){
        estado.disparar();
    }
    public void chocarBloque(Plataforma bloque){
        
    }
    public void aceptar(Visitor v){
        v.visit(this);
    }
}
