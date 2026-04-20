package presentacion.empleado;

import javax.swing.JOptionPane;

import negocio.empleado.TEmpleado;
import presentacion.IGUI;

public class GUIRespuestaMostrarEmpleados implements IGUI {

	@Override
	public void actualizar(int evento, Object datos) {
		if (evento == EventosEmpleado.MUESTRA_EMPLEADOS_OK) {
			TEmpleado[] empleado = (TEmpleado[]) datos;
			String textomostraremp = "";

			for (int i = 0; i < empleado.length; i++)
				textomostraremp += "ID: " + empleado[i].getId() + "\nNIF: " + empleado[i].getnif() + "\nNombre: " + empleado[i].getNombre() + "\nSalario: " + empleado[i].getSalario() + "\nNúmero de Taquilla: " + empleado[i].getnumTaquilla() + "\n\n";
			
			JOptionPane.showMessageDialog(null, textomostraremp);
		} else
			JOptionPane.showMessageDialog(null, "No hay empleados para mostrar");
	}

}