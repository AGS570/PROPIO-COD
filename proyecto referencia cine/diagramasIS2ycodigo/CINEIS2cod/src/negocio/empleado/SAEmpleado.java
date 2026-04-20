package negocio.empleado;

public interface SAEmpleado {
	public int create(TEmpleado TEmpleado);
	public int update(TEmpleado TEmpleado);
	public boolean delete(int id);
	public TEmpleado read(int id);
	public TEmpleado[] readAll();
}