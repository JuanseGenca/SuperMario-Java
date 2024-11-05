package Fabricas;

import Enemigos.*;
import Entidades.Mario;
import GUI.Sprite;
import Logica.Logica;
import Nivel.Silueta;
import Plataformas.*;
import PowerUps.*;

public class EntidadesFactory {
    
    protected SpriteFactory spriteFactory;

    public EntidadesFactory(SpriteFactory spriteFactory){
        this.spriteFactory = spriteFactory;
    }
    public Silueta getSilueta(int numeroRuta) {
		Sprite[] spriteSilueta = spriteFactory.getSilueta(numeroRuta);
		Silueta silueta = new Silueta(spriteSilueta);
		return silueta;
	}

    public ChampinionVerde crearChampinionVerde(int posicionX,int posicionY){
        Sprite[] spriteChampinionVerde = spriteFactory.getChampinionVerde();
        ChampinionVerde champinionVerde = new ChampinionVerde(posicionX,posicionY,spriteChampinionVerde);
        return champinionVerde;
    }

    public SuperChampinion crearSuperChampinion(int posicionX,int posicionY){
        Sprite[] spriteSuperChampinion = spriteFactory.getSuperChampinion();
        SuperChampinion superChampinion = new SuperChampinion(posicionX,posicionY,spriteSuperChampinion);
        return superChampinion;
    }

    public FlorDeFuego crearFlorDeFuego(int posicionX,int posicionY){
        Sprite[] spriteFlorDeFuego = spriteFactory.getFlorDeFuego();
        FlorDeFuego florDeFuego = new FlorDeFuego(posicionX,posicionY,spriteFlorDeFuego);
        return florDeFuego;
    }

    public Moneda crearMoneda(int posicionX,int posicionY){
        Sprite[] spriteMoneda = spriteFactory.getMoneda();
        Moneda moneda = new Moneda(posicionX,posicionY,spriteMoneda);
        return moneda;
    }

    public Estrella crearEstrella(int posicionX,int posicionY){
        Sprite[] spriteEstrella = spriteFactory.getEstrella();
        Estrella estrella = new Estrella(posicionX,posicionY,spriteEstrella);
        return estrella;
    }

    public Mario crearMario(int posicionX,int posicionY){
        Sprite[] spriteMario = spriteFactory.getMario();
        Mario mario = new Mario(posicionX,posicionY,spriteMario);
        return mario;
    }

    public BuzzyBeetle crearBuzzyBeetle(int posicionX,int posicionY){
        Sprite[] spriteBuzzyBeetle = spriteFactory.getBuzzyBeetle();
        BuzzyBeetle buzzyBeetle = new BuzzyBeetle(posicionX,posicionY,spriteBuzzyBeetle);
        return buzzyBeetle;
    }

    public Spiny crearSpiny(int posicionX,int posicionY){
        Sprite[] spriteSpiny = spriteFactory.getSpiny();
        Spiny spiny = new Spiny(posicionX,posicionY,spriteSpiny);
        return spiny;
    }

    public Lakitu crearLakitu(int posicionX,int posicionY){
        Sprite[] spriteLakitu = spriteFactory.getLakitu();
        Lakitu lakitu = new Lakitu(posicionX,posicionY,spriteLakitu);
        return lakitu;
    }

    public Goomba crearGoomba(int posicionX,int posicionY){
        Sprite[] spriteGoomba = spriteFactory.getGoomba();
        Goomba goomba = new Goomba(posicionX,posicionY,spriteGoomba);
        return goomba;
    }

    public PiranhaPlant crearPiranhaPlant(int posicionX,int posicionY){
        Sprite[] spritePiranhaPlant = spriteFactory.getPiranhaPlant();
        PiranhaPlant piranhaPlant = new PiranhaPlant(posicionX,posicionY,spritePiranhaPlant);
        return piranhaPlant;
    }

    public KoopaTroopa crearKoopaTroopa(int posicionX,int posicionY){
        Sprite[] spriteKoopaTroopa = spriteFactory.getKoopaTroopa();
        KoopaTroopa koopaTroopa = new KoopaTroopa(posicionX,posicionY,spriteKoopaTroopa) {
            
        };
        return koopaTroopa;
    }

    public BloqueSolido crearBloqueSolido(int posicionX,int posicionY){
        Sprite[] spriteBloqueSolido = spriteFactory.getBloqueSolido();
        BloqueSolido bloqueSolido = new BloqueSolido(posicionX,posicionY,spriteBloqueSolido);
        return bloqueSolido;
    }

    public Tuberia crearTuberia(int posicionX,int posicionY){
        Sprite[] spriteTuberia = spriteFactory.getTuberia();
        Tuberia tuberia = new Tuberia(posicionX,posicionY,spriteTuberia);
        return tuberia;
    }

    public Meta crearMeta(int posicionX,int posicionY){
        Sprite[] spriteMeta = spriteFactory.getMeta();
        Meta meta = new Meta(posicionX,posicionY,spriteMeta);
        return meta;
    }

    public Vacio crearVacio(int posicionX,int posicionY){
        Sprite[] spriteVacio = spriteFactory.getVacio();
        Vacio vacio = new Vacio(posicionX,posicionY,spriteVacio);
        return vacio;
    }

    public LadrilloRompible crearLadrilloRompible(int posicionX,int posicionY){
        Sprite[] spriteLadrilloRompible = spriteFactory.getLadrilloRompible();
        LadrilloRompible ladrilloRompible = new LadrilloRompible(posicionX,posicionY,spriteLadrilloRompible);
        return ladrilloRompible;
    }

    public BloquePregunta crearBloquePregunta(int posicionX,int posicionY,Logica log,int i){
        Sprite[] spriteBloquePregunta = spriteFactory.getBloquePregunta();
        BloquePregunta bloquePregunta = new BloquePregunta(posicionX,posicionY,spriteBloquePregunta,log,i);
        return bloquePregunta;
    }
    public BolaDeFuego crearBolaDeFuego(int posicionX, int posicionY, Mario mario){
        Sprite[] spriteBolaDeFuego = spriteFactory.getBolaDeFuego();
        BolaDeFuego bolaDeFuego = new BolaDeFuego(posicionX, posicionY, spriteBolaDeFuego, mario);
        return bolaDeFuego;
    }

    public void setFabricaSprites(SpriteFactory fabrica){
        spriteFactory = fabrica;
    }    
}

