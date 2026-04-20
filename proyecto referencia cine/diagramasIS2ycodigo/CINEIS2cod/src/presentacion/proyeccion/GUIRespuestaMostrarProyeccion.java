package presentacion.proyeccion;

import javax.swing.JOptionPane;
import negocio.proyeccion.TProyeccion;
import presentacion.IGUI;

public class GUIRespuestaMostrarProyeccion implements IGUI{

	@Override
	public void actualizar(int evento, Object datos) {
		if(evento == EventosProyeccion.MOSTRAR_OK){
			TProyeccion proy = (TProyeccion) datos;
			JOptionPane.showMessageDialog(null, "ID: " + proy.getID() + "\nNumero entradas: " + proy.getNumEntradas() + 
					"\nNombre interno: " + proy.getNombreInterno() + "\nFecha: " + proy.getFecha() + "\nHora: " + proy.getHora() + 
					"\nID sala: " + proy.getId_sala() + "\nID pelicula: " + proy.getId_pelicula() + "\nPrecio: " + proy.getPrecio());
		}
		else
			JOptionPane.showMessageDialog(null, "No se ha podido encontrar dicha proyeccion");
	}

}
