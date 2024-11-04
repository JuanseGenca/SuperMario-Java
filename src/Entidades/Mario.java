package Entidades;

import Estados.*;
import GUI.Sprite;
import Logica.*;
import Visitors.VisitorMario;
import java.util.Timer;
import java.util.TimerTask;

public class Mario extends Entidad implements EntidadJugador{
    
    protected EstadoMario estado;
    protected Logica miLogica;
    private int dirTickAnterior;
    protected boolean invencible;
    public boolean cayoAlVacio;

    public Mario(int posicionX, int posicionY,Sprite[] sprites){
        super(posicionX,posicionY,sprites);
        estado = new EstadoMarioComun(this);
        tocandoSuelo = true;
        estadoAereo = ConstantesEntidades.SUELO;
        visitor= new VisitorMario(this);
        cayoAlVacio = false;
    }

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
        double velTerminal = -10;
        

        if(velocidadY == 0) {
            double velYActual = velocidadY;
            velocidadY = Math.max(velYActual + gravedad, velTerminal);
            estadoAereo = ConstantesEntidades.AIRE;
            tocandoSuelo = false;
            if(posicionY <= 0 && !cayoAlVacio) {
                tocandoSuelo = true;
                estadoAereo = ConstantesEntidades.SUELO;
            } else {posicionY += velocidadY;}
        }
    }

    public void recibirDanio(int puntaje){
        if(!invencible){
            estado.recibirDanio(puntaje);
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
        }, 700);
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
    
    public void aceptar(Visitor visitor, int direccion){
        visitor.visit(this, direccion);
    }
    public int getDirTick(){
        return dirTickAnterior;
    }

    public void tocoSuelo() {
        velocidadY = 0;
        posicionY = alto + (posicionY - posicionY % 48) - estado.getPaddingTamanio();
        establecerEstadoAereo(ConstantesEntidades.SUELO);
        tocandoSuelo = true;
    }

    public int getPuntaje() {
        return miLogica.getPuntaje();
    }

    public void actualizarPuntaje(int puntaje) {
        miLogica.actualizarPuntaje(puntaje);
    }

    public int getVidas() {
        return miLogica.getVidas();
    }

    public void actualizarVelocidadXMario() {
        
        double acceleration = 1;
        double deceleration = 0.4;
        double maxVelocity = 8;
        double currentVelocity = getVelocidadX();
  
        switch (direccion) {
            case ConstantesEntidades.DERECHA:
                currentVelocity = Math.min(currentVelocity + acceleration, maxVelocity);
                break;
            case ConstantesEntidades.IZQUIERDA:
                currentVelocity = Math.min(currentVelocity + acceleration, maxVelocity);
                break;
            default:
                if (currentVelocity > 0) {
                    currentVelocity = Math.max(currentVelocity - deceleration, 0);
                } else if (currentVelocity < 0) {
                    currentVelocity = Math.min(currentVelocity + deceleration, 0);
                }
                break;
        }
  
        setVelocidadX(currentVelocity);
    }

    public void actualizarVelocidadYMario() {
        
        double velInicialSalto = 11;
        double gravedad = -0.2;
        double velTerminal = -8;
        double velYActual = velocidadY;
        
        if (tocandoSuelo) {
            velYActual = velInicialSalto;
            tocandoSuelo = false;
        } else {
            velYActual = Math.max(velYActual + gravedad, velTerminal);
            if (miHitboxes.getHitbox().getY() < 0 && !cayoAlVacio) {
                velYActual = 0;
                posicionY = estado.getPaddingTamanio();
                tocandoSuelo = true;
                estadoAereo = ConstantesEntidades.SUELO;
                posicionY = posicionY + 0;
            }
        }

        velocidadY = velYActual;

        if(posicionY < -200){
            morir();
        }
    }

    public void actualizarSprite() {
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

    public int getDireccion(){
        return direccion;
    }

    public EstadoMario getEstado(){
        return estado;
    }

    public void setEstado(EstadoMario estadoMario){
        int paddingAnterior = estado.getPaddingTamanio();
        estado = estadoMario;
        int paddingReal =  estadoMario.getPaddingTamanio() - paddingAnterior;
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

    public void setLogica(Logica logica){
        miLogica = logica;
    }

    public int getMonedas() {
        return miLogica.getMonedas();
    } 

    public void morir(){
        miLogica.detenerSonido(miLogica.getNivel().getNumeroNivel());
        miLogica.reproducirSonido(ConstantesSonidos.MUERTEMARIO);
        miLogica.reiniciarNivel();
    }
    
    public Logica getLogica(){
        return miLogica;
    }
    
    public void reproducirSonido(int nombre){
        miLogica.reproducirSonido(nombre);
    }

    public void detenerSonido(int nombre){
        miLogica.detenerSonido(nombre);
    }

    public void pausarSonido(int nombre){
        miLogica.pausarSonido(nombre);
    }

    public void reanudarSonido(int nombre){
        miLogica.reanudarSonido(nombre);
    }

    public void siguienteNivel(){
        miLogica.siguienteNivel();
    }

    public boolean sobreY0(){
        return posicionY - estado.getPaddingTamanio() == 0;
    }

}
