package presentacion;

import presentacion.empleado.GUIRespuestaActualizaEmpleado;
import presentacion.empleado.GUIRespuestaCreaEmpleado;
import presentacion.empleado.GUIRespuestaMostrarEmpleado;
import presentacion.empleado.GUIRespuestaMostrarEmpleados;
import presentacion.empleado.GUIRespuestaQuitaEmpleado;
import presentacion.pelicula.GUIRespuestaActualizaPelicula;
import presentacion.pelicula.GUIRespuestaCreaPelicula;
import presentacion.pelicula.GUIRespuestaMostrarPelicula;
import presentacion.pelicula.GUIRespuestaMostrarPeliculas;
import presentacion.pelicula.GUIRespuestaQuitaPelicula;
import presentacion.proyeccion.GUIRespuestaActualizaProyeccion;
import presentacion.proyeccion.GUIRespuestaCreaProyeccion;
import presentacion.proyeccion.GUIRespuestaMostrarProyeccion;
import presentacion.proyeccion.GUIRespuestaMostrarProyecciones;
import presentacion.proyeccion.GUIRespuestaQuitaProyeccion;
import presentacion.sala.GUIRespuestaActualizarSalaNormal;
import presentacion.sala.GUIRespuestaActualizarSalaVip;
import presentacion.sala.GUIRespuestaCreaSalaNormal;
import presentacion.sala.GUIRespuestaCreaSalaVip;
import presentacion.sala.GUIRespuestaMostrarSala;
import presentacion.sala.GUIRespuestaMostrarSalas;
import presentacion.sala.GUIRespuestaQuitaSala;
import presentacion.venta.GUIRespuestaCerrarVenta;
import presentacion.venta.GUIRespuestaDevolverVenta;
import presentacion.venta.GUIRespuestaMostrarVenta;
import presentacion.venta.GUIRespuestaMostrarVentas;
import presentacion.venta.GUIRespuestaMuestraLineasVenta;

public class FactoriaPresentacionImp extends FactoriaPresentacion {

	public IGUI hacerGUIRespuestaPelicula(int codigo) {
		switch (codigo) {
		case 0:
			return new GUIRespuestaCreaPelicula();
		case 1:
			return new GUIRespuestaActualizaPelicula();
		case 2:
			return new GUIRespuestaQuitaPelicula();
		case 3:
			return new GUIRespuestaMostrarPelicula();
		case 4:
			return new GUIRespuestaMostrarPeliculas();
		}
		return null;
	}

	public IGUI hacerGUIRespuestaSala(int codigo) {
		switch (codigo) {
		case 0:
			return new GUIRespuestaCreaSalaNormal();
		case 1:
			return new GUIRespuestaCreaSalaVip();
		case 2:
			return new GUIRespuestaActualizarSalaNormal();
		case 3:
			return new GUIRespuestaActualizarSalaVip();
		case 4:
			return new GUIRespuestaQuitaSala();
		case 5:
			return new GUIRespuestaMostrarSala();
		case 6:
			return new GUIRespuestaMostrarSalas();
		}
		return null;
	}

	public IGUI hacerGUIRespuestaProyeccion(int codigo) {
		switch(codigo){
		case 0:
			return new GUIRespuestaCreaProyeccion();
		case 1:
			return new GUIRespuestaActualizaProyeccion();
		case 2:
			return new GUIRespuestaQuitaProyeccion();
		case 3:
			return new GUIRespuestaMostrarProyeccion();
		case 4:
			return new GUIRespuestaMostrarProyecciones();
		}
		return null;
	}

	@Override
	public IGUI hacerGUIRespuestaEmpleado(int codigo) {
		switch (codigo) {
		case 0:
			return new GUIRespuestaCreaEmpleado();
		case 1:
			return new GUIRespuestaActualizaEmpleado();
		case 2:
			return new GUIRespuestaQuitaEmpleado();
		case 3:
			return new GUIRespuestaMostrarEmpleado();
		case 4:
			return new GUIRespuestaMostrarEmpleados();
		}
		return null;
	}
	
	@Override
	public IGUI hacerGUIRespuestaVenta(int codigo) {
		switch (codigo) {
		case 0:
			return new GUIRespuestaCerrarVenta();
		case 1:
			return new GUIRespuestaDevolverVenta();
		case 2:
			return new GUIRespuestaMostrarVenta();
		case 3:
			return new GUIRespuestaMostrarVentas();
		case 4:
			return new GUIRespuestaMuestraLineasVenta();
		}
		return null;
	}

}
