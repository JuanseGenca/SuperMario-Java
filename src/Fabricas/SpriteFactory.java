package Fabricas;

import java.awt.image.BufferedImage;

import GUI.Sprite;
import PowerUps.PowerUp;


public abstract class SpriteFactory {

    protected String rutaCarpeta;
		
	protected SpriteFactory(String ruta) {
		rutaCarpeta = ruta;
	}
	
	
	public Sprite getChampinionVerde() {
		return new Sprite(rutaCarpeta + "/PowerUps/champinion_verde.png");
	}
	
	public Sprite getSuperChampinion() {
		return new Sprite(rutaCarpeta + "/PowerUps/super_champinion.png");
	}
	
	public Sprite getFlorDeFuego() {
		return new Sprite(rutaCarpeta + "/PowerUps/flor_de_fuego.png");
	}
	
	public Sprite getMoneda() {
		return new Sprite(rutaCarpeta + "/PowerUps/moneda.png");
	}
	
	public Sprite getEstrella() {
		return new Sprite(rutaCarpeta + "/PowerUps/estrella.png");
	}
	
	public Sprite getMario() {
		return new Sprite(rutaCarpeta + "/moto-power-up.gif");
	}
	
	public Sprite getBuzzyBeetle() {
		return new Sprite(rutaCarpeta + "/Enemigos/buzzy_beetle.png");
	}
	
	public Sprite getSpiny() {
		return new Sprite(rutaCarpeta + "/Enemigos/spiny.png");
	}
	
	public Sprite getLakitu() {
		return new Sprite(rutaCarpeta + "/Enemigos/Lakitu.png");
	}
	
	public Sprite getGoomba() {
		return new Sprite(rutaCarpeta + "/Enemgigos/Goomba.png");
	}
	
	public Sprite getPiranhaPlant() {
		return new Sprite(rutaCarpeta + "/Enemigos/piranha_plant.png");
	}
	
	public Sprite getKoopaTroopa() {
		return new Sprite(rutaCarpeta + "/Enemigos/Koopa_Troopa.png");
	}
	
	public Sprite getBloqueSolido() {
		return new Sprite(rutaCarpeta + "/anciana.png");
	}
	
	public Sprite getTuberia() {
		return new Sprite(rutaCarpeta + "/perro.png");
	}
	
	public Sprite getMeta() {
		return new Sprite(rutaCarpeta + "/lobo.png");
	}
	
	public Sprite getVacio() {
		return new Sprite(rutaCarpeta + "/bache.png");
	}
    public Sprite getLadrilloRompible() {
		return new Sprite(rutaCarpeta + "/lobo.png");
	}
	
	public Sprite getBloquePregunta() {
		return new Sprite(rutaCarpeta + "/bache.png");
	}

}
