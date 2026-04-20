package presentacion.pelicula;

import javax.swing.JOptionPane;
import presentacion.IGUI;

public class GUIRespuestaQuitaPelicula implements IGUI {

	public void actualizar(int evento, Object datos) {
		if(evento == EventosPelicula.QUITA_PELICULA_OK)
			JOptionPane.showMessageDialog(null, "Pelicula y sus proyecciones asociadas eliminadas correctamente");
		else
			JOptionPane.showMessageDialog(null, "No se pudo eliminar la pelicula correctamente");
	}
	
}
