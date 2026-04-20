package integracion;

import integracion.empleado.DAOEmpleado;
import integracion.pelicula.DAOPelicula;
import integracion.proyeccion.DAOProyeccion;
import integracion.sala.DAOSala;
import integracion.venta.DAOLineasVenta;
import integracion.venta.DAOVenta;

public abstract class FactoriaIntegracion {
	
	private static FactoriaIntegracion instancia;
	
	public static FactoriaIntegracion getInstance(){
		if(instancia == null)
			instancia = new FactoriaIntegracionImp();
		return instancia;
	}
	
	public abstract DAOPelicula hacerDAOPelicula();
	public abstract DAOSala hacerDAOSala();
	public abstract DAOEmpleado hacerDAOEmpleado();
	public abstract DAOProyeccion hacerDAOProyeccion();
	public abstract DAOVenta hacerDAOVenta();
	public abstract DAOLineasVenta hacerDAOLineasVenta();
}
