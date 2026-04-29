package presentacion.PresentacionMantenimiento;

import javax.swing.JOptionPane;
import presentacion.IGUI;
import presentacion.Mantenimiento.EventosMantenimiento;

public class GUIRespuestaCrearMantenimiento implements IGUI {

	@Override
	public void actualizar(int evento, Object datos) {
		if(evento == EventosMantenimiento.CREAR_MANTENIMIENTO_OK)
			JOptionPane.showMessageDialog(null, "Empleado de mantenimiento con ID " + (int) datos + " creado con éxito");
		else
			JOptionPane.showMessageDialog(null, "Hubo un error al crear el empleado de mantenimiento");
	}
}