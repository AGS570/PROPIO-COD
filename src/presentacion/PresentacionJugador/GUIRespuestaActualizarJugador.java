package presentacion.PresentacionJugador;

import javax.swing.JOptionPane;

import presentacion.Eventos;
import presentacion.IGUI;

public class GUIRespuestaActualizarJugador implements IGUI{

	@Override
	public void actualizar(int evento, Object datos) {
		if(evento == Eventos.ACTUALIZAR_JUGADOR_OK)
			JOptionPane.showMessageDialog(null, "Jugador con ID " + (int) datos + " actualizado con exito");
		else
			JOptionPane.showMessageDialog(null, "Hubo un error al actualizar el jugador");
		
	}

}
