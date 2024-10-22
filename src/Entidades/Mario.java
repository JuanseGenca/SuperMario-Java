package Entidades;

import Estados.*;
import GUI.Sprite;
import Logica.*;
import Visitors.VisitorMario;
import java.util.Timer;
import java.util.TimerTask;

//import Plataformas.Plataforma;

public class Mario extends Entidad implements EntidadJugador{
    protected EstadoMario estado;
    protected Logica miLogica;
    private int dirTickAnterior;
    protected boolean invencible;
    

    public Mario(int x, int y,Sprite[] sprites){
        super(x,y,sprites);
        estado = new EstadoMarioComun(this);
        tocandoSuelo = true;
        estadoAereo = ConstantesEntidades.SUELO;
        visitor= new VisitorMario(this);
    }

    @Override
    public void mover(){
        
        moverX();

        actualizarSprite();
        int direccionSprite = getDireccionSpriteMario();
        actualizar(direccionSprite, estadoAereo);
        miHitboxes.actualizarHitboxes(posicionX, posicionY - estado.getPaddingTamanio(), ancho, alto);

        actualizarVelocidadXMario();
        if(getEstadoAereo() == ConstantesEntidades.AIRE) {
            actualizarVelocidadYMario();
        }
    }

    private void moverX() {
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
    }

    public void aplicarGravedad() {
        double gravedad = -0.1;
        double velTerminal = -8;
        double velYActual = velocidadY;
        velocidadY = Math.max(velYActual + gravedad, velTerminal);
        estadoAereo = ConstantesEntidades.AIRE;
        tocandoSuelo = false;

        if(posicionY <= 0) {
            posicionY = posicionY + 0;
            tocandoSuelo = true;
            estadoAereo = ConstantesEntidades.SUELO;
        } else {posicionY += velocidadY;}
    }

    @Override
    public void recibirDanio(){
        if(!invencible){
            estado.recibirDanio();
            establecerInvencibilidad();
        } 
    }

    private void establecerInvencibilidad() {
        invencible = true;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                invencible =false;
            }
        }, 500); // 0.5 segundos
    }

    public void disparar(){
        estado.disparar();
    }

    public void aniadirVida() {
        miLogica.actualizarVida(1);
    }

    public void aniadirMoneda() {
        miLogica.aniadirMoneda();
    }
    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }

    //como no tengo formar de recibir el Y de la plataforma, asumo que la plataforma sigue el estandar de un bloque = 48px
    //mejorable si encontramos la forma de pasarle la posicion de la plataforma
    public void tocoSuelo() {
        velocidadY = 0;
        posicionY = alto + (posicionY - posicionY % 48) - estado.getPaddingTamanio();
        establecerEstadoAereo(ConstantesEntidades.SUELO);
        tocandoSuelo = true;
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
        double maxVelocity = 5;
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
        double velInicialSalto = 8;
        double gravedad = -0.1;
        double velTerminal = -8;
        double velYActual = velocidadY;
        
        if (tocandoSuelo) {
            velYActual = velInicialSalto;
            tocandoSuelo = false;
        } else {
            velYActual = Math.max(velYActual + gravedad, velTerminal);
            if (miHitboxes.getHitbox().getY() < 0) {
                velYActual = 0;
                posicionY = estado.getPaddingTamanio();
                tocandoSuelo = true;
                estadoAereo = ConstantesEntidades.SUELO;
                posicionY = posicionY + 0;
            }
        }

        velocidadY = velYActual;
    }
    
    public void actualizarEstadoMario(int powerUp) {
        //Una vez implementados los estados especiales. Conectar, Creo que con el setEstado ya alcanza.
    }

    private void actualizarSprite() {
        Sprite nuevoSprite = misSprites[ConstantesEntidades.SPRITEQUIETO + estado.getModificador()];

        if(ConstantesEntidades.AIRE == estadoAereo) {
            nuevoSprite = misSprites[ConstantesEntidades.SPRITESALTAR + estado.getModificador()];
        }
        else if(ConstantesEntidades.QUIETO == direccion) {
                nuevoSprite = misSprites[ConstantesEntidades.SPRITEQUIETO + estado.getModificador()];
            } else if(ConstantesEntidades.QUIETO != direccion) {
                nuevoSprite = misSprites[ConstantesEntidades.SPRITECAMINAR + estado.getModificador()];
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
        int paddingAnterior = estado.getPaddingTamanio();
        estado = m;
        int paddingReal =  m.getPaddingTamanio() - paddingAnterior;
        posicionY = posicionY + paddingReal;
        actualizarSprite();
        alto = spriteActual.getHeight();
        ancho = spriteActual.getWidth();
        
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
    
    public void setLogica(Logica l){
        miLogica = l;
    }

    @Override
    public int getMonedas() {
        return miLogica.getMonedas();
    } 

    public void morir(){
        miLogica.reiniciarNivel();
    }
    
}
