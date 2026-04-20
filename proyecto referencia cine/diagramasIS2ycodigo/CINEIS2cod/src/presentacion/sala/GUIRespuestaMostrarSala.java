package presentacion.sala;

import javax.swing.JOptionPane;
import negocio.sala.TSalaNormal;
import negocio.sala.TSalaVip;
import presentacion.IGUI;

public class GUIRespuestaMostrarSala implements IGUI {
	
	public void actualizar(int evento, Object datos) {
		if(evento == EventosSala.MUESTRA_SALA_OK){	
			if(datos instanceof TSalaVip){
				TSalaVip sala = (TSalaVip) datos;
				JOptionPane.showMessageDialog(null, "(VIP)\nID: " + sala.getId() + "\nNumero de sala: " + sala.getNumero_sala() + "\nAforo: " + sala.getAforo() + "\nAdaptada: " + sala.getAdaptada());
			}else{
				TSalaNormal sala = (TSalaNormal) datos;
				JOptionPane.showMessageDialog(null, "(Normal)\nID: " + sala.getId() + "\nNumero de sala: " + sala.getNumero_sala() + "\nAforo: " + sala.getAforo() + "\nNumero de anuncios: " + sala.getNum_anuncios());
			}
		}
		else
			JOptionPane.showMessageDialog(null, "No se ha podido encontrar dicha sala");
	}
	
}