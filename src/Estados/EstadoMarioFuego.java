package Estados;

import Entidades.BolaDeFuego;
import Logica.ConstantesEntidades;
import Entidades.ManejadorEntidades;
import Entidades.Mario;

public class EstadoMarioFuego implements EstadoMario{
    
    protected Mario m;
    protected static final int paddingTamanio = 48;
    
    public EstadoMarioFuego(Mario mario){
        m = mario;
    }
    public void disparar(){
        int posX = m.getPosicionX();
        int posY = m.getPosicionY();
        m.reproducirSonido("bolaFuego");

        BolaDeFuego bola = ManejadorEntidades.getInstancia().crearBolaDeFuego(posX,posY, m);

        if (m.getDirTick() == ConstantesEntidades.IZQUIERDA) { // Si Mario está mirando hacia la izquierda
            bola.setVelocidadX(-Math.abs(bola.getVelocidadX())); // Asegurarse de que la velocidad X sea negativa
        } else { 
            if(m.getDirTick() == ConstantesEntidades.DERECHA)
                bola.setVelocidadX(Math.abs(bola.getVelocidadX())); // Asegurarse de que la velocidad X sea positiva
        }
        
    }
    public void recibirDanio(){
        m.setEstado(new EstadoMarioComun(m));
        m.reproducirSonido("danioMario");
        m.aplicarGravedad();
    }
    public boolean puedeRomper(){
        return true;
    }
    public int getModificador(){
        return 6;
    }

    public int getPaddingTamanio() {
        return paddingTamanio;
    }
}
