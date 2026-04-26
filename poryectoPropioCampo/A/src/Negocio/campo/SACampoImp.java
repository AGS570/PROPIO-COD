package Negocio.campo;

import java.util.Collection;

import Integracion.Factoria.FactoriaDAO;
import Integracion.campo.DAOCampo;
import Presentacion.Campo.EventosCampo;

public class SACampoImp implements SACampo {

    @Override
    public int create(TCampo tCampo) {
        if (tCampo == null || tCampo.getID() == null || tCampo.getID().isEmpty()) {
            return EventosCampo.CREAR_CAMPO_KO;
        }

        DAOCampo dao = FactoriaDAO.getInstance().getDAOCampo();
        TCampo existente = dao.read(tCampo.getID());
        
        if (existente == null) {
            int resultado = dao.create(tCampo);
            if (resultado == 1) {
                return EventosCampo.CREAR_CAMPO_OK;
            } else {
                return EventosCampo.CREAR_CAMPO_KO;
            }
        } else {
            return EventosCampo.CREAR_CAMPO_KO;
        }
    }

    @Override
    public TCampo read(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        DAOCampo dao = FactoriaDAO.getInstance().getDAOCampo();
        return dao.read(id);
    }

    @Override
    public Collection<TCampo> readAll() {
        DAOCampo dao = FactoriaDAO.getInstance().getDAOCampo();
        return dao.readAll();
    }

    @Override
    public int update(TCampo tCampo) {
        if (tCampo == null || tCampo.getID() == null) {
            return EventosCampo.ACTUALIZAR_CAMPO_KO;
        }

        DAOCampo dao = FactoriaDAO.getInstance().getDAOCampo();
        TCampo existente = dao.read(tCampo.getID());
        
        if (existente != null) {
            int resultado = dao.update(tCampo);
            if (resultado == 1) {
                return EventosCampo.ACTUALIZAR_CAMPO_OK;
            } else {
                return EventosCampo.ACTUALIZAR_CAMPO_KO;
            }
        } else {
            return EventosCampo.ACTUALIZAR_CAMPO_KO;
        }
    }

    @Override
    public int delete(String id) {
        if (id == null || id.isEmpty()) {
            return EventosCampo.ELIMINAR_CAMPO_KO;
        }

        DAOCampo dao = FactoriaDAO.getInstance().getDAOCampo();
        TCampo existente = dao.read(id);
        
        if (existente != null) {
            int resultado = dao.delete(id);
            if (resultado == 1) {
                return EventosCampo.ELIMINAR_CAMPO_OK;
            } else {
                return EventosCampo.ELIMINAR_CAMPO_KO;
            }
        } else {
            return EventosCampo.ELIMINAR_CAMPO_KO;
        }
    }

    // Método de mantenimiento detectado en tus diagramas
    public Collection<TCampo> readCamposMantenimiento() {
        DAOCampo dao = FactoriaDAO.getInstance().getDAOCampo();
        return dao.readCamposMantenimiento();
    }
}
