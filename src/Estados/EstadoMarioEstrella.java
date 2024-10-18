package Estados;

import Entidades.Mario;

public class EstadoMarioEstrella implements EstadoMario{
    protected Mario m;
    public EstadoMarioEstrella(Mario mario){
        m = mario;
    }
    public void disparar(){}
    public void recibirDanio(){}
}
