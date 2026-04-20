package negocio;

import negocio.empleado.SAEmpleado;
import negocio.empleado.SAEmpleadoImp;
import negocio.pelicula.SAPelicula;
import negocio.pelicula.SAPeliculaImp;
import negocio.proyeccion.SAProyeccion;
import negocio.proyeccion.SAProyeccionImp;
import negocio.sala.SASala;
import negocio.sala.SASalaImp;
import negocio.venta.SAVenta;
import negocio.venta.SAVentaImp;

public class FactoriaNegocioImp extends FactoriaNegocio {

	public SAPelicula hacerSAPelicula() {
		return new SAPeliculaImp();
	}

	public SASala hacerSASala() {
		return new SASalaImp();
	}
	
	@Override
	public SAProyeccion hacerSAProyeccion() {
		return new SAProyeccionImp();
	}
	
	public SAEmpleado hacerSAEmpleado() {
		return new SAEmpleadoImp();
	}
	
	public SAVenta hacerSAVenta() {
		return new SAVentaImp();
	}
	
}
