package presentacion.controlador;

import negocio.FactoriaNegocio;
import negocio.empleado.TEmpleado;
import negocio.pelicula.TPelicula;
import negocio.proyeccion.TProyeccion;
import negocio.sala.TSala;
import negocio.sala.TSalaNormal;
import negocio.venta.TVenta;
import presentacion.FactoriaPresentacion;
import presentacion.empleado.EventosEmpleado;
import presentacion.pelicula.EventosPelicula;
import presentacion.proyeccion.EventosProyeccion;
import presentacion.sala.EventosSala;
import presentacion.venta.EventosVenta;

public class ControladorImp extends Controlador {

	public void accion(int evento, Object o) {

		FactoriaPresentacion factPres = FactoriaPresentacion.getInstance();
		FactoriaNegocio factNeg = FactoriaNegocio.getInstance();

		Object result;
		switch (evento) {
		// Seccion Pelicula
		case EventosPelicula.CREA_PELICULA:
			result = factNeg.hacerSAPelicula().create((TPelicula) o);
			if ((int) result != -1)
				factPres.hacerGUIRespuestaPelicula(0).actualizar(EventosPelicula.CREA_PELICULA_OK, result);
			else
				factPres.hacerGUIRespuestaPelicula(0).actualizar(EventosPelicula.CREA_PELICULA_KO, null);
			break;
		case EventosPelicula.ACTUALIZA_PELICULA:
			result = factNeg.hacerSAPelicula().update((TPelicula) o);
			if ((int) result != -1)
				factPres.hacerGUIRespuestaPelicula(1).actualizar(EventosPelicula.ACTUALIZA_PELICULA_OK, result);
			else
				factPres.hacerGUIRespuestaPelicula(1).actualizar(EventosPelicula.ACTUALIZA_PELICULA_KO, null);
			break;
		case EventosPelicula.QUITA_PELICULA:
			if (factNeg.hacerSAPelicula().delete((int) o))
				factPres.hacerGUIRespuestaPelicula(2).actualizar(EventosPelicula.QUITA_PELICULA_OK, null);
			else
				factPres.hacerGUIRespuestaPelicula(2).actualizar(EventosPelicula.QUITA_PELICULA_KO, null);
			break;
		case EventosPelicula.MUESTRA_PELICULA:
			result = factNeg.hacerSAPelicula().read((int) o);
			if (result != null)
				factPres.hacerGUIRespuestaPelicula(3).actualizar(EventosPelicula.MUESTRA_PELICULA_OK, result);
			else
				factPres.hacerGUIRespuestaPelicula(3).actualizar(EventosPelicula.MUESTRA_PELICULA_KO, null);
			break;
		case EventosPelicula.MUESTRA_PELICULAS:
			result = factNeg.hacerSAPelicula().readAll();
			if (result != null)
				factPres.hacerGUIRespuestaPelicula(4).actualizar(EventosPelicula.MUESTRA_PELICULAS_OK, result);
			else
				factPres.hacerGUIRespuestaPelicula(4).actualizar(EventosPelicula.MUESTRA_PELICULAS_KO, null);
			break;

		// Seccion Sala
		case EventosSala.CREA_SALA:
			result = factNeg.hacerSASala().create((TSala) o);
			if ((int) result != -1) {
				if (o instanceof TSalaNormal)
					factPres.hacerGUIRespuestaSala(0).actualizar(EventosSala.CREA_SALA_OK, result);
				else
					factPres.hacerGUIRespuestaSala(1).actualizar(EventosSala.CREA_SALA_OK, result);
			} else {
				if (o instanceof TSalaNormal)
					factPres.hacerGUIRespuestaSala(0).actualizar(EventosSala.CREA_SALA_KO, null);
				else
					factPres.hacerGUIRespuestaSala(1).actualizar(EventosSala.CREA_SALA_KO, null);
			}
			break;
		case EventosSala.ACTUALIZA_SALA:
			result = factNeg.hacerSASala().update((TSala) o);
			if ((int) result != -1) {
				if (o instanceof TSalaNormal)
					factPres.hacerGUIRespuestaSala(2).actualizar(EventosSala.ACTUALIZA_SALA_OK, result);
				else
					factPres.hacerGUIRespuestaSala(3).actualizar(EventosSala.ACTUALIZA_SALA_OK, result);
			} else {
				if (o instanceof TSalaNormal)
					factPres.hacerGUIRespuestaSala(2).actualizar(EventosSala.ACTUALIZA_SALA_KO, null);
				else
					factPres.hacerGUIRespuestaSala(3).actualizar(EventosSala.ACTUALIZA_SALA_KO, null);
			}
			break;
		case EventosSala.QUITA_SALA:
			if (factNeg.hacerSASala().delete((int) o))
				factPres.hacerGUIRespuestaSala(4).actualizar(EventosSala.QUITA_SALA_OK, null);
			else
				factPres.hacerGUIRespuestaSala(4).actualizar(EventosSala.QUITA_SALA_KO, null);
			break;
		case EventosSala.MUESTRA_SALA:
			result = factNeg.hacerSASala().read((int) o);
			if (result != null)
				factPres.hacerGUIRespuestaSala(5).actualizar(EventosSala.MUESTRA_SALA_OK, result);
			else
				factPres.hacerGUIRespuestaSala(5).actualizar(EventosSala.MUESTRA_SALA_KO, null);
			break;
		case EventosSala.MUESTRA_SALAS:
			result = factNeg.hacerSASala().readAll();
			if (result != null)
				factPres.hacerGUIRespuestaSala(6).actualizar(EventosSala.MUESTRA_SALAS_OK, result);
			else
				factPres.hacerGUIRespuestaSala(6).actualizar(EventosSala.MUESTRA_SALAS_KO, null);
			break;

		// Seccion Empleado
		case EventosEmpleado.ACTUALIZA_EMPLEADO:
			result = factNeg.hacerSAEmpleado().update((TEmpleado) o);
			if ((int) result != -1)
				factPres.hacerGUIRespuestaEmpleado(1).actualizar(EventosEmpleado.ACTUALIZA_EMPLEADO_OK, result);
			else
				factPres.hacerGUIRespuestaEmpleado(1).actualizar(EventosEmpleado.ACTUALIZA_EMPLEADO_KO, null);
			break;
		case EventosEmpleado.CREA_EMPLEADO:
			result = factNeg.hacerSAEmpleado().create((TEmpleado) o);
			if ((int) result != -1)
				factPres.hacerGUIRespuestaEmpleado(0).actualizar(EventosEmpleado.CREA_EMPLEADO_OK, result);
			else
				factPres.hacerGUIRespuestaEmpleado(0).actualizar(EventosEmpleado.CREA_EMPLEADO_KO, null);
			break;
		case EventosEmpleado.MUESTRA_EMPLEADO:
			result = factNeg.hacerSAEmpleado().read((int) o);
			if (result != null)
				factPres.hacerGUIRespuestaEmpleado(3).actualizar(EventosEmpleado.MUESTRA_EMPLEADO_OK, result);
			else
				factPres.hacerGUIRespuestaEmpleado(3).actualizar(EventosEmpleado.MUESTRA_EMPLEADO_KO, null);
			break;

		case EventosEmpleado.MUESTRA_EMPLEADOS:
			result = factNeg.hacerSAEmpleado().readAll();
			if (result != null)
				factPres.hacerGUIRespuestaEmpleado(4).actualizar(EventosEmpleado.MUESTRA_EMPLEADOS_OK, result);
			else
				factPres.hacerGUIRespuestaEmpleado(4).actualizar(EventosEmpleado.MUESTRA_EMPLEADOS_KO, null);
			break;
		case EventosEmpleado.QUITA_EMPLEADO:
			if (factNeg.hacerSAEmpleado().delete((int) o))
				factPres.hacerGUIRespuestaEmpleado(2).actualizar(EventosEmpleado.QUITA_EMPLEADO_OK, null);
			else
				factPres.hacerGUIRespuestaEmpleado(2).actualizar(EventosEmpleado.QUITA_EMPLEADO_KO, null);
			break;

		// Seccion proyeccion
		case EventosProyeccion.CREA_PROYECCION:
			result = factNeg.hacerSAProyeccion().create((TProyeccion) o);
			if ((int) result != -1)
				factPres.hacerGUIRespuestaProyeccion(0).actualizar(EventosProyeccion.CREA_OK, result);
			else
				factPres.hacerGUIRespuestaProyeccion(0).actualizar(EventosProyeccion.CREA_KO, null);
			break;
		case EventosProyeccion.ACTUALIZA_PROYECCION:
			result = factNeg.hacerSAProyeccion().update((TProyeccion) o);
			if ((int) result != -1)
				factPres.hacerGUIRespuestaProyeccion(1).actualizar(EventosProyeccion.ACTUALIZA_OK, result);
			else
				factPres.hacerGUIRespuestaProyeccion(1).actualizar(EventosProyeccion.ACTUALIZA_KO, null);
			break;
		case EventosProyeccion.QUITA_PROYECCION:
			if (factNeg.hacerSAProyeccion().delete((int) o))
				factPres.hacerGUIRespuestaProyeccion(2).actualizar(EventosProyeccion.QUITA_OK, null);
			else
				factPres.hacerGUIRespuestaProyeccion(2).actualizar(EventosProyeccion.QUITA_KO, null);
			break;
		case EventosProyeccion.MUESTRA_PROYECCION:
			result = factNeg.hacerSAProyeccion().read((int) o);
			if (result != null)
				factPres.hacerGUIRespuestaProyeccion(3).actualizar(EventosProyeccion.MOSTRAR_OK, result);
			else
				factPres.hacerGUIRespuestaProyeccion(3).actualizar(EventosProyeccion.MOSTRAR_KO, null);
			break;
		case EventosProyeccion.MUESTRA_PROYECCIONES:
			result = factNeg.hacerSAProyeccion().readAll();
			if (result != null)
				factPres.hacerGUIRespuestaProyeccion(4).actualizar(EventosProyeccion.MOSTRAR_TODOS_OK, result);
			else
				factPres.hacerGUIRespuestaProyeccion(4).actualizar(EventosProyeccion.MOSTRAR_TODOS_KO, null);
			break;

		// Seccion Venta
		case EventosVenta.CIERRA_VENTA:
			result = factNeg.hacerSAVenta().create((TVenta) o);
			if ((int) result != -1)
				factPres.hacerGUIRespuestaVenta(0).actualizar(EventosVenta.CIERRA_VENTA_OK, result);
			else
				factPres.hacerGUIRespuestaVenta(0).actualizar(EventosVenta.CIERRA_VENTA_KO, null);
			break;
		case EventosVenta.DEVUELVE_VENTA:
			if (factNeg.hacerSAVenta().devolver((int) o))
				factPres.hacerGUIRespuestaVenta(1).actualizar(EventosVenta.DEVUELVE_VENTA_OK, null);
			else
				factPres.hacerGUIRespuestaVenta(1).actualizar(EventosVenta.DEVUELVE_VENTA_KO, null);
			break;
		case EventosVenta.MUESTRA_VENTA:
			result = factNeg.hacerSAVenta().read((int) o);
			if (result != null)
				factPres.hacerGUIRespuestaVenta(2).actualizar(EventosVenta.MUESTRA_VENTA_OK, result);
			else
				factPres.hacerGUIRespuestaVenta(2).actualizar(EventosVenta.MUESTRA_VENTA_KO, null);
			break;
		case EventosVenta.MUESTRA_VENTAS:
			result = factNeg.hacerSAVenta().readAll();
			if (result != null)
				factPres.hacerGUIRespuestaVenta(3).actualizar(EventosVenta.MUESTRA_VENTAS_OK, result);
			else
				factPres.hacerGUIRespuestaVenta(3).actualizar(EventosVenta.MUESTRA_VENTAS_KO, null);
			break;
		case EventosVenta.MUESTRA_LINEAS_VENTA:
			result = factNeg.hacerSAVenta().readLineasVenta((int) o);
			if (result != null)
				factPres.hacerGUIRespuestaVenta(4).actualizar(EventosVenta.MUESTRA_LINEAS_VENTA_OK, result);
			else
				factPres.hacerGUIRespuestaVenta(4).actualizar(EventosVenta.MUESTRA_LINEAS_VENTA_KO, null);
			break;
		}
	}

}
