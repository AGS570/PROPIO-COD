package presentacion.PresentacionJugador;

import javax.swing.JOptionPane;

import Negocio.NegocioJugador.TJugador;
import presentacion.Eventos;
import presentacion.IGUI;

public class GUIRespuestaMostrarJugador implements IGUI{

	@Override
	public void actualizar(int evento, Object datos) {
		if(evento == Eventos.MOSTRAR_JUGADOR_OK){
			TJugador tj = (TJugador) datos;
			JOptionPane.showMessageDialog(null, "ID: " + tj.getId() + "\nNombre: " + tj.getNombre() + "\nDNI: " + tj.getDni() + "\nTelefono: " + tj.getTelefono()+
			"\nPosicion: " + tj.getPosicion() + "\nPie: "+ tj.getPieDominante() + "\nidEquipo: " + tj.getIdEquipo());
		}
		else
			JOptionPane.showMessageDialog(null, "No se ha podido encontrar el jugador");
		
	}

}
