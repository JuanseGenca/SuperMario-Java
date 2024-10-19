package Estados;

import Entidades.Mario;

public class EstadoSuperMario implements EstadoMario{
    protected Mario m;
    public EstadoSuperMario(Mario mario){
        m = mario;
    }
    public void disparar(){

    }
    public void recibirDanio(){
        m.setEstado(new EstadoMarioComun(m));
    }
    public boolean puedeRomper(){
        return true;
    }
}
