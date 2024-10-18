package Estados;

import Enemigos.KoopaTroopa;

public class EstadoKoopaTroopaNormal implements EstadoKoopaTroopa{
    protected KoopaTroopa k;
    public EstadoKoopaTroopaNormal(KoopaTroopa koopaTroopa){
        k = koopaTroopa;
    }
    public void recibirDanio(){
        k.setEstado(new EstadoKoopaTroopaCaparazon(k));
    }
}
