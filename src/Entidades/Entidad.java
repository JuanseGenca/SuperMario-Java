package Entidades;

import GUI.Observer;
import GUI.Sprite;
import Logica.*;
import java.awt.Rectangle;


public abstract class Entidad implements Visitable, EntidadLogica{   
 //Atributos
 protected int posicionX;
 protected int posicionY;
 protected final int velocidadX = 10; //¿QUE VELOCIDADES VAMOS A USAR?
 protected final int velocidadY = 10;
 protected int direccion;
 protected boolean sobreSuelo;
 protected int puntaje;
 protected Sprite miSprite;
 protected Observer miObserver;
 protected Rectangle miHitBox;

 //Metodos
 public Entidad(int posicionX, int posicionY) {
    this.posicionX=posicionX;
    this.posicionY=posicionY;
 }

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

 public Rectangle getHitBox() {
    return miHitBox;
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
   public void aplicarGravedad(){
      if(!sobreSuelo){
         posicionY-=velocidadY; //DEFINIR UN NUMERO PARA LA GRAVEDAD.
      }
   }

   public int getDireccion(){
      return direccion;
   }

}
