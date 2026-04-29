package presentacion.Campo;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import presentacion.Eventos;



public class GUIRespuestaActualizarCampo extends JFrame {
    public GUIRespuestaActualizarCampo(int resultado) {
    	
    	if(resultado == Eventos.ACTUALIZAR_CAMPO_OK) {
    		JOptionPane.showMessageDialog(this, "Campo actualizado correctamente"
    				, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    	}else {
    		JOptionPane.showMessageDialog(this, "Error al actualizar", "Resultado",
    				JOptionPane.ERROR_MESSAGE);
    	}
    }
}
