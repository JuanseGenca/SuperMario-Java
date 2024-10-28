package Plataformas;

import Entidades.BolaDeFuego;
import Entidades.Entidad;
import Entidades.ManejadorEntidades;
import GUI.Observer;
import GUI.Sprite;
import Logica.Logica;
import Logica.Visitor;
import PowerUps.Moneda;
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
            Moneda moneda = ManejadorEntidades.getInstancia().crearMoneda(posicionX,posicionY+48);
            ManejadorEntidades.getInstancia().agregarMoneda(moneda);
            Observer observerMoneda = miLogica.getGui().registrarEntidad(moneda);
            moneda.setObserver(observerMoneda);
        }
        if(entidadContenida == ConstantesBloquePregunta.ESTRELLA){
            Moneda moneda = ManejadorEntidades.getInstancia().crearMoneda(posicionX,posicionY+48);
            ManejadorEntidades.getInstancia().agregarMoneda(moneda);
            Observer observerMoneda = miLogica.getGui().registrarEntidad(moneda);
            moneda.setObserver(observerMoneda);
        }
        if(entidadContenida == ConstantesBloquePregunta.FLORDEFUEGO){
            Moneda moneda = ManejadorEntidades.getInstancia().crearMoneda(posicionX,posicionY+48);
            ManejadorEntidades.getInstancia().agregarMoneda(moneda);
            Observer observerMoneda = miLogica.getGui().registrarEntidad(moneda);
            moneda.setObserver(observerMoneda);
        }
        if(entidadContenida == ConstantesBloquePregunta.SUPERCHAMPINION){
            Moneda moneda = ManejadorEntidades.getInstancia().crearMoneda(posicionX,posicionY+48);
            ManejadorEntidades.getInstancia().agregarMoneda(moneda);
            Observer observerMoneda = miLogica.getGui().registrarEntidad(moneda);
            moneda.setObserver(observerMoneda);
        }
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
