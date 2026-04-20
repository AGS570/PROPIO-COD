package presentacion.pelicula;

import javax.swing.JOptionPane;
import negocio.pelicula.TPelicula;
import presentacion.IGUI;

public class GUIRespuestaMostrarPelicula implements IGUI {
	
	public void actualizar(int evento, Object datos) {
		if(evento == EventosPelicula.MUESTRA_PELICULA_OK){
			TPelicula peli = (TPelicula) datos;
			JOptionPane.showMessageDialog(null, "ID: " + peli.getId() + "\nNombre: " + peli.getNombre() + "\nDuración: " + peli.getDuracion() + "\nClasificación: " + peli.getClasificacion());
		}
		else
			JOptionPane.showMessageDialog(null, "No se ha podido encontrar dicha pelicula");
	}
	
}
