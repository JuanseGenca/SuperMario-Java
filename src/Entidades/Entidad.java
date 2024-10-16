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
 protected boolean tocandoSuelo;
 protected int puntaje;
 protected Sprite miSprite;
 protected Observer miObserver;
 protected double velocidadX, velocidadY;





   public Entidad(int posicionX, int posicionY,Sprite sprites) {
      this.posicionX=posicionX;
      this.posicionY=posicionY;
      estadoAereo = constantesEntidades.SUELO;
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

   public void morir() {}

   public void recibirDanio() {}

   public void actualizar(int direccion, int estadoAereo){
      miObserver.actualizar(direccion, estadoAereo);
   }

   public abstract void aceptar(Visitor visitor);

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

}