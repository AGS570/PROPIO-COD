package presentacion;

import presentacion.PresentacionJugador.GUIRespuestaActualizarJugador;
import presentacion.PresentacionJugador.GUIRespuestaCrearJugador;
import presentacion.PresentacionJugador.GUIRespuestaEliminarJugador;
import presentacion.PresentacionJugador.GUIRespuestaMostrarJugador;
import presentacion.PresentacionJugador.GUIRespuestaMostrarJugadores;
import presentacion.PresentacionJugador.GUIRespuestaMostrarJugadoresDelEquipo;

public class FactoriaPresentacionImp extends FactoriaPresentacion {

	@Override
	public IGUI hacerGUIRespuestaJugador(int evento) {
		switch (evento) {
		case Eventos.CREAR_JUGADOR:
			return new GUIRespuestaCrearJugador();
		case Eventos.ACTUALIZAR_JUGADOR:
			return new GUIRespuestaActualizarJugador();
		case Eventos.ELIMINAR_JUGADOR:
			return new GUIRespuestaEliminarJugador();
		case Eventos.MOSTRAR_JUGADOR:
			return new GUIRespuestaMostrarJugador();
		case Eventos.MOSTRAR_JUGADORES:
			return new GUIRespuestaMostrarJugadores();
		case Eventos.MOSTRAR_JUGADORES_DEL_EQUIPO:
			return new GUIRespuestaMostrarJugadoresDelEquipo();
				
		}
		return null;
	}

	 @Override
	    public IGUI hacerGUIRespuestaEquipo(int evento) {
	        switch (evento) {
	        case Eventos.CREAR_EQUIPO:
	            return new GUIRespuestaCrearEquipo();
	        case Eventos.ACTUALIZAR_EQUIPO:
	            return new GUIRespuestaActualizarEquipo();
	        case Eventos.ELIMINAR_EQUIPO:
	            return new GUIRespuestaEliminarEquipo();
	        case Eventos.MOSTRAR_EQUIPO:
	            return new GUIRespuestaMostrarEquipo();
	        case Eventos.MOSTRAR_EQUIPOS:
	            return new GUIRespuestaMostrarEquipos();
	        case Eventos.MOSTRAR_EQUIPOS_DEL_JUGADOR:
	            return new GUIRespuestaMostrarEquiposDelJugador();
	        case Eventos.VINCULAR_JUGADOR:
	            return new GUIRespuestaVincularJugador();
	        case Eventos.DESVINCULAR_JUGADOR:
	            return new GUIRespuestaDesvincularJugador();
	        }
	        return null;
	    }


	 @Override
	    public IGUI hacerGUIRespuestaPartido(int evento) {
	        switch (evento) {
	        case Eventos.CREAR_PARTIDO:
	            return new GUIRespuestaCrearPartido();
	        case Eventos.ACTUALIZAR_PARTIDO:
	            return new GUIRespuestaActualizarPartido();
	        case Eventos.ELIMINAR_PARTIDO:
	            return new GUIRespuestaEliminarPartido();
	        case Eventos.MOSTRAR_PARTIDO:
	            return new GUIRespuestaMostrarPartido();
	        case Eventos.MOSTRAR_PARTIDOS:
	            return new GUIRespuestaMostrarPartidos();
	        case Eventos.ADD_GOL_VISITANTE:
	            return new GUIRespuestaAddGolVisitante();
	        case Eventos.ADD_GOL_LOCAL:
	            return new GUIRespuestaAddGolLocal();
	        }
	        return null;
	    }

	    @Override
	    public IGUI hacerGUIRespuestaCampo(int evento) {
	        switch (evento) {
	        case Eventos.CREAR_CAMPO:
	            return new GUIRespuestaCrearCampo();
	        case Eventos.ACTUALIZAR_CAMPO:
	            return new GUIRespuestaActualizarCampo();
	        case Eventos.ELIMINAR_CAMPO:
	            return new GUIRespuestaEliminarCampo();
	        case Eventos.MOSTRAR_CAMPO:
	            return new GUIRespuestaMostrarCampo();
	        case Eventos.MOSTRAR_CAMPOS:
	            return new GUIRespuestaMostrarCampos();
	        case Eventos.MOSTRAR_CAMPOS_DEL_MANTENIMIENTO:
	            return new GUIRespuestaMostrarCamposDelMantenimiento();
	        }
	        return null;
	    }

	    @Override
	    public IGUI hacerGUIRespuestaEntrenador(int evento) {
	        switch (evento) {
	        case Eventos.CREAR_ENTRENADOR:
	            return new GUIRespuestaCrearEntrenador();
	        case Eventos.ACTUALIZAR_ENTRENADOR:
	            return new GUIRespuestaActualizarEntrenador();
	        case Eventos.ELIMINAR_ENTRENADOR:
	            return new GUIRespuestaEliminarEntrenador();
	        case Eventos.MOSTRAR_ENTRENADOR:
	            return new GUIRespuestaMostrarEntrenador();
	        case Eventos.MOSTRAR_ENTRENADORES:
	            return new GUIRespuestaMostrarEntrenadores();
	        case Eventos.VINCULAR_ENTRENADOR:
	            return new GUIRespuestaVincularEntrenador();
	        case Eventos.DESVINCULAR_ENTRENADOR:
	            return new GUIRespuestaDesvincularEntrenador();
	        case Eventos.AÑADIR_EXPERIENCIA:
	            return new GUIRespuestaAñadirExperiencia();
	        }
	        return null;
	    }

	    @Override
	    public IGUI hacerGUIRespuestaMantenimiento(int evento) {
	        switch (evento) {
	        case Eventos.CREAR_MANTENIMIENTO:
	            return new GUIRespuestaCrearMantenimiento();
	        case Eventos.ACTUALIZAR_MANTENIMIENTO:
	            return new GUIRespuestaActualizarMantenimiento();
	        case Eventos.ELIMINAR_MANTENIMIENTO:
	            return new GUIRespuestaEliminarMantenimiento();
	        case Eventos.MOSTRAR_MANTENIMIENTO:
	            return new GUIRespuestaMostrarMantenimiento();
	        case Eventos.MOSTRAR_MANTENIMIENTOS:
	            return new GUIRespuestaMostrarMantenimientos();
	        case Eventos.VINCULAR_MANTENIMIENTO:
	            return new GUIRespuestaVincularMantenimiento();
	        case Eventos.DESVINCULAR_MANTENIMIENTO:
	            return new GUIRespuestaDesvincularMantenimiento();
	        case Eventos.MOSTRAR_MANTENIMIENTOS_DEL_CAMPO:
	            return new GUIRespuestaMostrarMantenimientosDelCampo();
	        }
	        return null;
	    }

}
