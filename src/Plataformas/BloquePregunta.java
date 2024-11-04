package Plataformas;

import Entidades.ManejadorEntidades;
import GUI.Sprite;
import Logica.Logica;
import Logica.Visitor;

public class BloquePregunta extends Plataforma{
    
    protected int entidadContenida;
    protected Logica miLogica;

    public BloquePregunta(int posicionX ,int posicionY,Sprite sprite[],Logica log,int entidadContenida){
        super(posicionX ,posicionY,sprite);
        miLogica = log;
        this.entidadContenida = entidadContenida;
    }

    public void getEntidadContenida(){
        if(entidadContenida == ConstantesBloquePregunta.MONEDA){
            ManejadorEntidades.getInstancia().crearMoneda(posicionX,posicionY+48);
        }
        if(entidadContenida == ConstantesBloquePregunta.CHAMPINIONVERDE){
            ManejadorEntidades.getInstancia().crearChampinionVerde(posicionX,posicionY+48);
        }
        if(entidadContenida == ConstantesBloquePregunta.ESTRELLA){
            ManejadorEntidades.getInstancia().crearEstrella(posicionX,posicionY+48);
        }
        if(entidadContenida == ConstantesBloquePregunta.FLORDEFUEGO){
            ManejadorEntidades.getInstancia().crearFlorDeFuego(posicionX,posicionY+48);
        }
        if(entidadContenida == ConstantesBloquePregunta.SUPERCHAMPINION){
            ManejadorEntidades.getInstancia().crearSuperChampinion(posicionX,posicionY+48);
        }
        entidadContenida = 0;
        
    }

    public void aceptar(Visitor visitor, int direccion){
        visitor.visit(this, direccion);
    }
}
