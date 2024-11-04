package Estados;

import Entidades.Mario;
import Visitors.ConstantesPowerUp;

public class EstadoMarioComun implements EstadoMario{

    protected Mario m;
    protected static final int paddingTamanio = 0;

    public EstadoMarioComun(Mario mario){
        m = mario;
    }

    public void disparar(){
    }

    public void recibirDanio(int puntaje){
        m.detenerSonido(m.getLogica().getNivel().getNumeroNivel());
        m.actualizarPuntaje(-puntaje);
        m.morir();
    }

    public boolean puedeRomper(){
        return false;
    }
    
    public int getModificador(){
        return ConstantesPowerUp.NORMAL;
    }

    public int getPaddingTamanio() {
        return paddingTamanio;
    }
}
