package Integracion;

import java.util.Collection;

import Negocio.TCampo;

import java.util.ArrayList;

public class DAOCampoImp implements DAOCampo {
    @Override
    public int create(TCampo t) {
        // En tu secuencia, primero se lee. 
        // Aquí iría el INSERT con JDBC:
        // Connection con = FactoriaConexion.getInstancia().getConexion();
        return 1; 
    }

    @Override
    public TCampo read(String id) {
        // Aquí irá el SELECT * FROM Campos WHERE ID = id
        // Dependiendo del tipo en la BD, devolverás un TCampoExterior o Interior
        return null; 
    }

    @Override
    public Collection<TCampo> readAll() {
        // SELECT * FROM Campos
        return new ArrayList<TCampo>();
    }

    @Override
    public int update(TCampo tCampo) {
        // UPDATE Campos SET ... WHERE ID = tCampo.getID()
        return 0;
    }

    @Override
    public int delete(String id) {
        // DELETE FROM Campos WHERE ID = id
        return 0;
    }

    @Override
    public Collection<TCampo> readCamposMantenimiento() {
        // Lógica para filtrar campos que necesiten revisión
        return new ArrayList<TCampo>();
    }
}