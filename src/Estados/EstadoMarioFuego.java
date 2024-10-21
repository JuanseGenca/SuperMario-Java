package Estados;

import Entidades.Mario;

public class EstadoMarioFuego implements EstadoMario{
    protected Mario m;
    protected static final int paddingTamanio = 48;
    public EstadoMarioFuego(Mario mario){
        m = mario;
    }
    public void disparar(){
        //Hay que ver como crear una bola de fuego, dejo una idea. CREO que deberia conocer al nivel, sino ver como agregar la entidad a la lista.
        /*
         * nivel.agregarEntidad(new BolaDeFuego(m.getX(),m.getY(),¿SPRITE?);
         * 
         */
    }
    public void recibirDanio(){
        m.setEstado(new EstadoMarioComun(m));
    }
    public boolean puedeRomper(){
        return true;
    }
    public int getModificador(){
        return 6;
    }

    public int getPaddingTamanio() {
        return paddingTamanio;
    }
}
