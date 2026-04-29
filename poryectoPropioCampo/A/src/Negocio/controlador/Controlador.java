package Negocio.controlador;

import java.util.Collection;

import Negocio.Factoria.FactoriaSA;
import Negocio.campo.SACampo;
import Negocio.campo.SACampoImp;
import Negocio.campo.TCampo;
import Negocio.campo.TCampoExterior;
import Presentacion.Campo.EventosCampo;
import Presentacion.Campo.GUIRespuestaActualizarCampo;
import Presentacion.Campo.GUIRespuestaCreaCampoExterior;
import Presentacion.Campo.GUIRespuestaCreaCampoInterior;
import Presentacion.Campo.GUIRespuestaEliminarCampo;
import Presentacion.Campo.GUIRespuestaMostrarCampo;
import Presentacion.Campo.GUIRespuestaMostrarCamposMantenimiento;
import Presentacion.Campo.GUIRespuestaMostrarTodos;

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
            new GUIRespuestaActualizarCampo(res);
        }
        else if (evento == EventosCampo.MOSTRAR_CAMPO) {
            TCampo t = sa.read((String) datos);
            int eventoRespuesta = (t != null) ? EventosCampo.MOSTRAR_CAMPO_OK : EventosCampo.MOSTRAR_CAMPO_KO;
            new GUIRespuestaMostrarCampo(eventoRespuesta, t);
        }
        else if (evento == EventosCampo.MOSTRAR_CAMPOS || evento == EventosCampo.MOSTRAR_TODOS) {
            Collection<TCampo> lista = sa.readAll();
            int eventoRespuesta = (lista != null && !lista.isEmpty()) ? EventosCampo.MOSTRAR_CAMPOS_OK : EventosCampo.MOSTRAR_CAMPOS_KO;
            new GUIRespuestaMostrarTodos(eventoRespuesta, lista);
        }
        else if (evento == EventosCampo.MOSTRAR_CAMPOS_MANTENIMIENTO) {
            Collection<TCampo> lista = ((SACampoImp) sa).readCamposMantenimiento();
            int eventoRespuesta = (lista != null && !lista.isEmpty())
                ? EventosCampo.MOSTRAR_CAMPOS_MANTENIMIENTO_OK
                : EventosCampo.MOSTRAR_CAMPOS_MANTENIMIENTO_KO;
            new GUIRespuestaMostrarCamposMantenimiento(eventoRespuesta, lista);
        }
    }
}
