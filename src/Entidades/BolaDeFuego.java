package Entidades;
import Enemigos.Enemigo;
import GUI.Sprite;
import Logica.Visitor;
import Visitors.VisitorBolaDeFuego;

public class BolaDeFuego extends Enemigo{
    
    private long tiempoCreacion;
    private long tiempoVida;

    public BolaDeFuego(int x, int y, Sprite[] miSprite, Mario mario){
        super(x, y, miSprite);
        this.velocidadX = 7; 
        this.velocidadY = 0;
        visitor = new VisitorBolaDeFuego(mario);
        tiempoVida = 3000;
        tiempoCreacion = System.currentTimeMillis();
        posicionY = posicionY - 40;

    }
    
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
