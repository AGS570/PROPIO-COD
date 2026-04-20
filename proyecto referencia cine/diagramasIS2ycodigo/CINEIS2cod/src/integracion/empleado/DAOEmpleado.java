package integracion.empleado;

import negocio.empleado.TEmpleado;

public interface DAOEmpleado {
	public int create(TEmpleado TEmpleado);
	public int update(TEmpleado TEmpleado);
	public boolean delete(int id);
	public TEmpleado read(int id);
	public TEmpleado[] readAll();
}