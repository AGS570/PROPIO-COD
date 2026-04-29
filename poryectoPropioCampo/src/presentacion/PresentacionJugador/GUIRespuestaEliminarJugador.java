package presentacion.PresentacionJugador;

import javax.swing.JOptionPane;

import presentacion.Eventos;
import presentacion.IGUI;

public class GUIRespuestaEliminarJugador implements IGUI{

	@Override
	public void actualizar(int evento, Object datos) {
		if(evento == Eventos.ELIMINAR_JUGADOR_OK)
			JOptionPane.showMessageDialog(null, "Jugador eliminado correctamente");
		else
			JOptionPane.showMessageDialog(null, "No se pudo eliminar el jugador ");
	}

}
