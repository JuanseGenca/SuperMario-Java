package Estados;

import Entidades.Mario;
import Logica.ConstantesSonidos;

public class EstadoSuperMario implements EstadoMario{

    protected Mario m;
    protected static final int paddingTamanio = 48;

    public EstadoSuperMario(Mario mario){
        m = mario;
    }

    public void disparar(){
    }

    public void recibirDanio(int puntaje){
        m.setEstado(new EstadoMarioComun(m));
        m.reproducirSonido(ConstantesSonidos.DANIOMARIO);
        m.aplicarGravedad();
    }

    public boolean puedeRomper(){
        return true;
    }
    
    public int getModificador(){
        return 3;
    }

    public int getPaddingTamanio() {
        return paddingTamanio;
    }
}
