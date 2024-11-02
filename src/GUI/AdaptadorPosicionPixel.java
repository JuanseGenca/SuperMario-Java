package GUI;

public class AdaptadorPosicionPixel {
	
	public static int transformarX(int x) {
		return x;
	}
	
	// Las coordenadas gráficas se miden de arriba hacia abajo
	public static int transformarY(int altura) {
		return ConstantesVistas.PANEL_ALTO - altura - ConstantesVistas.PADDING;
	}
}