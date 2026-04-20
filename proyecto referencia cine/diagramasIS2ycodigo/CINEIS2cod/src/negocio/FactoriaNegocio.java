package negocio;

import negocio.empleado.SAEmpleado;
import negocio.pelicula.SAPelicula;
import negocio.proyeccion.SAProyeccion;
import negocio.sala.SASala;
import negocio.venta.SAVenta;

public abstract class FactoriaNegocio {
	
	private static FactoriaNegocio instancia;
	
	public static FactoriaNegocio getInstance(){
		if(instancia == null)
			instancia = new FactoriaNegocioImp();
		return instancia;
	}
	
	public abstract SAPelicula hacerSAPelicula();
	public abstract SASala hacerSASala();
	public abstract SAEmpleado hacerSAEmpleado();
	public abstract SAProyeccion hacerSAProyeccion();
	public abstract SAVenta hacerSAVenta();
}
