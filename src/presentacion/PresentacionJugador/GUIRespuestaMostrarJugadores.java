package presentacion.PresentacionJugador;

import java.util.Collection;


import javax.swing.JOptionPane;


import Negocio.NegocioJugador.TJugador;
import presentacion.Eventos;
import presentacion.IGUI;

public class GUIRespuestaMostrarJugadores implements IGUI{

	@Override
	public void actualizar(int evento, Object datos) {
	    if (evento == Eventos.MOSTRAR_JUGADORES_OK) {
	        @SuppressWarnings("unchecked")
			Collection<TJugador> jugadores = (Collection<TJugador>) datos;
	        
	        StringBuilder listaTexto = new StringBuilder();
	        
	        for (TJugador j : jugadores) {
	            listaTexto.append("ID: ").append(j.getId()).append("\n");
	            listaTexto.append("Nombre: ").append(j.getNombre()).append("\n");
	            listaTexto.append("Telefono: ").append(j.getTelefono()).append("\n");
	            listaTexto.append("DNI: ").append(j.getDni()).append("\n");
	            listaTexto.append("Posición: ").append(j.getPosicion()).append("\n");
	            listaTexto.append("Pie: ").append(j.getPieDominante()).append("\n");
	            listaTexto.append("idEquipo: ").append(j.getIdEquipo()).append("\n\n");
	            
	        }
	        
	        JOptionPane.showMessageDialog(null, listaTexto.toString());
	    } else {
	        JOptionPane.showMessageDialog(null, "No hay jugadores para mostrar");
	    }
	}

}
