package Entidades;

import GUI.Observer;
import Logica.*;

public abstract class Entidad implements Visitable implements EntidadLogica{   
 //Atributos
 protected int posicionX;
 protected int posicionY;
 protected int velocidadX;
 protected int velocidadY;
 protected int direccion;
 protected boolean sobreSuelo;
 protected int puntaje;
 protected Sprite[] miSprite;
 protected Observer miObserver;
 protected Rectangle miHitBox;

 //Metodos
 public Entidad(int posicionX, int posicionY) {
    this.posicionX=posicionX;
    this.posicionY=posicionY;
 }

 public int getPuntaje() {
    return puntaje;
 }

 public int getPosicionX() {
    return posicionX;
 }

 public int getPosiciony() {
    return posicionY;
 }

 public Sprite getSprite() {
    return miSprite;
 }

 public Rectangle getHitBox() {
    return miHitBox;
 }

 public void setObserver(Observer observer) {
    miObserver=observer;
 }

   public void morir() {}

   public void recibirDanio() {}

   public void actualizar() {}

   public abstract void aceptar(Visitor visitor);

   public abstract void moverDerecha();

   public abstract void moverIzquierda();
}
