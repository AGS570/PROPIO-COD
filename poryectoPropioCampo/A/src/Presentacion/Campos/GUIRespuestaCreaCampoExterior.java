package Presentacion.Campos;

import javax.swing.JOptionPane;

public class GUIRespuestaCreaCampoExterior {
    public GUIRespuestaCreaCampoExterior(int resultado) {
        if (resultado == EventosCampo.CREAR_CAMPO_OK) {
            JOptionPane.showMessageDialog(
                null,
                "Campo exterior dado de alta correctamente",
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                null,
                "Error: No se pudo crear el campo exterior",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
