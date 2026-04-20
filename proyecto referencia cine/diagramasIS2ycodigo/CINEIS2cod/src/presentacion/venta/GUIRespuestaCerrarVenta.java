package presentacion.venta;

import javax.swing.JOptionPane;

import presentacion.IGUI;

public class GUIRespuestaCerrarVenta implements IGUI {

	public void actualizar(int evento, Object datos) {
		if(evento == EventosVenta.CIERRA_VENTA_OK)
			JOptionPane.showMessageDialog(null, "Venta con ID " + (int)datos + " cerrada correctamente");
		else
			JOptionPane.showMessageDialog(null, "No se pudo cerrar la venta correctamente (se han procesado las lineas de venta hasta el fallo)");
	}
	
}
