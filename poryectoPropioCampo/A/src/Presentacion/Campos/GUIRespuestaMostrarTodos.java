package Presentacion.Campos;

import java.util.Collection;

import javax.swing.JOptionPane;

import Negocio.Campos.TCampo;

public class GUIRespuestaMostrarTodos {
    public GUIRespuestaMostrarTodos(int evento, Object datos) {
        if (evento == EventosCampo.MOSTRAR_CAMPOS_OK) {
            @SuppressWarnings("unchecked")
            Collection<TCampo> lista = (Collection<TCampo>) datos;
            new GUIMostrarTodos(lista).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No hay campos registrados en el sistema", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
