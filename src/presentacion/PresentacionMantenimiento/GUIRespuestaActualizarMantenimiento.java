package presentacion.PresentacionMantenimiento;

import javax.swing.JOptionPane;
import presentacion.IGUI;
import presentacion.Mantenimiento.EventosMantenimiento;

public class GUIRespuestaActualizarMantenimiento implements IGUI {

	@Override
	public void actualizar(int evento, Object datos) {
		if(evento == EventosMantenimiento.ACTUALIZAR_MANTENIMIENTO_OK)
			JOptionPane.showMessageDialog(null, "Empleado de mantenimiento con ID " + (int) datos + " actualizado con éxito");
		else
			JOptionPane.showMessageDialog(null, "Hubo un error al actualizar el empleado de mantenimiento");
	}
}