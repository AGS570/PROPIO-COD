package presentacion.proyeccion;

import javax.swing.JOptionPane;

import presentacion.IGUI;

public class GUIRespuestaCreaProyeccion implements IGUI{
	@Override
	public void actualizar(int evento, Object datos) {
		if(evento == EventosProyeccion.CREA_OK)
			JOptionPane.showMessageDialog(null, "Proyeccion con ID " + (int) datos + " creada con exito");
		else
			JOptionPane.showMessageDialog(null, "Hubo un error al crear la proyeccion");
	}
}
