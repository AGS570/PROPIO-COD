package Integracion.Factoria;

import Integracion.campo.DAOCampo;

public abstract class FactoriaDAO {
    private static FactoriaDAO instance;

    public static FactoriaDAO getInstance() {
        if (instance == null) {
            instance = new FactoriaDAOImp();
        }
        return instance;
    }

    public abstract DAOCampo getDAOCampo();
}
