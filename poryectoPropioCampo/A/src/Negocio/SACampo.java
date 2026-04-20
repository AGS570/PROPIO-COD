package Negocio;

import java.util.Collection;

public interface SACampo {
    public int create(TCampo tCampo);
    public TCampo read(String id);
    public Collection<TCampo> readAll();
    public int update(TCampo tCampo);
    public int delete(String id);
}