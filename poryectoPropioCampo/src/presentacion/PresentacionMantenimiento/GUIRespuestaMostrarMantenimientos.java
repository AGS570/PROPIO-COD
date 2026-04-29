package presentacion.PresentacionMantenimiento;

import java.util.Collection;
import javax.swing.JOptionPane;
import Negocio.NegocioMantenimiento.TMantenimiento;
import presentacion.IGUI;
import presentacion.Mantenimiento.EventosMantenimiento;

public class GUIRespuestaMostrarMantenimientos implements IGUI {

	@Override
	public void actualizar(int evento, Object datos) {
		if (evento == EventosMantenimiento.MOSTRAR_TODOS_MANTENIMIENTO_OK) {
			@SuppressWarnings("unchecked")
			Collection<TMantenimiento> mantenimientos = (Collection<TMantenimiento>) datos;
			
			StringBuilder listaTexto = new StringBuilder();
			
			for (TMantenimiento m : mantenimientos) {
				listaTexto.append("ID: ").append(m.getId()).append("\n");
				listaTexto.append("Nombre: ").append(m.getNombre()).append("\n");
				listaTexto.append("DNI: ").append(m.getDNI()).append("\n");
				listaTexto.append("Teléfono: ").append(m.getTlf()).append("\n");
				listaTexto.append("Salario: ").append(m.getSalario()).append("\n");
				listaTexto.append("Tipo: ").append(m.getTipoMantenimiento()).append("\n\n");
			}
			
			if (mantenimientos.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No hay empleados de mantenimiento registrados");
			} else {
				JOptionPane.showMessageDialog(null, listaTexto.toString(), "Lista de Mantenimiento", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Error al mostrar la lista de empleados");
		}
	}
}