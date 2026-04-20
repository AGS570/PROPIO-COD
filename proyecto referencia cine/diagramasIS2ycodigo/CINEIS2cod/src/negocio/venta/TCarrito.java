package negocio.venta;

import java.util.ArrayList;
import java.util.Collection;

public abstract class TCarrito {

	private static int cantidad;
	private static Collection<TLineaVenta> lineasVenta;
	
	public static Collection<TLineaVenta> getLineasVenta() {
		if(lineasVenta == null){
			lineasVenta = new ArrayList<TLineaVenta>();
			cantidad = 0;
		}
		return lineasVenta;
	}

	public static int getCantidad() {
		return cantidad;
	}

	public static void aniadirLineaVenta(TLineaVenta linea) {
		lineasVenta.add(linea);
		cantidad++;
	}

	public static void eliminarLineaVenta() {
		if (!lineasVenta.isEmpty()) {
			TLineaVenta ultimo = null;
			for (TLineaVenta l : lineasVenta)
				ultimo = l;
			lineasVenta.remove(ultimo);
		}
		if(cantidad > 0){
			cantidad--;
		}
	}

	public static void nuevo_carrito() {
		lineasVenta = new ArrayList<TLineaVenta>();
		cantidad = 0;
	}
	
}