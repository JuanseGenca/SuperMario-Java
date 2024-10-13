package Fabricas;

import Entidades.Entidad;
import PowerUps.*;
import Entidades.Mario;
import Plataformas.*;

import java.awt.image.BufferedImage;

import Enemigos.*;


public class EntidadesFactory {
    
    protected SpriteFactory spriteFactory;

    public EntidadesFactory(SpriteFactory spriteFactory){
        this.spriteFactory = spriteFactory;
    }

    public ChampinionVerde crearChampinionVerde(int x,int y){
        BufferedImage[] spriteChampinionVerde = spriteFactory.crearSpriteChampinionVerde();
        ChampinionVerde champinionVerde = new ChampinionVerde(x,y,spriteChampinionVerde);
        return champinionVerde;
    }

    public SuperChampinion crearSuperChampinion(int x,int y){
        BufferedImage[] spriteSuperChampinion = spriteFactory.crearSpriteSuperChampinion();
        SuperChampinion superChampinion = new SuperChampinion(x,y,spriteSuperChampinion);
        return superChampinion;
    }

    public FlorDeFuego crearFlorDeFuego(int x,int y){
        BufferedImage[] spriteFlorDeFuego = spriteFactory.crearSpriteFlorDeFuego();
        FlorDeFuego florDeFuego = new FlorDeFuego(x,y,spriteFlorDeFuego);
        return florDeFuego;
    }

    public Moneda crearMoneda(int x,int y){
        BufferedImage[] spriteMoneda = spriteFactory.crearSpriteMoneda();
        Moneda moneda = new Moneda(x,y,spriteMoneda);
        return moneda;
    }

    public Estrella crearEstrella(int x,int y){
        BufferedImage[] spriteEstrella = spriteFactory.crearSpriteEstrella();
        Estrella estrella = new Estrella(x,y,spriteEstrella);
        return estrella;
    }

    public Mario crearMario(int x,int y){
        BufferedImage[] spriteMario = spriteFactory.crearSpriteMario();
        Mario mario = new Mario(x,y,spriteMario);
        return mario;
    }

    public BuzzyBeetle crearBuzzyBeetle(int x,int y){
        BufferedImage[] spriteBuzzyBeetle = spriteFactory.crearSpriteBuzzyBeetle();
        BuzzyBeetle buzzyBeetle = new BuzzyBeetle(x,y,spriteBuzzyBeetle);
        return buzzyBeetle;
    }

    public Spiny crearSpiny(int x,int y){
        BufferedImage[] spriteSpiny = spriteFactory.crearSpriteSpiny();
        Spiny spiny = new Spiny(x,y,spriteSpiny);
        return spiny;
    }

    public Lakitu crearLakitu(int x,int y){
        BufferedImage[] spriteLakitu = spriteFactory.crearSpriteLakitu();
        Lakitu lakitu = new Lakitu(x,y,spriteLakitu);
        return lakitu;
    }

    public Goomba crearGoomba(int x,int y){
        BufferedImage[] spriteGoomba = spriteFactory.crearSpriteGoomba();
        Goomba goomba = new Goomba(x,y,spriteGoomba);
        return goomba;
    }

    public PiranhaPlant crearPiranhaPlant(int x,int y){
        BufferedImage[] spritePiranhaPlant = spriteFactory.crearSpritePiranhaPlant();
        PiranhaPlant piranhaPlant = new PiranhaPlant(x,y,spritePiranhaPlant);
        return piranhaPlant;
    }

    public KoopaTroopa crearKoopaTroopa(int x,int y){
        BufferedImage[] spriteKoopaTroopa = spriteFactory.crearSpriteKoopaTroopa();
        KoopaTroopa koopaTroopa = new KoopaTroopa(x,y,spriteKoopaTroopa);
        return koopaTroopa;
    }

    public BloqueSolido crearBloqueSolido(int x,int y){
        BufferedImage[] spriteBloqueSolido = spriteFactory.crearSpriteBloqueSolido();
        BloqueSolido bloqueSolido = new BloqueSolido(x,y,spriteBloqueSolido);
        return bloqueSolido;
    }

    public Tuberia crearTuberia(int x,int y){
        BufferedImage[] spriteTuberia = spriteFactory.crearSpriteTuberia();
        Tuberia tuberia = new Tuberia(x,y,spriteTuberia);
        return tuberia;
    }

    public Meta crearMeta(int x,int y){
        BufferedImage[] spriteMeta = spriteFactory.crearSpriteMeta();
        Meta meta = new Meta(x,y,spriteMeta);
        return meta;
    }

    public Vacio crearVacio(int x,int y){
        BufferedImage[] spriteVacio = spriteFactory.crearSpriteVacio();
        Vacio vacio = new Vacio(x,y,spriteVacio);
        return vacio;
    }

    public LadrilloRompible crearLadrilloRompible(int x,int y){
        BufferedImage[] spriteLadrilloRompible = spriteFactory.crearSpriteLadrilloRompible();
        LadrilloRompible ladrilloRompible = new LadrilloRompible(x,y,spriteLadrilloRompible);
        return ladrilloRompible;
    }

    public BloquePregunta crearBloquePregunta(int x,int y){
        BufferedImage[] spriteBloquePregunta = spriteFactory.crearSpriteBloquePregunta();
        BloquePregunta bloquePregunta = new BloquePregunta(x,y,spriteBloquePregunta);
        return bloquePregunta;
    }    

}
