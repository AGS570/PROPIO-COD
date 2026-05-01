package Negocio.Campo;

import java.util.Collection;

public interface SA_Campo {
    public int create(TCampo tCampo);
    public TCampo read(String id);
    public Collection<TCampo> readAll();
    public int update(TCampo tCampo);
    public int delete(String id);
}