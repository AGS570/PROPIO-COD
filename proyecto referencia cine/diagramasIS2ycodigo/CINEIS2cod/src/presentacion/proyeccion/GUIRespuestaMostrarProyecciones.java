package presentacion.proyeccion;

import javax.swing.JOptionPane;
import negocio.proyeccion.TProyeccion;
import presentacion.IGUI;

public class GUIRespuestaMostrarProyecciones implements IGUI{

	@Override
	public void actualizar(int evento, Object datos) {
		if(evento == EventosProyeccion.MOSTRAR_TODOS_OK){
			TProyeccion[] proyecciones = (TProyeccion[]) datos;
			String listaTexto = "";
			
			for(int i = 0; i < proyecciones.length; i++)
				listaTexto += "ID: " + proyecciones[i].getID() + "\nNumero Entradas: " + proyecciones[i].getNumEntradas() +
				"\nNombre Interno: " + proyecciones[i].getNombreInterno() + "\nFecha: " + proyecciones[i].getFecha() +
				"\nHora: " + proyecciones[i].getHora() + "\nID sala: " + proyecciones[i].getId_sala() +
				"\nID pelicula: " + proyecciones[i].getId_pelicula() + "\nPrecio: " + proyecciones[i].getPrecio() + "\n\n";
			
			JOptionPane.showMessageDialog(null, listaTexto);
		}else
			JOptionPane.showMessageDialog(null, "No hay proyecciones para mostrar");
	}

}