package negocio.venta;

public class TVenta {
	
	private int id_Vendedor;
	private int id;
	private String fecha_Compra;
	private double precio;
	
	public TVenta(){
		id = id_Vendedor = -1;
		fecha_Compra = null;
		precio = -1;
	}

	public int getID_Vendedor() {
		return id_Vendedor;
	}

	public void setID_Vendedor(int id) {
		id_Vendedor = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha_Compra() {
		return fecha_Compra;
	}

	public void setFecha_Compra(String fecha) {
		fecha_Compra = fecha;
	}

	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
