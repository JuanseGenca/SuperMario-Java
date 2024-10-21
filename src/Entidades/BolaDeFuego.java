package Entidades;
import GUI.Sprite;
import Logica.Visitor;
import Visitors.VisitorBolaDeFuego;

public class BolaDeFuego extends Entidad{
    private double angulo;
    private double velocidadAngular;
    private double amplitud;
    public BolaDeFuego(int x, int y,Sprite[] miSprite){
        super(x,y, miSprite);
        this.velocidadX = 5; // Velocidad horizontal constante
        this.amplitud = 50;  // Amplitud del movimiento cosenoidal
        this.velocidadAngular = 0.1; // Velocidad del cambio de ángulo
        this.angulo = 0; // Ángulo inicial
        visitor = new VisitorBolaDeFuego();
    }
    @Override
    public void mover(){
        posicionX += velocidadX;
        
        // Movimiento vertical basado en el coseno del ángulo
        posicionY = (int) (posicionY + amplitud * Math.cos(angulo));
        
        // Incrementar el ángulo para el próximo frame
        angulo += velocidadAngular;
        
        // Actualizar las hitboxes
        miHitboxes.actualizarHitboxes(posicionX, posicionY, ancho, alto);
        System.out.println("Posición X: " + posicionX + ", Posición Y: " + posicionY);
        
    }
    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }
}
