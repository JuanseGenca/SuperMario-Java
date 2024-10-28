package Plataformas;

import Entidades.ManejadorEntidades;
import GUI.Sprite;
import Logica.Logica;
import Logica.Visitor;
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

    public void setEntidadContenida(int i){
        entidadContenida = i;
    }

    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }

    public void mover() {}

}
