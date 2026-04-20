package presentacion.sala;

import javax.swing.JOptionPane;
import presentacion.IGUI;

public class GUIRespuestaCreaSalaNormal implements IGUI{

	public void actualizar(int evento, Object datos) {
		if(evento == EventosSala.CREA_SALA_OK)
			JOptionPane.showMessageDialog(null, "Sala normal con ID " + (int) datos + " creada con exito");
		else
			JOptionPane.showMessageDialog(null, "Hubo un error al crear la sala normal");
	}	
	
}