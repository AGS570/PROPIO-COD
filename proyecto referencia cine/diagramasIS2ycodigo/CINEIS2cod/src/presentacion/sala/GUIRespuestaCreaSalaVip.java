package presentacion.sala;

import javax.swing.JOptionPane;
import presentacion.IGUI;

public class GUIRespuestaCreaSalaVip implements IGUI{

	public void actualizar(int evento, Object datos) {
		if(evento == EventosSala.CREA_SALA_OK)
			JOptionPane.showMessageDialog(null, "Sala vip con ID " + (int) datos + " creada con exito");
		else
			JOptionPane.showMessageDialog(null, "Hubo un error al crear la sala vip");
	}	

}
