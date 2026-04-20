package presentacion.empleado;

import javax.swing.JOptionPane;

import presentacion.IGUI;

public class GUIRespuestaQuitaEmpleado implements IGUI {

	@Override
	public void actualizar(int evento, Object datos) {
		if(evento == EventosEmpleado.QUITA_EMPLEADO_OK)
			JOptionPane.showMessageDialog(null, "El empleado ha sido eliminado correctamente");
		else
			JOptionPane.showMessageDialog(null, "No se pudo eliminar el empleado correctamente");
	}

}