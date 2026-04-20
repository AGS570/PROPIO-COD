
package presentacion.empleado;

import javax.swing.JOptionPane;

import negocio.empleado.TEmpleado;
import presentacion.IGUI;

public class GUIRespuestaMostrarEmpleado implements IGUI{

	@Override
	public void actualizar(int evento, Object datos) {
		if(evento == EventosEmpleado.MUESTRA_EMPLEADO_OK){
			TEmpleado empleado = (TEmpleado) datos;
			JOptionPane.showMessageDialog(null, "ID: " + empleado.getId() + "\nNIF: "+empleado.getnif()+"\nNombre: " + empleado.getNombre() +
					"\nSalario: " + empleado.getSalario() + "\nNúmero de Taquilla: " + empleado.getnumTaquilla());
		}
		else
			JOptionPane.showMessageDialog(null, "No se ha podido encontrar al empleado");
	}

}