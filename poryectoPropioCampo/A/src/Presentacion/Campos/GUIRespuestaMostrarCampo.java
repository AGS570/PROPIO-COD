package Presentacion.Campos;

import javax.swing.JOptionPane;

import Negocio.Campos.TCampo;

public class GUIRespuestaMostrarCampo {
    public GUIRespuestaMostrarCampo(int evento, Object datos) {
        if (evento == EventosCampo.MOSTRAR_CAMPO_OK) {
            TCampo t = (TCampo) datos;
            new GUIMostrarCampo(t).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Error: El campo no existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
