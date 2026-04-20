package negocio.venta;

public interface SAVenta {
	public int create(TVenta venta);
	public boolean devolver(int id);
	public TVenta read(int id);
	public TVenta[] readAll();
	public TLineaVenta[] readLineasVenta(int id);
}