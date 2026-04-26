package Presentacion;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GUIRespuestaActualizarCampo extends JFrame {
    public GUIRespuestaActualizarCampo(int resultado) {
        boolean exito = (resultado == EventosCampo.ACTUALIZAR_CAMPO_OK);
        String msg = exito ? "Campo actualizado correctamente" : "Error al actualizar";
        JOptionPane.showMessageDialog(this, msg, "Resultado", 
            exito ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
    }
}
