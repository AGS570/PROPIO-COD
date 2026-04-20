package presentacion.sala;

import javax.swing.JOptionPane;
import negocio.sala.TSala;
import negocio.sala.TSalaNormal;
import negocio.sala.TSalaVip;
import presentacion.IGUI;

public class GUIRespuestaMostrarSalas implements IGUI{

	public void actualizar(int evento, Object datos) {
		if(evento == EventosSala.MUESTRA_SALAS_OK){
			TSala[] salas = (TSala[]) datos;
			String listaTexto = "";
			
			for(int i = 0; i < salas.length; i++){
				if(salas[i] instanceof TSalaNormal){
					TSalaNormal sala = (TSalaNormal) salas[i];
					listaTexto += "(Normal)\nID: " + sala.getId() + "\nNumero de Sala: " + sala.getNumero_sala() + "\nAforo: " + sala.getAforo() + "\nNumero de anuncios: " + sala.getNum_anuncios()+ "\n\n";
				}else{
					TSalaVip sala = (TSalaVip) salas[i];
					listaTexto += "(VIP)\nID: " + sala.getId() + "\nNumero de Sala: " + sala.getNumero_sala() + "\nAforo: " + sala.getAforo() + "\nAdaptada: " + sala.getAdaptada()+ "\n\n";
				}
			}
				
			JOptionPane.showMessageDialog(null, listaTexto);
		}
		else
			JOptionPane.showMessageDialog(null, "No hay salas para mostrar");
	}
	
}