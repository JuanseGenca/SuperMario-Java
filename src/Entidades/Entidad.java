package Entidades;

import GUI.Observer;
import GUI.Sprite;
import Logica.*;
import java.awt.Rectangle;

public abstract class Entidad implements EntidadLogica, Visitable{   

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

   public int getPosicionX() {
      return posicionX;
   }

   public int getPosicionY() {
      return posicionY;
   }

   public Sprite getSprite() {
      return spriteActual;
   }

   public void setObserver(Observer observer) {
      miObserver=observer;
   }

   public Observer getObserver(){
      return miObserver;
   }

   public void setVelocidadX(double velocidadX) {
      this.velocidadX = velocidadX;
   }

   public void setVelocidadY(double velocidadY) {
      this.velocidadY = velocidadY;
   }

   public void setPosicionx(int posicionX){
      this.posicionX = posicionX;
   }

   public void setPosicionY(int posicionY){
      this.posicionY = posicionY;
   }

   public double getVelocidadX() {
      return velocidadX;
   }

   public double getVelocidadY() {
      return velocidadY;
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

   public void establecerDireccion(int direccion){
      this.direccion = direccion;
   }

   public int getDireccion(){
      return direccion;
   }

   public int getZIndex(){
      return ConstantesEntidades.PRIORIDAD;
   }

   public int getEstadoAereo(){
      return estadoAereo;
   }

   public Visitor getVisitor(){
      return visitor;
   }

}