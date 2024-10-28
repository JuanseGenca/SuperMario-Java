package Estados;

import Enemigos.KoopaTroopa;

public class EstadoKoopaTroopaCaparazon implements EstadoKoopaTroopa{
    protected KoopaTroopa k;
    public EstadoKoopaTroopaCaparazon(KoopaTroopa koopaTroopa){
        k = koopaTroopa;
        k.setVelocidadX(0);
    }
    public void recibirDanio(){
        k.setVelocidadX(10);
        
    }
}
