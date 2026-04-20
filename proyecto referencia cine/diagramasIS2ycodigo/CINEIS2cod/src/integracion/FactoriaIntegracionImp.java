package integracion;

import integracion.empleado.DAOEmpleado;
import integracion.empleado.DAOEmpleadoImp;
import integracion.pelicula.DAOPelicula;
import integracion.pelicula.DAOPeliculaImp;
import integracion.proyeccion.DAOProyeccion;
import integracion.proyeccion.DAOProyeccionImp;
import integracion.sala.DAOSala;
import integracion.sala.DAOSalaImp;
import integracion.venta.DAOLineasVenta;
import integracion.venta.DAOLineasVentaImp;
import integracion.venta.DAOVenta;
import integracion.venta.DAOVentaImp;

public class FactoriaIntegracionImp extends FactoriaIntegracion {

	public DAOPelicula hacerDAOPelicula() {
		return new DAOPeliculaImp();
	}

	public DAOSala hacerDAOSala() {
		return new DAOSalaImp();
	}
	
	public DAOEmpleado hacerDAOEmpleado() {
		return new DAOEmpleadoImp();
	}
	
	@Override
	public DAOProyeccion hacerDAOProyeccion() {
		return new DAOProyeccionImp();
	}
	
	@Override
	public DAOVenta hacerDAOVenta() {
		return new DAOVentaImp();
	}
	
	@Override
	public DAOLineasVenta hacerDAOLineasVenta() {
		return new DAOLineasVentaImp();
	}
	
}
