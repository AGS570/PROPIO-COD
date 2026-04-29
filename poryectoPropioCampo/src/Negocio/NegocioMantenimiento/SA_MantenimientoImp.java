package Negocio;

import java.util.Collection;
import Integracion.DAOMantenimiento;
import Integracion.FactoriaIntegracion;

public class SA_MantenimientoImp implements SA_Mantenimiento {

    @Override
    public int create(TMantenimiento tm) {
        int id = -1;
        DAOMantenimiento dm = FactoriaIntegracion.getInstance().hacerDAOMantenimiento();
        if(tm != null) {
            // Suponiendo que haces una comprobación previa (ej. por DNI)
            id = dm.create(tm);
        }
        return id;
    }

    @Override
    public TMantenimiento read(int id) {
        if(id > 0) {
            return FactoriaIntegracion.getInstance().hacerDAOMantenimiento().read(id);
        }
        return null;
    }

    @Override
    public Collection<TMantenimiento> readAll() {
        return FactoriaIntegracion.getInstance().hacerDAOMantenimiento().readAll();
    }

    @Override
    public int update(TMantenimiento tm) {
        if(tm != null) {
            boolean exito = FactoriaIntegracion.getInstance().hacerDAOMantenimiento().update(tm);
            return exito ? 1 : -1;
        }
        return -1;
    }

    @Override
    public int delete(int id) {
        int res = -1;
        if (id > 0) {
            boolean exito = FactoriaIntegracion.getInstance().hacerDAOMantenimiento().delete(id);
            res = exito ? 1 : -1;
        }
        return res;
    }
}