package Entidades;

import GUI.Observer;
import GUI.Sprite;
import Logica.*;
import java.awt.Rectangle;

public abstract class Entidad implements EntidadLogica{   
 //Atributos
 protected int posicionX;
 protected int posicionY;
 protected int direccion;
 protected int estadoAereo;
 protected int alto, ancho;
 protected boolean tocandoSuelo;
 protected int puntaje;
 protected Sprite[] misSprites;
 protected Sprite spriteActual;
 protected Observer miObserver;
 protected double velocidadX, velocidadY;
 protected HitboxesEntidad miHitboxes;
 protected Visitor visitor;
  

   public Entidad(int posicionX, int posicionY,Sprite[] sprites) {
      this.posicionX=posicionX;
      this.posicionY=posicionY;
      estadoAereo = ConstantesEntidades.SUELO;
      misSprites = sprites;
      spriteActual = misSprites[0];
      alto = misSprites[0].getHeight();
      ancho = misSprites[0].getWidth();

      miHitboxes = new HitboxesEntidad(posicionX, posicionY, ancho, alto);
   }

   public int getPuntaje() {
      return puntaje;
   }

 @SuppressWarnings("override")
   public int getPosicionX() {
      return posicionX;
   }

   @SuppressWarnings("override")
   public int getPosicionY() {
      return posicionY;
   }

   @SuppressWarnings("override")
   public Sprite getSprite() {
      return spriteActual;
   }

   public void setObserver(Observer observer) {
      miObserver=observer;
   }

   public void setVelocidadX(double vX) {
      velocidadX = vX;
   }

   public void setVelocidadY(double vY) {
      velocidadY = vY;
   }

   public double getVelocidadX() {
      return velocidadX;
   }

   public double getVelocidadY() {
      return velocidadY;
   }

   public void morir(){

   }

   public void recibirDanio(int puntaje) {
      velocidadX = 0;
      spriteActual = misSprites[1];
      actualizar(direccion, estadoAereo);
   }

   public void actualizar(int direccion, int estadoAereo){
      miObserver.actualizar(direccion, estadoAereo);
   }

   public void actualizarHitboxes(int posicionX, int posicionY, int ancho, int alto) {
      miHitboxes.actualizarHitboxes(posicionX, posicionY, ancho, alto);
   }
   
   public Rectangle getHitbox(){
      return miHitboxes.getHitbox();
   }

   public abstract void aceptar(Visitor visitor, int direccion);

   public abstract void mover();

   public void establecerDireccion(int x){
      direccion = x;
   }

   public int getDireccion(){
      return direccion;
   }

 @SuppressWarnings("override")
   public int getZIndex(){
      return ConstantesEntidades.PRIORIDAD;
  }

   public void establecerEstadoAereo(int x){
      estadoAereo = x;
      mover();
   }

   public int getEstadoAereo(){
      return estadoAereo;
   }

   public Visitor getVisitor(){
      return visitor;
   }

}