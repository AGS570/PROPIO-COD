package Presentacion;

import javax.swing.JOptionPane;
import java.util.Collection;
import Negocio.TCampo;

public class GUIRespuestaMostrarCamposMantenimiento {
    public GUIRespuestaMostrarCamposMantenimiento(Collection<TCampo> lista) {
        if (lista != null && !lista.isEmpty()) {
            new GUIMostrarCamposMantenimiento(lista).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(
                null,
                "No hay campos de mantenimiento registrados",
                "Información",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}
