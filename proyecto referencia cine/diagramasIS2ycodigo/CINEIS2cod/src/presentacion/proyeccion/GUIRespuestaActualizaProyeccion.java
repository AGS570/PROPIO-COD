package presentacion.proyeccion;

import javax.swing.JOptionPane;
import presentacion.IGUI;

public class GUIRespuestaActualizaProyeccion implements IGUI{
	@Override
	public void actualizar(int evento, Object datos) {
		if(evento == EventosProyeccion.ACTUALIZA_OK)
			JOptionPane.showMessageDialog(null, "Proyeccion con ID " + (int) datos + " actualizada con exito");
		else 
			JOptionPane.showMessageDialog(null, "Hubo un error al actualizar la proyeccion");
	}

}
