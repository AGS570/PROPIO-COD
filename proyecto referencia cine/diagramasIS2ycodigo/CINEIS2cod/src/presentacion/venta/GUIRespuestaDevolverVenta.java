package presentacion.venta;

import javax.swing.JOptionPane;

import presentacion.IGUI;

public class GUIRespuestaDevolverVenta implements IGUI {
	
	public void actualizar(int evento, Object datos) {
		if(evento == EventosVenta.DEVUELVE_VENTA_OK)
			JOptionPane.showMessageDialog(null, "Venta devuelta correctamente en todas las proyecciones existentes");
		else
			JOptionPane.showMessageDialog(null, "No se pudo devolver la venta");
	}
	
}
