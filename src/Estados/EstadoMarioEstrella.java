package Estados;

import Entidades.Mario;

public class EstadoMarioEstrella implements EstadoMario{
    
    protected Mario m;
    protected static final int paddingTamanio = 48;
    
    public EstadoMarioEstrella(Mario mario){
        m = mario;
    }
    
    public void disparar(){}
    
    public void recibirDanio(){
        
    }
    
    public boolean puedeRomper(){
        return true;
    }

    public int getPaddingTamanio() {
        return paddingTamanio;
    }
    @Override
    public int getModificador() {
        return 9;
    }
}
