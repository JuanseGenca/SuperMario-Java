

public class Logica {
    //Atributos de instancia
    protected ManejadorDeColisiones manejadorDeColisiones;
    protected AdministradorDePuntaje administradorDePuntaje;
    protected int cantidadVidas;
    protected int puntaje;
    protected int monedas;
    protected Reloj relojGlobal;
    protected Parseint parseint;
    protected GUI gui;
    protected KeyListener keyListener;
    protected Mario jugador;
    protected Nivel nivelActual;

    //Constructor
    public Logica() {}

    public void setManejadorDeColisiones(ManejadorDeColisiones manejadorDeColisiones) {
        this.manejadorDeColisiones=manejadorDeColisiones;
    }

    public void setAdministradorDePuntaje(AdministradorDePuntaje administradorDePuntaje) {
        this.administradorDePuntaje=administradorDePuntaje;
    }

    public void setCantidadDeVidas(int vidas) {
        this.vidas=vidas;
    }

    public void setRelojGlobal(Reloj reloj) {
        this.relojGlobal=reloj;
    }

    public void setNivelActual(int nivel) {
        this.nivel=nivel;
    }

    public void setKeyListener(KeyListener keyListener) {
        this.keyListener=keyListener;
    }

    public ManejadorDeColisiones getManejadorDeColisiones() {
        return manejadorDeColisiones;
    }

    public AdministradorDePuntaje getAdministradorDePuntaje() {
        return administradorDePuntaje;
    }

    public int getCantidadDeVidas() {
        return vidas;
    }

    public Reloj getRelojGlobal() {
        return relojGlobal;
    }

    public int getNivelActual() {
        return nivel;
    }

    public void actualizarVidas() {
        gui.actualizarVidas(vidas);
    }

    public void moverJugadorDerecha() {
        jugador.moverDerecha();
    }

    public void moverJugadorIzquierda() {
        jugador.moverIzquierda();
    }

    public void saltarJugador() {
        jugador.saltar();
    }

    public void dispararJugador() {
        jugador.disparar();
    }

    public void actualizarPuntaje(int puntajeExtra) {
        puntaje=puntaje+puntajeExtra;
        administradorDePuntaje.actualizarPuntaje(puntajeExtra);
    }

    public void ganarVidas() {
        vidas=vidas+1;
        this.actualizarVidas();
    }

    public void perderVidas() {
        vidas=vidas-1;
        this.actualizarVidas();
    }

    public void aagregarMoneda() {
        monedas=monedas+1;
        if(monedas==100) {
            this.ganarVidas();
            monedas=0;
        }
    }
}