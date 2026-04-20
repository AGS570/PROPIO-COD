package Presentacion;

import javax.swing.JOptionPane;

public class GUIRespuestaCreaCampo {
    public GUIRespuestaCreaCampo(int resultado) {
        if (resultado == EventosCampo.CREAR_OK) {
            JOptionPane.showMessageDialog(null, "Campo dado de alta correctamente", 
                                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error: No se pudo crear el campo (ID duplicado o datos inválidos)", 
                                        "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}