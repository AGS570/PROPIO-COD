package presentacion.Campo;

import javax.swing.JOptionPane;

import presentacion.Eventos;

public class GUIRespuestaEliminarCampo {
    
    public GUIRespuestaEliminarCampo(int resultado) {
        if (resultado == Eventos.ELIMINAR_CAMPO_OK) {
            JOptionPane.showMessageDialog(null, "El campo ha sido eliminado correctamente.", 
                                        "Baja confirmada", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error: No se ha podido eliminar el campo. Compruebe que el ID existe.", 
                                        "Error en Baja", JOptionPane.ERROR_MESSAGE);
        }
    }
}