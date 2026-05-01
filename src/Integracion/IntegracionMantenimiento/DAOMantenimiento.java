package Integracion.IntegracionMantenimiento;
import Negocio.NegocioMantenimiento.*;
import java.util.List;

public interface DAOMantenimiento {
    public int create(TMantenimiento mantenimiento);
    public TMantenimiento read(int id);
    public List<TMantenimiento> readAll();
    public boolean update(TMantenimiento mantenimiento);
    public boolean delete(int id);
}