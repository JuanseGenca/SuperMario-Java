package Nivel;

import Entidades.Entidad;
import Fabricas.SpriteFactory;
import GUI.*;
import Logica.Visitor;

public class Silueta extends Entidad {
	
	public Silueta(Sprite mi_sprite, SpriteFactory sf) {
		super( 0, 0,mi_sprite, sf);
	}

    @Override
    public void aceptar(Visitor visitor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'aceptar'");
    }

    @Override
    public void mover() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mover'");
    }
}
