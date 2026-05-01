package presentacion.Campo;

import javax.swing.JOptionPane;

import presentacion.Eventos;

public class GUIRespuestaCrearCampo {
    public GUIRespuestaCrearCampo(int resultado) {
        if (resultado == Eventos.CREAR_CAMPO_OK) {
            JOptionPane.showMessageDialog(
                null,
                "Campo dado de alta correctamente",
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                null,
                "Error: No se pudo crear el campo",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
