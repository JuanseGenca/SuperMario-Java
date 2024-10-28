package Plataformas;

import Entidades.BolaDeFuego;
import Entidades.Entidad;
import Entidades.ManejadorEntidades;
import GUI.Observer;
import GUI.Sprite;
import Logica.Logica;
import Logica.Visitor;
import PowerUps.*;
import Visitors.VisitorBloquePregunta;

public class BloquePregunta extends Plataforma{
    
    protected int entidadContenida;
    protected Logica miLogica;

    public BloquePregunta(int x, int y,Sprite sprite[],Logica log,int i){
        super(x, y,sprite);
        visitor=new VisitorBloquePregunta();
        miLogica = log;
        entidadContenida = i;
    }

    public void getEntidadContenida(){
        if(entidadContenida == ConstantesBloquePregunta.MONEDA){
            Moneda moneda = ManejadorEntidades.getInstancia().crearMoneda(posicionX,posicionY+48);
            ManejadorEntidades.getInstancia().agregarMoneda(moneda);
            Observer observerMoneda = miLogica.getGui().registrarEntidad(moneda);
            moneda.setObserver(observerMoneda);
        }
        if(entidadContenida == ConstantesBloquePregunta.CHAMPINIONVERDE){
            ChampinionVerde champinionVerde = ManejadorEntidades.getInstancia().crearChampinionVerde(posicionX,posicionY+48);
            ManejadorEntidades.getInstancia().agregarChampinionVerde(champinionVerde);
            Observer observerChampinionVerde = miLogica.getGui().registrarEntidad(champinionVerde);
            champinionVerde.setObserver(observerChampinionVerde);
        }
        if(entidadContenida == ConstantesBloquePregunta.ESTRELLA){
            Estrella estrella = ManejadorEntidades.getInstancia().crearEstrella(posicionX,posicionY+48);
            ManejadorEntidades.getInstancia().agregarEstrella(estrella);
            Observer observerEstrella = miLogica.getGui().registrarEntidad(estrella);
            estrella.setObserver(observerEstrella);
        }
        if(entidadContenida == ConstantesBloquePregunta.FLORDEFUEGO){
            FlorDeFuego florDeFuego = ManejadorEntidades.getInstancia().crearFlorDeFuego(posicionX,posicionY+48);
            ManejadorEntidades.getInstancia().agregarFlorDeFuego(florDeFuego);
            Observer observerFlorDeFuego = miLogica.getGui().registrarEntidad(florDeFuego);
            florDeFuego.setObserver(observerFlorDeFuego);
        }
        if(entidadContenida == ConstantesBloquePregunta.SUPERCHAMPINION){
            SuperChampinion superChampinion = ManejadorEntidades.getInstancia().crearSuperChampinion(posicionX,posicionY+48);
            ManejadorEntidades.getInstancia().agregarSuperChampinion(superChampinion);
            Observer observerSuperChampinion = miLogica.getGui().registrarEntidad(superChampinion);
            superChampinion.setObserver(observerSuperChampinion);
        }
        entidadContenida = 0;
        
    }

    public void setEntidadContenida(int i){
        entidadContenida = i;
    }

    public void mostrarEntidadContenida(){
        //Resolver como mostrarla por pantalla.
    }

    public void OcultarEntidad(){
        //Resolver como esconderla por pantalla.
    }

    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }

    public void mover(){
        
    }
}
