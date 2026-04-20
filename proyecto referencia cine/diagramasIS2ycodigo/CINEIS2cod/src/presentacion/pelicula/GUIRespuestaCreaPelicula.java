package presentacion.pelicula;

import javax.swing.JOptionPane;
import presentacion.IGUI;

public class GUIRespuestaCreaPelicula implements IGUI {

	public void actualizar(int evento, Object datos) {
		if(evento == EventosPelicula.CREA_PELICULA_OK)
			JOptionPane.showMessageDialog(null, "Pelicula con ID " + (int) datos + " creada con exito");
		else
			JOptionPane.showMessageDialog(null, "Hubo un error al crear la pelicula");
	}

}
