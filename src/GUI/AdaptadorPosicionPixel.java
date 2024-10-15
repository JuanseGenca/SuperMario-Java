package GUI;

public class AdaptadorPosicionPixel {
	
	public static int transformarX(int x) {
		return x;
	}
	
	// Las coordenadas gráficas se miden de arriba hacia abajo
	public static int transformarY(int y) {
		return ConstantesVistas.PANEL_ALTO - y - ConstantesVistas.PADDING;
	}
}