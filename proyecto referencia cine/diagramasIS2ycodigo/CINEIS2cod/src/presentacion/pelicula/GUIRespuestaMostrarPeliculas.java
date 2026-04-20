package presentacion.pelicula;

import javax.swing.JOptionPane;
import negocio.pelicula.TPelicula;
import presentacion.IGUI;

public class GUIRespuestaMostrarPeliculas implements IGUI {
	
	public void actualizar(int evento, Object datos) {
		if(evento == EventosPelicula.MUESTRA_PELICULAS_OK){
			TPelicula[] pelis = (TPelicula[]) datos;
			String listaTexto = "";
			
			for(int i = 0; i < pelis.length; i++)
				listaTexto += "ID: " + pelis[i].getId() + "\nNombre: " + pelis[i].getNombre() + "\nDuración: " + pelis[i].getDuracion() + "\nClasificación: " + pelis[i].getClasificacion() + "\n\n";
			
			JOptionPane.showMessageDialog(null, listaTexto);
		}
		else
			JOptionPane.showMessageDialog(null, "No hay peliculas para mostrar");
	}
	
}
