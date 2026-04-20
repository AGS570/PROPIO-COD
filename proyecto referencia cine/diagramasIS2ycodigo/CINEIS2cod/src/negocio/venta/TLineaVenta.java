package negocio.venta;

public class TLineaVenta {
	
	private int cantidadEntradas;
	private int idProyeccion;
	private int idVenta;
	
	public TLineaVenta(){
		cantidadEntradas = idProyeccion = idVenta = -1;
	}

	public int getCantidadEntradas() {
		return cantidadEntradas;
	}

	public void setCantidadEntradas(int c) {
		cantidadEntradas = c;
	}

	public int getIdProyeccion() {
		return idProyeccion;
	}

	public void setIdProyeccion(int id) {
		idProyeccion = id;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int id) {
		idVenta = id;
	}
	
}