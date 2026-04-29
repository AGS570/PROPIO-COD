package presentacion.Campo;

import java.util.Collection;

import javax.swing.JOptionPane;

import Negocio.Campo.TCampo;
import presentacion.Eventos;

public class GUIRespuestaMostrarCamposMantenimiento {
    public GUIRespuestaMostrarCamposMantenimiento(int evento, Object datos) {
        if (evento == Eventos.MOSTRAR_CAMPOS_DEL_MANTENIMIENTO_OK) {
            @SuppressWarnings("unchecked")
            Collection<TCampo> lista = (Collection<TCampo>) datos;
            new GUIMostrarCamposMantenimiento(lista).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No hay campos de mantenimiento registrados", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
