package Negocio;

import java.util.Collection;
import Integracion.DAOCampo;
import Integracion.FactoriaDAO;
import Presentacion.EventosCampo;

public class SACampoImp implements SACampo {

    @Override
    public int create(TCampo tCampo) {
        if (tCampo == null || tCampo.getID() == null || tCampo.getID().isEmpty()) {
            return EventosCampo.CREAR_KO;
        }

        DAOCampo dao = FactoriaDAO.getInstance().getDAOCampo();
        TCampo existente = dao.read(tCampo.getID());
        
        if (existente == null) {
            int resultado = dao.create(tCampo);
            if (resultado == 1) {
                return EventosCampo.CREAR_OK;
            } else {
                return EventosCampo.CREAR_KO;
            }
        } else {
            return EventosCampo.CREAR_KO;
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
            return EventosCampo.ACTUALIZAR_KO;
        }

        DAOCampo dao = FactoriaDAO.getInstance().getDAOCampo();
        TCampo existente = dao.read(tCampo.getID());
        
        if (existente != null) {
            int resultado = dao.update(tCampo);
            if (resultado == 1) {
                return EventosCampo.ACTUALIZAR_OK;
            } else {
                return EventosCampo.ACTUALIZAR_KO;
            }
        } else {
            return EventosCampo.ACTUALIZAR_KO;
        }
    }

    @Override
    public int delete(String id) {
        if (id == null || id.isEmpty()) {
            return EventosCampo.ELIMINAR_KO;
        }

        DAOCampo dao = FactoriaDAO.getInstance().getDAOCampo();
        TCampo existente = dao.read(id);
        
        if (existente != null) {
            int resultado = dao.delete(id);
            if (resultado == 1) {
                return EventosCampo.ELIMINAR_OK;
            } else {
                return EventosCampo.ELIMINAR_KO;
            }
        } else {
            return EventosCampo.ELIMINAR_KO;
        }
    }

    // Método de mantenimiento detectado en tus diagramas
    public Collection<TCampo> readCamposMantenimiento() {
        DAOCampo dao = FactoriaDAO.getInstance().getDAOCampo();
        return dao.readCamposMantenimiento();
    }
}
