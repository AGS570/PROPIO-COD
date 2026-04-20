package presentacion.empleado;

import javax.swing.JOptionPane;

import presentacion.IGUI;

public class GUIRespuestaCreaEmpleado implements IGUI{

	@Override
	public void actualizar(int evento, Object datos) {
		if(evento == EventosEmpleado.CREA_EMPLEADO_OK)
			JOptionPane.showMessageDialog(null, "Empleado con ID " + (int) datos + " creado con exito");
		else
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error al crear el empleado");
	
	}

}