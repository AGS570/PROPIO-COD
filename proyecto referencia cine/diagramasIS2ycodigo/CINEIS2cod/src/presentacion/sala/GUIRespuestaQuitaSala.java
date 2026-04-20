package presentacion.sala;

import javax.swing.JOptionPane;
import presentacion.IGUI;

public class GUIRespuestaQuitaSala implements IGUI {
	
	public void actualizar(int evento, Object datos) {
		if(evento == EventosSala.QUITA_SALA_OK)
			JOptionPane.showMessageDialog(null, "Sala y sus proyecciones asociadas eliminadas correctamente");
		else
			JOptionPane.showMessageDialog(null, "No se pudo eliminar la sala correctamente");
	}

}
