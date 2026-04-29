package Presentacion.Campos;

import javax.swing.JOptionPane;
import java.util.Collection;
import Negocio.Campos.TCampo;

public class GUIRespuestaMostrarTodos {
    public GUIRespuestaMostrarTodos(Collection<TCampo> lista) {
        if (lista != null && !lista.isEmpty()) {
            // Si hay datos, abrimos la tabla
            new GUIMostrarTodos(lista).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No hay campos registrados en el sistema", 
                                        "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}