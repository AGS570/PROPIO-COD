package Integracion.Campos;

import java.util.Collection;
import Negocio.Campos.TCampo;

public interface DAOCampo {
    public int create(TCampo tCampo);
    public TCampo read(String id);
    public Collection<TCampo> readAll();
    public int update(TCampo tCampo);
    public int delete(String id);
    public Collection<TCampo> readCamposMantenimiento();
}