package Entidades;
import Enemigos.Enemigo;
import GUI.Sprite;
import Logica.Visitor;
import Visitors.VisitorBolaDeFuego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class BolaDeFuego extends Enemigo{
    private double angulo;
    private double velocidadAngular;
    private double amplitud;
    private int colisionesConEjeX;
    private static final int ALTURA_BASE = 0;
    private static final int MAX_COLISIONES = 6;
    private boolean canCollide = true;
    private Timer timer;

    public BolaDeFuego(int x, int y,Sprite[] miSprite){
        super(x,y, miSprite);
        this.velocidadX = 5; 
        this.amplitud = 30;  
        this.velocidadAngular = 0.10; 
        this.angulo = 0;
        colisionesConEjeX = 0; 
        visitor = new VisitorBolaDeFuego();

        timer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canCollide = true;
            }
        });
        timer.setRepeats(false);
    }
    @Override
    public void mover(){
        posicionX += velocidadX;

        double frequencia = 2.0;
        posicionY = (int) (ALTURA_BASE - (amplitud * Math.cos(frequencia * angulo)));

        // Verificar si la bola ha tocado el suelo
        if (posicionY >= ALTURA_BASE && canCollide) {
            colisionesConEjeX++;
            posicionY = ALTURA_BASE;
    
            canCollide = false;
            timer.start(); 
        

        // Verificar si se ha alcanzado el límite de colisiones
            if (seDebeEliminar()) {
                ManejadorEntidades.getInstancia().eliminarBolaDeFuego(this);
            }
        }   

        // Incrementar el ángulo para el movimiento coseno
        angulo += velocidadAngular;

        // Actualizar hitboxes y sprite
        miHitboxes.actualizarHitboxes(posicionX, posicionY, ancho, alto);
        actualizarSprite();
        System.out.println("Posición X: " + posicionX + ", Posición Y: " + posicionY);
        
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
        return colisionesConEjeX >= MAX_COLISIONES;
    }
}
