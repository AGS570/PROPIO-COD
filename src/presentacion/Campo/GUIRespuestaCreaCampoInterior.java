package presentacion.Campo;

import javax.swing.JOptionPane;

import Presentacion.EventosCampo;
import presentacion.Eventos;
public class GUIRespuestaCreaCampoInterior {
    public GUIRespuestaCreaCampoInterior(int resultado) {
        if (resultado == Eventos.CREAR_CAMPO_OK) {
            JOptionPane.showMessageDialog(
                null,
                "Campo interior dado de alta correctamente",
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                null,
                "Error: No se pudo crear el campo interior",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
