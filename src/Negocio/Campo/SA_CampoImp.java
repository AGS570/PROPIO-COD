package Negocio.Campo;

import java.util.Collection;
import Integracion.Campo.DAOCampo;
import Integracion.FactoriaDAO;
import Integracion.FactoriaIntegracion;
import Presentacion.Campo.EventosCampo;
import presentacion.Eventos;

public class SA_CampoImp implements SA_Campo {

    @Override
    public int create(TCampo tCampo) {
        if (tCampo == null || tCampo.getID() == null || tCampo.getID().isEmpty()) {
            return Eventos.CREAR_CAMPO_KO;
        }

        DAOCampo dao = FactoriaIntegracion.getInstance().hacerDAOCampo();
        TCampo existente = dao.read(tCampo.getID());
        
        if (existente == null) {
            int resultado = dao.create(tCampo);
            if (resultado >= 0) {
                return Eventos.CREAR_CAMPO_OK;
            } else {
                return Eventos.CREAR_CAMPO_KO;
            }
        } else {
            return Eventos.CREAR_CAMPO_KO;
        }
    }

    @Override
    public TCampo read(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        DAOCampo dao = FactoriaIntegracion.getInstance().hacerDAOCampo();
        return dao.read(id);
    }

    @Override
    public Collection<TCampo> readAll() {
        DAOCampo dao = FactoriaIntegracion.getInstance().hacerDAOCampo();
        return dao.readAll();
    }

    @Override
    public int update(TCampo tCampo) {
        if (tCampo == null || tCampo.getID() == null) {
            return Eventos.ACTUALIZAR_CAMPO_KO;
        }

        DAOCampo dao = FactoriaIntegracion.getInstance().hacerDAOCampo();
        TCampo existente = dao.read(tCampo.getID());
        
        if (existente != null) {
            int resultado = dao.update(tCampo);
            if (resultado >= 0) {
                return Eventos.ACTUALIZAR_CAMPO_OK;
            } else {
                return Eventos.ACTUALIZAR_CAMPO_KO;
            }
        } else {
            return Eventos.ACTUALIZAR_CAMPO_KO;
        }
    }

    @Override
    public int delete(String id) {
        if (id == null || id.isEmpty()) {
            return Eventos.ELIMINAR_CAMPO_KO;
        }

        DAOCampo dao = FactoriaIntegracion.getInstance().hacerDAOCampo();
        TCampo existente = dao.read(id);
        
        if (existente != null) {
            int resultado = dao.delete(id);
            if (resultado >= 0) {
                return Eventos.ELIMINAR_CAMPO_OK;
            } else {
                return Eventos.ELIMINAR_CAMPO_KO;
            }
        } else {
            return Eventos.ELIMINAR_CAMPO_KO;
        }
    }

    // Método de mantenimiento detectado en tus diagramas
    public Collection<TCampo> readCamposMantenimiento() {
        DAOCampo dao = FactoriaIntegracion.getInstance().hacerDAOCampo();
        return dao.readCamposMantenimiento();
    }
}