package Puntaje;

import java.io.Serializable;

public class PuntajeJugador implements Serializable {
    protected int score;
    protected String nombre;

  public PuntajeJugador(String nombre, int score) {
    this.score=score;
    this.nombre=nombre;
  }    

  public void setNombre(String nombre) {
    this.nombre=nombre;
  }

  public void setScore(int score) {
     this.score=score;
  }

  public Integer getScore() {
    return score;
  }

  public String getNombre() {
    return nombre;
  }
}
