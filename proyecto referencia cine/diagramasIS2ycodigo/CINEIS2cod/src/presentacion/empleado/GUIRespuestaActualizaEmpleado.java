package presentacion.empleado;

import javax.swing.JOptionPane;

import presentacion.IGUI;

public class GUIRespuestaActualizaEmpleado implements IGUI{

	@Override
	public void actualizar(int evento, Object datos) {
		if(evento == EventosEmpleado.ACTUALIZA_EMPLEADO_OK)
			JOptionPane.showMessageDialog(null, "Empleado con ID " + (int) datos + " actualizado con exito");
		else
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error al actualizar el empleado");
	
	}

}