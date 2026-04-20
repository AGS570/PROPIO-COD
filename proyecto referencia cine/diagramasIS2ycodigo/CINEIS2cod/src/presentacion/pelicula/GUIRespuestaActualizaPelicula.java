package presentacion.pelicula;

import javax.swing.JOptionPane;
import presentacion.IGUI;

public class GUIRespuestaActualizaPelicula implements IGUI {
	
	public void actualizar(int evento, Object datos) {
		if(evento == EventosPelicula.ACTUALIZA_PELICULA_OK)
			JOptionPane.showMessageDialog(null, "Pelicula con ID " + (int) datos + " actualizada con exito");
		else
			JOptionPane.showMessageDialog(null, "Hubo un error al actualizar la pelicula");
	}
	
}
