package Fabricas;

import PowerUps.*;
import Entidades.BolaDeFuego;
import Entidades.Mario;
import GUI.Sprite;
import Nivel.Silueta;
import Plataformas.*;

import Enemigos.*;


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

    public ChampinionVerde crearChampinionVerde(int x,int y){
        Sprite[] spriteChampinionVerde = spriteFactory.getChampinionVerde();
        ChampinionVerde champinionVerde = new ChampinionVerde(x,y,spriteChampinionVerde);
        return champinionVerde;
    }

    public SuperChampinion crearSuperChampinion(int x,int y){
        Sprite[] spriteSuperChampinion = spriteFactory.getSuperChampinion();
        SuperChampinion superChampinion = new SuperChampinion(x,y,spriteSuperChampinion);
        return superChampinion;
    }

    public FlorDeFuego crearFlorDeFuego(int x,int y){
        Sprite[] spriteFlorDeFuego = spriteFactory.getFlorDeFuego();
        FlorDeFuego florDeFuego = new FlorDeFuego(x,y,spriteFlorDeFuego);
        return florDeFuego;
    }

    public Moneda crearMoneda(int x,int y){
        Sprite[] spriteMoneda = spriteFactory.getMoneda();
        Moneda moneda = new Moneda(x,y,spriteMoneda);
        return moneda;
    }

    public Estrella crearEstrella(int x,int y){
        Sprite[] spriteEstrella = spriteFactory.getEstrella();
        Estrella estrella = new Estrella(x,y,spriteEstrella);
        return estrella;
    }

    public Mario crearMario(int x,int y){
        Sprite[] spriteMario = spriteFactory.getMario();
        Mario mario = new Mario(x,y,spriteMario);
        return mario;
    }

    public BuzzyBeetle crearBuzzyBeetle(int x,int y){
        Sprite[] spriteBuzzyBeetle = spriteFactory.getBuzzyBeetle();
        BuzzyBeetle buzzyBeetle = new BuzzyBeetle(x,y,spriteBuzzyBeetle);
        return buzzyBeetle;
    }

    public Spiny crearSpiny(int x,int y){
        Sprite[] spriteSpiny = spriteFactory.getSpiny();
        Spiny spiny = new Spiny(x,y,spriteSpiny);
        return spiny;
    }

    public Lakitu crearLakitu(int x,int y){
        Sprite[] spriteLakitu = spriteFactory.getLakitu();
        Lakitu lakitu = new Lakitu(x,y,spriteLakitu);
        return lakitu;
    }

    public Goomba crearGoomba(int x,int y){
        Sprite[] spriteGoomba = spriteFactory.getGoomba();
        Goomba goomba = new Goomba(x,y,spriteGoomba);
        return goomba;
    }

    public PiranhaPlant crearPiranhaPlant(int x,int y){
        Sprite[] spritePiranhaPlant = spriteFactory.getPiranhaPlant();
        PiranhaPlant piranhaPlant = new PiranhaPlant(x,y,spritePiranhaPlant);
        return piranhaPlant;
    }

    public KoopaTroopa crearKoopaTroopa(int x,int y){
        Sprite[] spriteKoopaTroopa = spriteFactory.getKoopaTroopa();
        KoopaTroopa koopaTroopa = new KoopaTroopa(x,y,spriteKoopaTroopa) {
            
        };
        return koopaTroopa;
    }

    public BloqueSolido crearBloqueSolido(int x,int y){
        Sprite[] spriteBloqueSolido = spriteFactory.getBloqueSolido();
        BloqueSolido bloqueSolido = new BloqueSolido(x,y,spriteBloqueSolido);
        return bloqueSolido;
    }

    public Tuberia crearTuberia(int x,int y){
        Sprite[] spriteTuberia = spriteFactory.getTuberia();
        Tuberia tuberia = new Tuberia(x,y,spriteTuberia);
        return tuberia;
    }

    public Meta crearMeta(int x,int y){
        Sprite[] spriteMeta = spriteFactory.getMeta();
        Meta meta = new Meta(x,y,spriteMeta);
        return meta;
    }

    public Vacio crearVacio(int x,int y){
        Sprite[] spriteVacio = spriteFactory.getVacio();
        Vacio vacio = new Vacio(x,y,spriteVacio);
        return vacio;
    }

    public LadrilloRompible crearLadrilloRompible(int x,int y){
        Sprite[] spriteLadrilloRompible = spriteFactory.getLadrilloRompible();
        LadrilloRompible ladrilloRompible = new LadrilloRompible(x,y,spriteLadrilloRompible);
        return ladrilloRompible;
    }

    public BloquePregunta crearBloquePregunta(int x,int y){
        Sprite[] spriteBloquePregunta = spriteFactory.getBloquePregunta();
        BloquePregunta bloquePregunta = new BloquePregunta(x,y,spriteBloquePregunta);
        return bloquePregunta;
    }
    public BolaDeFuego crearBolaDeFuego(int x, int y){
        Sprite[] spriteBolaDeFuego = spriteFactory.getBolaDeFuego();
        BolaDeFuego bolaDeFuego = new BolaDeFuego(x, y, spriteBolaDeFuego);
        return bolaDeFuego;
    }    

}
