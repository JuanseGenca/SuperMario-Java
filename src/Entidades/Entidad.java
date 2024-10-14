package Entidades;

import GUI.Observer;
import GUI.Sprite;
import Logica.*;


public abstract class Entidad implements EntidadLogica{   
 //Atributos
 protected int posicionX;
 protected int posicionY;
 protected int direccion;
 protected boolean sobreSuelo;
 protected int puntaje;
 protected Sprite miSprite;
 protected Observer miObserver;

 public Entidad(int posicionX, int posicionY,Sprite sprites) {
   this.posicionX=posicionX;
   this.posicionY=posicionY;
   miSprite = sprites;
}

 public int getPuntaje() {
    return puntaje;
 }

 public int getPosicionX() {
    return posicionX;
 }

 public int getPosicionY() {
    return posicionY;
 }

 public Sprite getSprite() {
    return miSprite;
 }

 public void setObserver(Observer observer) {
    miObserver=observer;
 }

   public void morir() {}

   public void recibirDanio() {}

   public void actualizar(){
      miObserver.actualizar();
   }

   public abstract void aceptar(Visitor visitor);

   public abstract void mover();

   public void establecerDireccion(int x){
      direccion = x;
   }
   public int getDireccion(){
      return direccion;
   }

}