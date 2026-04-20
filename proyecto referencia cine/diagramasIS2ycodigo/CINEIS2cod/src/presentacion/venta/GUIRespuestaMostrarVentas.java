package presentacion.venta;

import javax.swing.JOptionPane;

import negocio.venta.TVenta;
import presentacion.IGUI;

public class GUIRespuestaMostrarVentas implements IGUI {
	
	public void actualizar(int evento, Object datos) {
		if(evento == EventosVenta.MUESTRA_VENTAS_OK){
			TVenta[] ventas = (TVenta[]) datos;
			String listaTexto = "";
			
			for(int i = 0; i < ventas.length; i++)
				listaTexto += "ID: " + ventas[i].getId() + "\nID Vendedor: " + ventas[i].getID_Vendedor() + "\nFecha Compra: " + ventas[i].getFecha_Compra()+ "\nPrecio: " + ventas[i].getPrecio() + "\n\n";
			
			JOptionPane.showMessageDialog(null, listaTexto);
		}
		else
			JOptionPane.showMessageDialog(null, "No hay ventas para mostrar");
	}
}

