package Negocio;

import java.util.Collection;

public interface SA_Mantenimiento {
    public abstract int create(TMantenimiento tm);
    public abstract TMantenimiento read(int id);
    public abstract Collection<TMantenimiento> readAll();
    public abstract int update(TMantenimiento tm);
    public abstract int delete(int id);
}