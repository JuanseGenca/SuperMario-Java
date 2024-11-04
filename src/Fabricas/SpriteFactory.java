package Fabricas;

import GUI.Sprite;

public abstract class SpriteFactory {

    protected String rutaCarpeta;
		
	protected SpriteFactory(String ruta) {
		rutaCarpeta = ruta;
	}
	
	public Sprite[] getSilueta(int numero) {
		Sprite[] devolver = new Sprite[1];

		devolver[0] = new Sprite(rutaCarpeta +  "/fondo-nivel.png");

		return devolver;
	}
	
	public Sprite[] getChampinionVerde() {
		Sprite[] devolver = new Sprite[1];

		devolver[0] = new Sprite(rutaCarpeta + "/PowerUps/champinion_verde.png");

		return devolver;
	}
	
	public Sprite[] getSuperChampinion() {
		Sprite[] devolver = new Sprite[1];

		devolver[0] = new Sprite(rutaCarpeta + "/PowerUps/super_champinion.png");

		return devolver;
	}
	
	public Sprite[] getFlorDeFuego() {
		Sprite[] devolver = new Sprite[1];

		devolver[0] = new Sprite(rutaCarpeta + "/PowerUps/flor_de_fuego.gif");

		return devolver;
	}

	public Sprite[] getBolaDeFuego() {
		Sprite[] devolver = new Sprite[2];

		devolver[0] = new Sprite(rutaCarpeta + "/PowerUps/bola_de_fuego.gif");
		devolver[1] = new Sprite(rutaCarpeta + "/PowerUps/bola_de_fuego_explotando.gif");

		return devolver;
	}
	
	public Sprite[] getMoneda() {
		Sprite[] devolver = new Sprite[1];

		devolver[0] = new Sprite(rutaCarpeta + "/PowerUps/moneda.gif");

		return devolver;
	}
	
	public Sprite[] getEstrella() {
		Sprite[] devolver = new Sprite[1];

		devolver[0] = new Sprite(rutaCarpeta + "/PowerUps/estrella.gif");

		return devolver;
	}
	
	public Sprite[] getMario() {
		Sprite[] devolver = new Sprite[13];

		devolver[0] = new Sprite(rutaCarpeta + "/Mario/miniMarioQuieto.png");
		devolver[1] = new Sprite(rutaCarpeta + "/Mario/miniMarioCaminando.gif");
		devolver[2] = new Sprite(rutaCarpeta + "/Mario/miniMarioSaltando.png");
		devolver[3] = new Sprite(rutaCarpeta + "/Mario/superMarioQuieto.png");
		devolver[4] = new Sprite(rutaCarpeta + "/Mario/superMarioCaminando.gif");
		devolver[5] = new Sprite(rutaCarpeta + "/Mario/superMarioSaltando.png");
		devolver[6] = new Sprite(rutaCarpeta + "/Mario/MarioFuegoQuieto.png");
		devolver[7] = new Sprite(rutaCarpeta + "/Mario/MarioFuegoCaminando.gif");
		devolver[8] = new Sprite(rutaCarpeta + "/Mario/MarioFuegoSaltando.png");
		devolver[9] = new Sprite(rutaCarpeta + "/Mario/marioEstrellaQuieto.gif");
		devolver[10] = new Sprite(rutaCarpeta + "/Mario/marioEstrellaCaminando.gif");
		devolver[11] = new Sprite(rutaCarpeta + "/Mario/marioEstrellaSaltando.gif");

		return devolver;
	}

	public Sprite[] getBuzzyBeetle() {
		Sprite[] devolver = new Sprite[2];

		devolver[0] = new Sprite(rutaCarpeta + "/Enemigos/buzzy_beetle_caminando.gif");
		devolver[1] = new Sprite(rutaCarpeta + "/Enemigos/buzzy_beetle_golpeado.png");

		return devolver;
	}
	
	public Sprite[] getSpiny() {
		Sprite[] devolver = new Sprite[1];

		devolver[0] = new Sprite(rutaCarpeta + "/Enemigos/spiny_caminando.gif");

		return devolver;
	}
	
	public Sprite[] getLakitu() {
		Sprite[] devolver = new Sprite[2];

		devolver[0] = new Sprite(rutaCarpeta + "/Enemigos/lakitu_volando.png");
		devolver[1] = new Sprite(rutaCarpeta + "/Enemigos/lakitu_atacando.png");

		return devolver;
	}
	
	public Sprite[] getGoomba() {
		Sprite[] devolver = new Sprite[2];

		devolver[0] = new Sprite(rutaCarpeta + "/Enemigos/goomba_caminando.gif");
		devolver[1] = new Sprite(rutaCarpeta + "/Enemigos/goomba_golpeado.png");

		return devolver;
	}
	
	public Sprite[] getPiranhaPlant() {
		Sprite[] devolver = new Sprite[1];

		devolver[0] = new Sprite(rutaCarpeta + "/Enemigos/piranha_plant.gif");

		return devolver;
	}
	
	public Sprite[] getKoopaTroopa() {
		Sprite[] devolver = new Sprite[3];

		devolver[0] = new Sprite(rutaCarpeta + "/Enemigos/koopa_caminando.gif");
		devolver[1] = new Sprite(rutaCarpeta + "/Enemigos/koopa_golpeado.png");
		devolver[2] = new Sprite(rutaCarpeta + "/Enemigos/koopa_saliendo.gif");

		return devolver;
	}
	
	public Sprite[] getBloqueSolido() {
		Sprite[] devolver = new Sprite[1];

		devolver[0] = new Sprite(rutaCarpeta + "/Plataformas/bloque_solido.png");

		return devolver;
	}
	
	public Sprite[] getTuberia() {
		Sprite[] devolver = new Sprite[1];

		devolver[0] = new Sprite(rutaCarpeta + "/Plataformas/tuberia.png");
		
		return devolver;
	}
	
	public Sprite[] getMeta() {
		Sprite[] devolver = new Sprite[2];

		devolver[0] = new Sprite(rutaCarpeta + "/Plataformas/meta1.png");
		devolver[1] = new Sprite(rutaCarpeta + "/Plataformas/meta2.png");
		
		return devolver;
	}
	
	public Sprite[] getVacio() {
		Sprite[] devolver = new Sprite[1];

		devolver[0] = new Sprite("Imagenes/vacio.png");
		
		return devolver;
	}

    public Sprite[] getLadrilloRompible() {
		Sprite[] devolver = new Sprite[2];

		devolver[0] = new Sprite(rutaCarpeta + "/Plataformas/bloque_ladrillo.png");
		devolver[1] = new Sprite(rutaCarpeta + "/Plataformas/bloque_ladrillo_roto.png");

		return devolver;
	}
	
	public Sprite[] getBloquePregunta() {
		Sprite[] devolver = new Sprite[2];
		
		devolver[0] = new Sprite(rutaCarpeta + "/Plataformas/bloque_pregunta.gif");
		devolver[1] = new Sprite(rutaCarpeta + "/Plataformas/bloque_pregunta_vacio.png");
		
		return devolver;
	}

}
