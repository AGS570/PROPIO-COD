package presentacion.venta;

import javax.swing.JOptionPane;

import negocio.venta.TVenta;
import presentacion.IGUI;

public class GUIRespuestaMostrarVenta implements IGUI {
	
	public void actualizar(int evento, Object datos) {
		if(evento == EventosVenta.MUESTRA_VENTA_OK){
			TVenta venta = (TVenta) datos;
			JOptionPane.showMessageDialog(null, "ID: " + venta.getId() + "\nID Vendedor: " + venta.getID_Vendedor() + "\nFecha Compra: " + venta.getFecha_Compra()+ "\nPrecio: " + venta.getPrecio());
		}
		else
			JOptionPane.showMessageDialog(null, "No se ha podido encontrar dicha venta");
	}
}