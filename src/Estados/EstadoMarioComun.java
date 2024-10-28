package Estados;
import Entidades.Mario;

public class EstadoMarioComun implements EstadoMario{
    protected Mario m;
    protected static final int paddingTamanio = 0;
    public EstadoMarioComun(Mario mario){
        m = mario;
    }
    public void disparar(){

    }
    public void recibirDanio(){
        m.detenerSonido("musicaLvl"+m.getLogica().getNivel().getNumeroNivel());
        m.reproducirSonido("muerteMario");
        m.morir();
    }
    public boolean puedeRomper(){
        return false;
    }
    public int getModificador(){
        return 0;
    }

    public int getPaddingTamanio() {
        return paddingTamanio;
    }
}
