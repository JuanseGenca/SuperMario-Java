package Entidades;
import Fabricas.SpriteFactory;
import GUI.Sprite;
import Logica.*;
import Plataformas.Plataforma;

public class Mario extends Entidad implements EntidadJugador{
    protected EstadoMario estado;
    protected Logica miLogica;
    

    public Mario(int x, int y,Sprite sprite, SpriteFactory sf){
        super(x,y,sprite, sf);
    }

    public void mover(){
        if(direccion!= constantesEntidades.QUIETO || estadoAereo == constantesEntidades.AIRE) {
            if(direccion==constantesEntidades.IZQUIERDA) {
                posicionX-=velocidadX;
                if (posicionX < 0) {
                    posicionX = 0;
                }
            } else if(direccion==constantesEntidades.DERECHA) {
                posicionX+=velocidadX;
            }

            if(estadoAereo == constantesEntidades.AIRE) {
                posicionY += velocidadY;
            }
        }else{
            direccion = 0;
        }

        actualizarHitboxes();
            actualizarSprite();
            actualizar(direccion, estadoAereo);

            actualizarVelocidadXMario();
            if(getEstadoAereo() == constantesEntidades.AIRE) {
                actualizarVelocidadYMario();
            }

    }

    public void recibirDanio(){
        estado.recibirDanio();
    }
    public void disparar(){
        estado.disparar();
    }
    //¿Hace falta?
    public void chocarBloque(Plataforma bloque){
        
    }
    public void aceptar(Visitor v){
        v.visit(this);
    }

    //Vamos a tener que cambiarlo cuando agreguemos colisiones con plataformas, esta implementacion solo funciona si Mario pisa el suelo
    public void tocoSuelo() {
        posicionY = 0;
    }

    @Override
    public int getPuntaje() {
        return 0;
    }
    @Override
    public int getTiempo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get_tiempo'");
    }

    @Override
    public int getVida() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get_vida'");
    }

    public void actualizarVelocidadXMario() {
        double acceleration = 0.5;
        double deceleration = 0.2;
        double maxVelocity = 10;
        double currentVelocity = getVelocidadX();
  
        if (direccion == constantesEntidades.DERECHA) {
            currentVelocity = Math.min(currentVelocity + acceleration, maxVelocity);
        } else if (direccion == constantesEntidades.IZQUIERDA) {
            currentVelocity = Math.min(currentVelocity + acceleration, maxVelocity);
        } else {
            if (currentVelocity > 0) {
                currentVelocity = Math.max(currentVelocity - deceleration, 0);
            } else if (currentVelocity < 0) {
                currentVelocity = Math.min(currentVelocity + deceleration, 0);
            }
  
        }
  
        setVelocidadX(currentVelocity);
    }

    public void actualizarVelocidadYMario() {
        double velInicialSalto = 15;
        double gravedad = -1;
        double velTerminal = -10;
        double velYActual = velocidadY;
        
        if (tocandoSuelo) {
            velYActual = velInicialSalto;
            tocandoSuelo = false;
        } else {
            velYActual = Math.max(velYActual + gravedad, velTerminal);

            if (posicionY < 0) {
                velYActual = 0;
                posicionY = 0;
                tocandoSuelo = true;
                estadoAereo = constantesEntidades.SUELO;
            }
        }

        velocidadY = velYActual;
    }
    
    private void actualizarSprite() {
        Sprite nuevoSprite = miSpriteFactory.getMario();
        if(constantesEntidades.AIRE == estadoAereo) {
            nuevoSprite = miSpriteFactory.getMarioSaltando();
        }
        else if(constantesEntidades.QUIETO == direccion) {
                nuevoSprite = miSpriteFactory.getMario();
            } else if(constantesEntidades.QUIETO != direccion) {
                nuevoSprite = miSpriteFactory.getMarioCaminando();
            }
        
        miSprite = nuevoSprite;
    }
}
