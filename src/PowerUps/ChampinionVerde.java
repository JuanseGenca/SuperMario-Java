package PowerUps;

import Entidades.ManejadorEntidades;
import GUI.Sprite;
import Logica.Visitor;
import Visitors.VisitorChampinionVerde;

public class ChampinionVerde extends PowerUp{
    public ChampinionVerde(int x, int y,Sprite[] sprite){
        super(x,y, sprite);
        visitor = new VisitorChampinionVerde();
    }
    public void mover(){
        
    }
    @Override
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }
    public void eliminar(){
        ManejadorEntidades.getInstancia().eliminarPowerUp(this);
    }
}
