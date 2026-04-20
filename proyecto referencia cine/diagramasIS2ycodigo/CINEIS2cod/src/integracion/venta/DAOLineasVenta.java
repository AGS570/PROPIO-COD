package integracion.venta;

import negocio.venta.TLineaVenta;

public interface DAOLineasVenta {
	public int create(TLineaVenta tl);
	public boolean deleteAllById(int id);
	public TLineaVenta[] readAllByID(int id);
}
