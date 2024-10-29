package Estados;

import Enemigos.KoopaTroopa;
import Visitors.VisitorKoopaTroopa;

public class EstadoKoopaTroopaCaparazon implements EstadoKoopaTroopa{
    protected KoopaTroopa k;
    protected boolean vulnerable = true;
    
    public EstadoKoopaTroopaCaparazon(KoopaTroopa koopaTroopa){
        k = koopaTroopa;
        k.setVelocidadX(0);
        k.setVisitor(new VisitorKoopaTroopa(k));
    }
    public void recibirDanio(){
        if(k.getVelocidadX() == 0) {
            k.setVelocidadX(10);   
            vulnerable = false;
        }
        else {
            k.setVelocidadX(0);   
            vulnerable = true;
        }
        
    }

    public boolean esVulnerable() {
        return vulnerable;
    }
}
