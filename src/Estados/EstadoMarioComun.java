package Estados;
import Entidades.Mario;

public class EstadoMarioComun implements EstadoMario{
    protected Mario m;
    public EstadoMarioComun(Mario mario){
        m = mario;
    }
    public void disparar(){

    }
    public void recibirDanio(){
        m.morir();
    }
    public boolean puedeRomper(){
        return false;
    }
}
