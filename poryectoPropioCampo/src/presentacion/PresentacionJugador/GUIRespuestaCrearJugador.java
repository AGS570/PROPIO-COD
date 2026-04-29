package presentacion.PresentacionJugador;

import javax.swing.JOptionPane;

import presentacion.Eventos;
import presentacion.IGUI;

public class GUIRespuestaCrearJugador implements IGUI{

	@Override
	public void actualizar(int evento, Object datos) {
		if(evento == Eventos.CREAR_JUGADOR_OK)
			JOptionPane.showMessageDialog(null, "Jugador con ID " + (int) datos + " creado con exito");
		else
			JOptionPane.showMessageDialog(null, "Hubo un error al crear el jugador");
	
	}

}
