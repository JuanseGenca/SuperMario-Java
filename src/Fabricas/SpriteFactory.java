package Fabricas;


import GUI.Sprite;


public abstract class SpriteFactory {

    protected String rutaCarpeta;
		
	protected SpriteFactory(String ruta) {
		rutaCarpeta = ruta;
	}
	
	public Sprite getSilueta(int numero) {
		return new Sprite(rutaCarpeta + "/bg.png");	
	}
	
	public Sprite getChampinionVerde() {
		return new Sprite(rutaCarpeta + "/PowerUps/champinion_verde.png");
	}
	
	public Sprite getSuperChampinion() {
		return new Sprite(rutaCarpeta + "/PowerUps/super_champinion.png");
	}
	
	public Sprite getFlorDeFuego() {
		return new Sprite(rutaCarpeta + "/PowerUps/flor_de_fuego3.png");
	}
	
	public Sprite getMoneda() {
		return new Sprite(rutaCarpeta + "/PowerUps/moneda1.png");
	}
	
	public Sprite getEstrella() {
		return new Sprite(rutaCarpeta + "/PowerUps/estrella.gif");
	}
	
	public Sprite getMario() {
		return new Sprite(rutaCarpeta + "/Mario/miniMarioQuieto.png");
	}

	public Sprite getMarioCaminando() {
		return new Sprite(rutaCarpeta + "/Mario/miniMarioCaminando.png");
	}

	public Sprite getMarioSaltando() {
		return new Sprite(rutaCarpeta + "/Mario/miniMarioSaltando.png");
	}
	
	public Sprite getBuzzyBeetle() {
		return new Sprite(rutaCarpeta + "/Enemigos/buzzy_beetle.gif");
	}
	
	public Sprite getSpiny() {
		return new Sprite(rutaCarpeta + "/Enemigos/spiny_caminando1.png");
	}
	
	public Sprite getLakitu() {
		return new Sprite(rutaCarpeta + "/Enemigos/lakitu_volando.png");
	}
	
	public Sprite getGoomba() {
		return new Sprite(rutaCarpeta + "/Enemigos/goomba_caminando.gif");
	}
	
	public Sprite getPiranhaPlant() {
		return new Sprite(rutaCarpeta + "/Enemigos/piranha_plant.gif");
	}
	
	public Sprite getKoopaTroopa() {
		return new Sprite(rutaCarpeta + "/Enemigos/koopa_troopa_caminando.gif");
	}
	
	public Sprite getBloqueSolido() {
		return new Sprite(rutaCarpeta + "/Plataformas/bloque_solido.png");
	}
	
	public Sprite getTuberia() {
		return new Sprite(rutaCarpeta + "/Plataformas/tuberia.png");
	}
	
	public Sprite getMeta() {
		return new Sprite(rutaCarpeta + "/Plataformas/meta1.png");
	}
	
	public Sprite getVacio() {
		return new Sprite(rutaCarpeta + "/Plataformas/vacio.png");
	}
    public Sprite getLadrilloRompible() {
		return new Sprite(rutaCarpeta + "/Plataformas/bloque_ladrillo.png");
	}
	
	public Sprite getBloquePregunta() {
		return new Sprite(rutaCarpeta + "/Plataformas/bloque_pregunta.gif");
	}

}
