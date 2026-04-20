package presentacion.proyeccion;

import javax.swing.JOptionPane;
import presentacion.IGUI;

public class GUIRespuestaQuitaProyeccion implements IGUI{
	@Override
	public void actualizar(int evento, Object datos) {
		if(evento == EventosProyeccion.QUITA_OK)
			JOptionPane.showMessageDialog(null, "Proyeccion eliminada correctamente");
		else
			JOptionPane.showMessageDialog(null, "No se pudo eliminar la proyeccion correctamente");
	}

}