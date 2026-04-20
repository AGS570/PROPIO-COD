package Negocio;

import Presentacion.EventosCampo;
import Presentacion.GUIRespuestaActualizarCampo;
import Presentacion.GUIRespuestaCreaCampoExterior;
import Presentacion.GUIRespuestaCreaCampoInterior;
import Presentacion.GUIRespuestaEliminarCampo;
import Presentacion.GUIRespuestaMostrarCampo;
import Presentacion.GUIRespuestaMostrarTodos;

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
            if (datos instanceof TCampoExterior) {
                new GUIRespuestaCreaCampoExterior(res);
            } else {
                new GUIRespuestaCreaCampoInterior(res);
            }
        }
        else if (evento == EventosCampo.ELIMINAR_CAMPO) {
            int res = sa.delete((String) datos);
            new GUIRespuestaEliminarCampo(res);
        }
        else if (evento == EventosCampo.ACTUALIZAR_CAMPO) {
            int res = sa.update((TCampo) datos);
            new GUIRespuestaActualizarCampo(res == EventosCampo.ACTUALIZAR_OK);
        }
        else if (evento == EventosCampo.MOSTRAR_CAMPO) {
            TCampo t = sa.read((String) datos);
            new GUIRespuestaMostrarCampo(t);
        }
        else if (evento == EventosCampo.MOSTRAR_TODOS) {
            Collection<TCampo> lista = sa.readAll();
            new GUIRespuestaMostrarTodos(lista);
        }
    }
}
