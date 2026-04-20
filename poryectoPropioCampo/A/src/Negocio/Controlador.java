package Negocio;

import Presentacion.*;
import java.util.Collection;

public class Controlador {
    private static Controlador instance;

    public static Controlador getInstance() {
        if (instance == null) {
            instance = new Controlador();
        }
        return instance;
    }

    public void accion(int evento, Object datos) {
        SACampo sa = FactoriaSA.getInstance().getSACampo();

        if (evento == EventosCampo.CREAR_CAMPO) {
            int res = sa.create((TCampo) datos);
            new GUIRespuestaCreaCampo(res);
        } 
        else if (evento == EventosCampo.ELIMINAR_CAMPO) {
            int res = sa.delete((String) datos);
            new GUIRespuestaEliminarCampo(res);
        }
        else if (evento == EventosCampo.ACTUALIZAR_CAMPO) {
            int res = sa.update((TCampo) datos);
            if (res == EventosCampo.ACTUALIZAR_OK) {
                new GUIRespuestaActualizarCampo(true);
            } else {
                new GUIRespuestaActualizarCampo(false);
            }
        }
        else if (evento == EventosCampo.MOSTRAR_CAMPO) {
            TCampo t = sa.read((String) datos);
            if (t != null) {
                // Abrir la ventana de detalle correcta según el subtipo
                if (t instanceof TCampoExterior) {
                    new GUIMostrarCampoExterior((TCampoExterior) t).setVisible(true);
                } else {
                    new GUIMostrarCampoInterior((TCampoInterior) t).setVisible(true);
                }
            } else {
                new GUIRespuestaGenerica("No se encontró el campo");
            }
        }
        else if (evento == EventosCampo.MOSTRAR_TODOS) {
            Collection<TCampo> lista = sa.readAll();
            // Lógica para actualizar la tabla en la GUI
        }
    }
}