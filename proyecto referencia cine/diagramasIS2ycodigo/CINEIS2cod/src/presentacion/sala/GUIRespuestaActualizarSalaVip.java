package presentacion.sala;

import javax.swing.JOptionPane;
import presentacion.IGUI;

public class GUIRespuestaActualizarSalaVip implements IGUI {
	
	public void actualizar(int evento, Object datos) {
		if(evento == EventosSala.ACTUALIZA_SALA_OK)
			JOptionPane.showMessageDialog(null, "Sala vip con ID " + (int) datos + " actualizada con exito");
		else
			JOptionPane.showMessageDialog(null, "Hubo un error al actualizar la sala");
	}
	
}
