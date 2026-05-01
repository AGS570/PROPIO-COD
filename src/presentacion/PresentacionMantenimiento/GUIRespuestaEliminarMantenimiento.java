package presentacion.PresentacionMantenimiento;

import javax.swing.JOptionPane;
import presentacion.IGUI;
import presentacion.Mantenimiento.EventosMantenimiento;

public class GUIRespuestaEliminarMantenimiento implements IGUI {

	@Override
	public void actualizar(int evento, Object datos) {
		if(evento == EventosMantenimiento.ELIMINAR_MANTENIMIENTO_OK)
			JOptionPane.showMessageDialog(null, "Empleado de mantenimiento eliminado correctamente");
		else
			JOptionPane.showMessageDialog(null, "No se pudo eliminar el empleado de mantenimiento");
	}
}