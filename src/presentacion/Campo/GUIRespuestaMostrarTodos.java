package presentacion.Campo;

import javax.swing.JOptionPane;
import java.util.Collection;
import Negocio.Campo.TCampo;

import presentacion.Eventos;


public class GUIRespuestaMostrarTodos {
    public GUIRespuestaMostrarTodos(int evento, Object datos) {
        if (evento == Eventos.MOSTRAR_CAMPOS_OK) {
            @SuppressWarnings("unchecked")
            Collection<TCampo> lista = (Collection<TCampo>) datos;
            new GUIMostrarTodos(lista).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No hay campos registrados en el sistema", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
