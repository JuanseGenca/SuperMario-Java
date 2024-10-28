package Estados;

import Enemigos.KoopaTroopa;
import Visitors.VisitorKoopaTroopa;

public class EstadoKoopaTroopaCaparazon implements EstadoKoopaTroopa{
    protected KoopaTroopa k;
    public EstadoKoopaTroopaCaparazon(KoopaTroopa koopaTroopa){
        k = koopaTroopa;
        k.setVelocidadX(0);
        k.setVisitor(new VisitorKoopaTroopa(k));
    }
    public void recibirDanio(){
        k.setVelocidadX(10);
        
    }
}
