package presentacion.venta;

import javax.swing.JOptionPane;

import negocio.venta.TLineaVenta;
import presentacion.IGUI;

public class GUIRespuestaMuestraLineasVenta implements IGUI {
	
	public void actualizar(int evento, Object datos) {
		if(evento == EventosVenta.MUESTRA_LINEAS_VENTA_OK){
			TLineaVenta[] lineasVenta = (TLineaVenta[]) datos;
			String listaTexto = "";

			for(int i = 0; i < lineasVenta.length; i++)
				listaTexto += "ID: " + lineasVenta[i].getIdVenta() + "\nID Proyeccion: " + lineasVenta[i].getIdProyeccion() + "\nCantidad entradas: " + lineasVenta[i].getCantidadEntradas() +"\n\n";
			
			JOptionPane.showMessageDialog(null, listaTexto);
		}
		else
			JOptionPane.showMessageDialog(null, "No hay lineas de venta para mostrar");
	}
}
