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
 protected boolean sobreSuelo;
 protected int puntaje;
 protected Sprite miSprite;
 protected Observer miObserver;
 protected double velocidadX, velocidadY;

protected static final int IZQUIERDA = 15002;
protected static final int DERECHA = 15003;
protected static final int QUIETO = 0;

protected static final int AIRE = 20000;
protected static final int SUELO = 20001;


   public Entidad(int posicionX, int posicionY,Sprite sprites) {
      this.posicionX=posicionX;
      this.posicionY=posicionY;
      estadoAereo = SUELO;
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
      System.out.println("mi velocidad Y es"+velocidadY);
      return velocidadY;
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