package Estados;

import Entidades.BolaDeFuego;
import Entidades.ManejadorEntidades;
import Entidades.Mario;
import Fabricas.SpriteFactory;
import GUI.ObserverEntidades;
import GUI.Sprite;

public class EstadoMarioFuego implements EstadoMario{
    
    protected Mario m;
    protected static final int paddingTamanio = 48;
    
    public EstadoMarioFuego(Mario mario){
        m = mario;
    }
    public void disparar(){
        int posX = m.getPosicionX();
        int posY = m.getPosicionY();

        BolaDeFuego bola = ManejadorEntidades.getInstancia().crearBolaDeFuego(posX,posY);
        ManejadorEntidades.getInstancia().agregarBolaDeFuego(bola);
        
    }
    public void recibirDanio(){
        m.setEstado(new EstadoMarioComun(m));
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
