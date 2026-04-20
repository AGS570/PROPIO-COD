package integracion.venta;

import negocio.venta.TVenta;

public interface DAOVenta {
	public int create(TVenta tVenta);
	public boolean delete(int id);
	public TVenta read(int id);
	public TVenta[] readAll();
}
