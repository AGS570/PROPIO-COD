package Presentacion.Campo;

import java.util.Collection;

import javax.swing.JOptionPane;

import Negocio.campo.TCampo;

public class GUIRespuestaMostrarCamposMantenimiento {
    public GUIRespuestaMostrarCamposMantenimiento(int evento, Object datos) {
        if (evento == EventosCampo.MOSTRAR_CAMPOS_MANTENIMIENTO_OK) {
            @SuppressWarnings("unchecked")
            Collection<TCampo> lista = (Collection<TCampo>) datos;
            new GUIMostrarCamposMantenimiento(lista).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No hay campos de mantenimiento registrados", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
