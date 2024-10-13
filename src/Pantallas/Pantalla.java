package Pantallas;

import javax.swing.*;


public interface Pantalla implements JFrame{
    public void crearPantalla(int width, int height);

    public void agregarComponentes();

    public void setVisibilidad(boolean vis);

    public void refrescar();
}