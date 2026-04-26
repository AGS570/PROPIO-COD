package Negocio.Campos;

import Presentacion.Campos.EventosCampo;
import Presentacion.Campos.GUIRespuestaActualizarCampo;
import Presentacion.Campos.GUIRespuestaCreaCampoExterior;
import Presentacion.Campos.GUIRespuestaCreaCampoInterior;
import Presentacion.Campos.GUIRespuestaEliminarCampo;
import Presentacion.Campos.GUIRespuestaMostrarCampo;
import Presentacion.Campos.GUIRespuestaMostrarCamposMantenimiento;
import Presentacion.Campos.GUIRespuestaMostrarTodos;

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
            new GUIRespuestaActualizarCampo(res);
        }
        else if (evento == EventosCampo.MOSTRAR_CAMPO) {
            TCampo t = sa.read((String) datos);
            new GUIRespuestaMostrarCampo(t);
        }
        else if (evento == EventosCampo.MOSTRAR_CAMPOS || evento == EventosCampo.MOSTRAR_TODOS) {
            Collection<TCampo> lista = sa.readAll();
            new GUIRespuestaMostrarTodos(lista);
        }
        else if (evento == EventosCampo.MOSTRAR_CAMPOS_MANTENIMIENTO) {
            Collection<TCampo> lista = ((SACampoImp) sa).readCamposMantenimiento();
            new GUIRespuestaMostrarCamposMantenimiento(lista);
        }
    }
}
