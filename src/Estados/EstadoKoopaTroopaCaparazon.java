package Estados;

import Enemigos.KoopaTroopa;

public class EstadoKoopaTroopaCaparazon implements EstadoKoopaTroopa{
    protected KoopaTroopa k;
    public EstadoKoopaTroopaCaparazon(KoopaTroopa koopaTroopa){
        k = koopaTroopa;
    }
    public void recibirDanio(){
        k.morir();
    }
}
