package Entidades;
import Estados.*;
//import Estados.EstadoMario;
//import Estados.EstadoMarioComun;
//import Fabricas.SpriteFactory;
import GUI.Sprite;
import Logica.*;
import Visitors.VisitorMario;
//import Plataformas.Plataforma;

public class Mario extends Entidad implements EntidadJugador{
    protected EstadoMario estado;
    protected Logica miLogica;
    private int dirTickAnterior;
    protected int monedas;
    

    public Mario(int x, int y,Sprite[] sprites){
        super(x,y,sprites);
        estado = new EstadoMarioComun(this);
        monedas=0;
        visitor= new VisitorMario();
    }

    @Override
    public void mover(){
        if(direccion != ConstantesEntidades.QUIETO || estadoAereo == ConstantesEntidades.AIRE) {
            if(direccion==ConstantesEntidades.IZQUIERDA) {
                posicionX-=velocidadX;
                dirTickAnterior = ConstantesEntidades.IZQUIERDA;
                if (posicionX < 0) {
                    posicionX = 0;
                }
            } else if(direccion==ConstantesEntidades.DERECHA) {
                posicionX+=velocidadX;
                dirTickAnterior = ConstantesEntidades.DERECHA;
            }

            if(estadoAereo == ConstantesEntidades.AIRE) {
                posicionY += velocidadY;
            }
        }else{
            direccion = ConstantesEntidades.QUIETO;
        }

        miHitboxes.actualizarHitboxes(posicionX, posicionY, ancho, alto);
        actualizarSprite();
        int direccionSprite = getDireccionSpriteMario();
        actualizar(direccionSprite, estadoAereo);

        actualizarVelocidadXMario();
        if(getEstadoAereo() == ConstantesEntidades.AIRE) {
            actualizarVelocidadYMario();
        }
    }

    @Override
    public void recibirDanio(){
        estado.recibirDanio();
    }
    public void disparar(){
        estado.disparar();
    }

    public void aniadirVida() {
        miLogica.actualizarVida(1);
    }

    public void aniadirMoneda() {
        //Como llega esto a nivel?
        //Esta seria la logica de monedas. Si va aca, borrar comentarios. Sino mover a la clase correspondiente
        monedas++;
        if(monedas==100) {
            miLogica.actualizarVida(1);
            monedas=0;
        }
    }
    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
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
    public int getVidas() {
        return miLogica.getVidas();
    }

    public void actualizarVelocidadXMario() {
        double acceleration = 0.5;
        double deceleration = 0.2;
        double maxVelocity = 10;
        double currentVelocity = getVelocidadX();
  
        switch (direccion) {
            case ConstantesEntidades.DERECHA -> currentVelocity = Math.min(currentVelocity + acceleration, maxVelocity);
            case ConstantesEntidades.IZQUIERDA -> currentVelocity = Math.min(currentVelocity + acceleration, maxVelocity);
            default -> {
                if (currentVelocity > 0) {
                    currentVelocity = Math.max(currentVelocity - deceleration, 0);
                } else if (currentVelocity < 0) {
                    currentVelocity = Math.min(currentVelocity + deceleration, 0);
                }
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
                estadoAereo = ConstantesEntidades.SUELO;
            }
        }

        velocidadY = velYActual;
    }
    
    public void actualizarEstadoMario(int powerUp) {
        //Una vez implementados los estados especiales. Conectar, Creo que con el setEstado ya alcanza.
    }

    private void actualizarSprite() {
        Sprite nuevoSprite = misSprites[ConstantesEntidades.SPRITEQUIETO];

        if(ConstantesEntidades.AIRE == estadoAereo) {
            nuevoSprite = misSprites[ConstantesEntidades.SPRITESALTAR];
        }
        else if(ConstantesEntidades.QUIETO == direccion) {
                nuevoSprite = misSprites[ConstantesEntidades.SPRITEQUIETO];
            } else if(ConstantesEntidades.QUIETO != direccion) {
                nuevoSprite = misSprites[ConstantesEntidades.SPRITECAMINAR];
            }
        
        spriteActual = nuevoSprite;
    }
    @Override
    public int getDireccion(){
        return direccion;
    }

    public EstadoMario getEstado(){
        return estado;
    }

    public void setEstado(EstadoMario m){
        estado = m;
    }

    private int getDireccionSpriteMario() {
        int devolver = ConstantesEntidades.QUIETO;
        
        if(dirTickAnterior == ConstantesEntidades.IZQUIERDA) {
            devolver = ConstantesEntidades.IZQUIERDA;
        }

        if(dirTickAnterior == ConstantesEntidades.DERECHA) {
            devolver = ConstantesEntidades.DERECHA;
        }

        return devolver;
    }
}
