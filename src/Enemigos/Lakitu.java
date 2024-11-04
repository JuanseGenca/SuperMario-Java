package Enemigos;

import Entidades.ManejadorEntidades;
import GUI.Sprite;
import Logica.Visitor;
import java.util.Timer;
import java.util.TimerTask;

public class Lakitu extends Enemigo{
    
    private Timer timer;

    public Lakitu(int x, int y,Sprite[] sprite){
        super(x,y,sprite);
        puntaje=60;
    }
   
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }
    
    private void spawnearSpiny(){
        ManejadorEntidades.getInstancia().crearSpiny(posicionX, posicionY);
    }

    public void iniciarReloj(long intervalo) {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                spawnearSpiny();
            }
        }, 0, intervalo);
    }

    public void detenerReloj() {
        if (timer != null) {
            timer.cancel();
        }
    }

    public void eliminar(){
        detenerReloj();
        ManejadorEntidades.getInstancia().eliminarEnemigo(this);
        miObserver.eliminar();
    }
}
