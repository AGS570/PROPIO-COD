package Presentacion.Campo;

import javax.swing.JOptionPane;

import Negocio.campo.TCampo;

public class GUIRespuestaMostrarCampo {
    public GUIRespuestaMostrarCampo(TCampo t) {
        if (t != null) {
            // Si el transfer no es nulo, abrimos la ventana de detalle que creamos antes
            new GUIMostrarCampo(t).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Error: El campo no existe", 
                                        "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}