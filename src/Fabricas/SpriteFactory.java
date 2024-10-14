package Fabricas;


import GUI.Sprite;


public abstract class SpriteFactory {

    protected String rutaCarpeta;
		
	protected SpriteFactory(String ruta) {
		rutaCarpeta = ruta;
	}
	
	public Sprite getSilueta(int numero) {
		return new Sprite(rutaCarpeta + "/ruta.png");	
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
		return new Sprite(rutaCarpeta + "/mario.png");
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
		return new Sprite(rutaCarpeta + "/Plataformas/bloque_solido.png");
	}
	
	public Sprite getTuberia() {
		return new Sprite(rutaCarpeta + "/Plataformas/tuberia.png");
	}
	
	public Sprite getMeta() {
		return new Sprite(rutaCarpeta + "/Plataformas/meta.png");
	}
	
	public Sprite getVacio() {
		return new Sprite(rutaCarpeta + "/Plataformas/vacio.png");
	}
    public Sprite getLadrilloRompible() {
		return new Sprite(rutaCarpeta + "/Plataformas/bloque_ladrillo.png");
	}
	
	public Sprite getBloquePregunta() {
		return new Sprite(rutaCarpeta + "/Plataformas/bloque_pregunta.png");
	}

}
