package Enemigos;

import Entidades.HitboxesEntidad;
import Estados.EstadoKoopaTroopa;
import Estados.EstadoKoopaTroopaNormal;
import GUI.Sprite;
import Logica.Visitor;

public class KoopaTroopa extends Enemigo{

    protected EstadoKoopaTroopa estadoKoopaTroopa;

    public KoopaTroopa(int x, int y,Sprite[] sprite){
        super(x, y,sprite);
        puntaje=90;
        estadoKoopaTroopa = new EstadoKoopaTroopaNormal(this);
        miHitboxes = new HitboxesEntidad(posicionX, posicionY-24, 48, 48);
        this.posicionY=posicionY+24;
    }
    
    public void aceptar(Visitor v, int direccion){
        v.visit(this, direccion);
    }

    //Koopa necesita su propio actualizarHitbox porque es la unica entidad cuyo hitbox no es del mismo tamaño que su sprite
    public void actualizarHitboxes(int posicionX, int posicionY, int ancho, int alto) {
        miHitboxes.actualizarHitboxes(posicionX, posicionY-24, 48, 48);
    }

    public EstadoKoopaTroopa getEstado(){
        return estadoKoopaTroopa;
    }

    public void setEstado(EstadoKoopaTroopa e){
        estadoKoopaTroopa = e;
    }

    public void recibirDanio(){
        velocidadX = 0;
        spriteActual = misSprites[1];
        actualizar(direccion, estadoAereo);
        estadoKoopaTroopa.recibirDanio();
        
    }
    
    public void setVisitor(Visitor v){
        visitor = v;
    }
}
