package Estados;

import Entidades.Mario;

public class EstadoSuperMario implements EstadoMario{
    protected Mario m;
    protected static final int paddingTamanio = 48;
    public EstadoSuperMario(Mario mario){
        m = mario;
    }
    public void disparar(){

    }
    public void recibirDanio(){
        m.setEstado(new EstadoMarioComun(m));
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
