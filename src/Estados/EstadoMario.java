package Estados;

public interface EstadoMario {
    public abstract void disparar();
    public abstract void recibirDanio(int puntaje);
    public abstract boolean puedeRomper();
    public abstract int getModificador();
    public abstract int getPaddingTamanio();
}
