package Entidades;
import Enemigos.Enemigo;
import GUI.Sprite;
import Logica.Visitor;
import Visitors.VisitorBolaDeFuego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class BolaDeFuego extends Enemigo{
    private Timer timer;
    private long tiempoCreacion;
    private long tiempoVida;
    private int desplazamientoY;
    private double gravedad = 0.8;
    private Mario mario;

    public BolaDeFuego(int x, int y,Sprite[] miSprite, Mario mario){
        this.mario = mario;
        super(x,y, miSprite);
        this.velocidadX = 2; 
        this.velocidadY = 0;
        visitor = new VisitorBolaDeFuego(mario);
        tiempoVida = 3000;
        tiempoCreacion = System.currentTimeMillis();
        posicionY = posicionY - 40;

    }
    @Override
    public void mover(){
        posicionX += velocidadX;
        
        if (seDebeEliminar()) {
            ManejadorEntidades.getInstancia().eliminarBolaDeFuego(this);
            miObserver.eliminar();
        }

        miHitboxes.actualizarHitboxes(posicionX, posicionY, ancho, alto);
        actualizarSprite();
    }   

        
    
    
    public void actualizarSprite() {
        if (miObserver != null) {
            miObserver.actualizar(posicionX, posicionY);
        }
    }
    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }

    public boolean seDebeEliminar(){
        return System.currentTimeMillis() - tiempoCreacion >= tiempoVida;
    }

    public void eliminar(){
        spriteActual = misSprites[1];
        actualizar(direccion, estadoAereo);
        ManejadorEntidades.getInstancia().eliminarBolaDeFuego(this);
        miObserver.eliminar();
    }
}
