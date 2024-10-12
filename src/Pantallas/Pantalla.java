package Pantallas;


public interface Pantalla extends JFrame{
    public void crearPantalla(int width, int height);

    public void agregarComponentes();

    public void setVisibilidad(boolean vis);

    public void refrescar();
}