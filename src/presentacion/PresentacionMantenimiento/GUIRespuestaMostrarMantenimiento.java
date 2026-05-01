package presentacion.PresentacionMantenimiento;

import javax.swing.JOptionPane;
import Negocio.NegocioMantenimiento.TMantenimiento;
import presentacion.IGUI;
import presentacion.Mantenimiento.EventosMantenimiento;

public class GUIRespuestaMostrarMantenimiento implements IGUI {

	@Override
	public void actualizar(int evento, Object datos) {
		if(evento == EventosMantenimiento.MOSTRAR_MANTENIMIENTO_OK) {
			TMantenimiento tm = (TMantenimiento) datos;
			JOptionPane.showMessageDialog(null, 
				"ID: " + tm.getId() + 
				"\nNombre: " + tm.getNombre() + 
				"\nDNI: " + tm.getDNI() + 
				"\nTeléfono: " + tm.getTlf() +
				"\nSalario: " + tm.getSalario() + 
				"\nTipo: " + tm.getTipoMantenimiento());
		}
		else
			JOptionPane.showMessageDialog(null, "No se ha podido encontrar el empleado de mantenimiento");
	}
}