package Entidades;

import GUI.Observer;
import GUI.Sprite;
import Logica.*;

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
      alto = misSprites[0].getWidth();
      ancho = misSprites[0].getHeight();

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
      //IMPLEMENTAR
   }

   public void recibirDanio() {}

   public void actualizar(int direccion, int estadoAereo){
      miObserver.actualizar(direccion, estadoAereo);
   }

   public void actualizarHitboxes(int posicionX, int posicionY, int ancho, int alto) {
      miHitboxes.actualizarHitboxes(posicionX, posicionY, ancho, alto);
   }
   public HitboxesEntidad getHitbox(){
      return miHitboxes;
   }

   public abstract void aceptar(Visitor visitor, int direccion);

   public abstract void mover();

   public void establecerDireccion(int x){
      direccion = x;
      mover();
   }

   public int getDireccion(){
      return direccion;
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