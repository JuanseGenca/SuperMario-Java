package Nivel;

import Entidades.Entidad;
import GUI.*;
import Logica.Visitor;

public class Silueta extends Entidad {
	
	public Silueta(Sprite[] mi_sprite) {
		super( 0, 0,mi_sprite);
	}

    @Override
    public void aceptar(Visitor visitor, int direccion) {}

    @Override
    public void mover() {}
}
