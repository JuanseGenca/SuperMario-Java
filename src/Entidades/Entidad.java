package Entidades;

import GUI.Observer;
import GUI.Sprite;
import Logica.*;
import java.awt.Rectangle;
import Fabricas.EntidadesFactory;
import Fabricas.SpriteFactory;

public abstract class Entidad implements EntidadLogica{   
 //Atributos
 protected int posicionX;
 protected int posicionY;
 protected int direccion;
 protected int estadoAereo;
 protected int alto, ancho;
 protected boolean tocandoSuelo;
 protected int puntaje;
 protected Sprite miSprite;
 protected Observer miObserver;
 protected double velocidadX, velocidadY;
 protected SpriteFactory miSpriteFactory;
  // Hitboxes
  protected Rectangle hitboxSuperior;
  protected Rectangle hitboxInferior;
  protected Rectangle hitboxLateral;


   public Entidad(int posicionX, int posicionY,Sprite sprites, SpriteFactory sf) {
      this.posicionX=posicionX;
      this.posicionY=posicionY;
      estadoAereo = ConstantesEntidades.SUELO;
      miSprite = sprites;
      miSpriteFactory = sf;
      alto = miSprite.getWidth();
      ancho = miSprite.getHeight();

        hitboxSuperior = new Rectangle(posicionX, posicionY, ancho, ancho / 4);
        hitboxInferior = new Rectangle(posicionX, posicionY + (3 * ancho / 4), ancho, ancho / 4);
        hitboxLateral = new Rectangle(posicionX, posicionY + (alto / 4), ancho, alto / 2);
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

   public void setSprite(Sprite spriteNuevo) {
      miSprite = spriteNuevo;
   }

   public void morir() {}

   public void recibirDanio() {}

   public void actualizar(int direccion, int estadoAereo){
      miObserver.actualizar(direccion, estadoAereo);
   }

   public void actualizarHitboxes() {
        hitboxSuperior.setBounds(posicionX, posicionY, ancho, alto / 4);
        hitboxInferior.setBounds(posicionX, posicionY + (3 * alto / 4), ancho, alto / 4);
        hitboxLateral = new Rectangle(posicionX, posicionY + (alto / 4), ancho, alto / 2);
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