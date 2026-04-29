package presentacion.PresentacionControlador;

import Negocio.FactoriaNegocio;
import Negocio.NegocioJugador.TJugador;
import presentacion.Eventos;
import presentacion.FactoriaPresentacion;

public class ControladorImp extends Controlador {
	
	
	@Override
	public void accion(int evento, Object o) {
		FactoriaPresentacion factPres = FactoriaPresentacion.getInstance();
		FactoriaNegocio factNeg = FactoriaNegocio.getInstance();
		Object res;
		
		switch(evento) {
			//Jugador
		case Eventos.CREAR_JUGADOR:
			TJugador tj = (TJugador) o;
			res = factNeg.hacerSAJugador().create(tj);
			if((int) res > 0)
				factPres.hacerGUIRespuestaJugador(evento).actualizar(Eventos.CREAR_JUGADOR_OK, res);
			else
				factPres.hacerGUIRespuestaJugador(evento).actualizar(Eventos.CREAR_JUGADOR_KO, null);
			break;
			
		case Eventos.ACTUALIZAR_JUGADOR:
            res = factNeg.hacerSAJugador().update((TJugador) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaJugador(evento).actualizar(Eventos.ACTUALIZAR_JUGADOR_OK, null);
            else
                factPres.hacerGUIRespuestaJugador(evento).actualizar(Eventos.ACTUALIZAR_JUGADOR_KO, null);
            break;
            
		case Eventos.ELIMINAR_JUGADOR:
            res = factNeg.hacerSAJugador().delete((int) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaJugador(evento).actualizar(Eventos.ELIMINAR_JUGADOR_OK, null);
            else
                factPres.hacerGUIRespuestaJugador(evento).actualizar(Eventos.ELIMINAR_JUGADOR_KO, null);
            break;
            
		case Eventos.MOSTRAR_JUGADOR:
            res = factNeg.hacerSAJugador().read((int) o);
            if(res != null)
                factPres.hacerGUIRespuestaJugador(evento).actualizar(Eventos.MOSTRAR_JUGADOR_OK, res);
            else
                factPres.hacerGUIRespuestaJugador(evento).actualizar(Eventos.MOSTRAR_JUGADOR_KO, null);
            break;

        case Eventos.MOSTRAR_JUGADORES:
            res = factNeg.hacerSAJugador().readAll();
            if(res != null)
                factPres.hacerGUIRespuestaJugador(evento).actualizar(Eventos.MOSTRAR_JUGADORES_OK, res);
            else
                factPres.hacerGUIRespuestaJugador(evento).actualizar(Eventos.MOSTRAR_JUGADORES_KO, null);
            break;

        case Eventos.MOSTRAR_JUGADORES_DEL_EQUIPO:
            res = factNeg.hacerSAJugador().readJugadoresDelEquipo((int) o);
            if(res != null)
                factPres.hacerGUIRespuestaJugador(evento).actualizar(Eventos.MOSTRAR_JUGADORES_DEL_EQUIPO_OK, res);
            else
                factPres.hacerGUIRespuestaJugador(evento).actualizar(Eventos.MOSTRAR_JUGADORES_DEL_EQUIPO_KO, null);
            break;
            
         // Equipo
        case Eventos.CREAR_EQUIPO:
            res = factNeg.hacerSAEquipo().create((TEquipo) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaEquipo(evento).actualizar(Eventos.CREAR_EQUIPO_OK, res);
            else
                factPres.hacerGUIRespuestaEquipo(evento).actualizar(Eventos.CREAR_EQUIPO_KO, null);
            break;

        case Eventos.ACTUALIZAR_EQUIPO:
            res = factNeg.hacerSAEquipo().update((TEquipo) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaEquipo(evento).actualizar(Eventos.ACTUALIZAR_EQUIPO_OK, null);
            else
                factPres.hacerGUIRespuestaEquipo(evento).actualizar(Eventos.ACTUALIZAR_EQUIPO_KO, null);
            break;

        case Eventos.ELIMINAR_EQUIPO:
            res = factNeg.hacerSAEquipo().delete((int) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaEquipo(evento).actualizar(Eventos.ELIMINAR_EQUIPO_OK, null);
            else
                factPres.hacerGUIRespuestaEquipo(evento).actualizar(Eventos.ELIMINAR_EQUIPO_KO, null);
            break;

        case Eventos.MOSTRAR_EQUIPO:
            res = factNeg.hacerSAEquipo().read((int) o);
            if(res != null)
                factPres.hacerGUIRespuestaEquipo(evento).actualizar(Eventos.MOSTRAR_EQUIPO_OK, res);
            else
                factPres.hacerGUIRespuestaEquipo(evento).actualizar(Eventos.MOSTRAR_EQUIPO_KO, null);
            break;

        case Eventos.MOSTRAR_EQUIPOS:
            res = factNeg.hacerSAEquipo().readAll();
            if(res != null)
                factPres.hacerGUIRespuestaEquipo(evento).actualizar(Eventos.MOSTRAR_EQUIPOS_OK, res);
            else
                factPres.hacerGUIRespuestaEquipo(evento).actualizar(Eventos.MOSTRAR_EQUIPOS_KO, null);
            break;

        case Eventos.MOSTRAR_EQUIPOS_DEL_JUGADOR:
            res = factNeg.hacerSAEquipo().readEquiposDelJugador((int) o);
            if(res != null)
                factPres.hacerGUIRespuestaEquipo(evento).actualizar(Eventos.MOSTRAR_EQUIPOS_DEL_JUGADOR_OK, res);
            else
                factPres.hacerGUIRespuestaEquipo(evento).actualizar(Eventos.MOSTRAR_EQUIPOS_DEL_JUGADOR_KO, null);
            break;

        case Eventos.VINCULAR_JUGADOR:
            res = factNeg.hacerSAEquipo().vincularJugador((int[]) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaEquipo(evento).actualizar(Eventos.VINCULAR_JUGADOR_OK, null);
            else
                factPres.hacerGUIRespuestaEquipo(evento).actualizar(Eventos.VINCULAR_JUGADOR_KO, null);
            break;

        case Eventos.DESVINCULAR_JUGADOR:
            res = factNeg.hacerSAEquipo().desvincularJugador((int[]) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaEquipo(evento).actualizar(Eventos.DESVINCULAR_JUGADOR_OK, null);
            else
                factPres.hacerGUIRespuestaEquipo(evento).actualizar(Eventos.DESVINCULAR_JUGADOR_KO, null);
            break;

         // Campo
        case Eventos.CREAR_CAMPO:
            res = factNeg.hacerSACampo().create((TCampo) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaCampo(evento).actualizar(Eventos.CREAR_CAMPO_OK, res);
            else
                factPres.hacerGUIRespuestaCampo(evento).actualizar(Eventos.CREAR_CAMPO_KO, null);
            break;

        case Eventos.ACTUALIZAR_CAMPO:
            res = factNeg.hacerSACampo().update((TCampo) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaCampo(evento).actualizar(Eventos.ACTUALIZAR_CAMPO_OK, null);
            else
                factPres.hacerGUIRespuestaCampo(evento).actualizar(Eventos.ACTUALIZAR_CAMPO_KO, null);
            break;

        case Eventos.ELIMINAR_CAMPO:
            res = factNeg.hacerSACampo().delete((int) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaCampo(evento).actualizar(Eventos.ELIMINAR_CAMPO_OK, null);
            else
                factPres.hacerGUIRespuestaCampo(evento).actualizar(Eventos.ELIMINAR_CAMPO_KO, null);
            break;

        case Eventos.MOSTRAR_CAMPO:
            res = factNeg.hacerSACampo().read((int) o);
            if(res != null)
                factPres.hacerGUIRespuestaCampo(evento).actualizar(Eventos.MOSTRAR_CAMPO_OK, res);
            else
                factPres.hacerGUIRespuestaCampo(evento).actualizar(Eventos.MOSTRAR_CAMPO_KO, null);
            break;

        case Eventos.MOSTRAR_CAMPOS:
            res = factNeg.hacerSACampo().readAll();
            if(res != null)
                factPres.hacerGUIRespuestaCampo(evento).actualizar(Eventos.MOSTRAR_CAMPOS_OK, res);
            else
                factPres.hacerGUIRespuestaCampo(evento).actualizar(Eventos.MOSTRAR_CAMPOS_KO, null);
            break;

        case Eventos.MOSTRAR_CAMPOS_DEL_MANTENIMIENTO:
            res = factNeg.hacerSACampo().readCamposDelMantenimiento((int) o);
            if(res != null)
                factPres.hacerGUIRespuestaCampo(evento).actualizar(Eventos.MOSTRAR_CAMPOS_DEL_MANTENIMIENTO_OK, res);
            else
                factPres.hacerGUIRespuestaCampo(evento).actualizar(Eventos.MOSTRAR_CAMPOS_DEL_MANTENIMIENTO_KO, null);
            break;

        // Entrenador
        case Eventos.CREAR_ENTRENADOR:
            res = factNeg.hacerSAEntrenador().create((TEntrenador) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaEntrenador(evento).actualizar(Eventos.CREAR_ENTRENADOR_OK, res);
            else
                factPres.hacerGUIRespuestaEntrenador(evento).actualizar(Eventos.CREAR_ENTRENADOR_KO, null);
            break;

        case Eventos.ACTUALIZAR_ENTRENADOR:
            res = factNeg.hacerSAEntrenador().update((TEntrenador) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaEntrenador(evento).actualizar(Eventos.ACTUALIZAR_ENTRENADOR_OK, null);
            else
                factPres.hacerGUIRespuestaEntrenador(evento).actualizar(Eventos.ACTUALIZAR_ENTRENADOR_KO, null);
            break;

        case Eventos.ELIMINAR_ENTRENADOR:
            res = factNeg.hacerSAEntrenador().delete((int) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaEntrenador(evento).actualizar(Eventos.ELIMINAR_ENTRENADOR_OK, null);
            else
                factPres.hacerGUIRespuestaEntrenador(evento).actualizar(Eventos.ELIMINAR_ENTRENADOR_KO, null);
            break;

        case Eventos.MOSTRAR_ENTRENADOR:
            res = factNeg.hacerSAEntrenador().read((int) o);
            if(res != null)
                factPres.hacerGUIRespuestaEntrenador(evento).actualizar(Eventos.MOSTRAR_ENTRENADOR_OK, res);
            else
                factPres.hacerGUIRespuestaEntrenador(evento).actualizar(Eventos.MOSTRAR_ENTRENADOR_KO, null);
            break;

        case Eventos.MOSTRAR_ENTRENADORES:
            res = factNeg.hacerSAEntrenador().readAll();
            if(res != null)
                factPres.hacerGUIRespuestaEntrenador(evento).actualizar(Eventos.MOSTRAR_ENTRENADORES_OK, res);
            else
                factPres.hacerGUIRespuestaEntrenador(evento).actualizar(Eventos.MOSTRAR_ENTRENADORES_KO, null);
            break;

        case Eventos.VINCULAR_ENTRENADOR:
            res = factNeg.hacerSAEntrenador().vincularEntrenador((int[]) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaEntrenador(evento).actualizar(Eventos.VINCULAR_ENTRENADOR_OK, null);
            else
                factPres.hacerGUIRespuestaEntrenador(evento).actualizar(Eventos.VINCULAR_ENTRENADOR_KO, null);
            break;

        case Eventos.DESVINCULAR_ENTRENADOR:
            res = factNeg.hacerSAEntrenador().desvincularEntrenador((int[]) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaEntrenador(evento).actualizar(Eventos.DESVINCULAR_ENTRENADOR_OK, null);
            else
                factPres.hacerGUIRespuestaEntrenador(evento).actualizar(Eventos.DESVINCULAR_ENTRENADOR_KO, null);
            break;

        case Eventos.AÑADIR_EXPERIENCIA:
            res = factNeg.hacerSAEntrenador().añadirExperiencia((int) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaEntrenador(evento).actualizar(Eventos.AÑADIR_EXPERIENCIA_OK, null);
            else
                factPres.hacerGUIRespuestaEntrenador(evento).actualizar(Eventos.AÑADIR_EXPERIENCIA_KO, null);
            break;

        // Mantenimiento
        case Eventos.CREAR_MANTENIMIENTO:
            res = factNeg.hacerSAMantenimiento().create((TMantenimiento) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaMantenimiento(evento).actualizar(Eventos.CREAR_MANTENIMIENTO_OK, res);
            else
                factPres.hacerGUIRespuestaMantenimiento(evento).actualizar(Eventos.CREAR_MANTENIMIENTO_KO, null);
            break;

        case Eventos.ACTUALIZAR_MANTENIMIENTO:
            res = factNeg.hacerSAMantenimiento().update((TMantenimiento) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaMantenimiento(evento).actualizar(Eventos.ACTUALIZAR_MANTENIMIENTO_OK, null);
            else
                factPres.hacerGUIRespuestaMantenimiento(evento).actualizar(Eventos.ACTUALIZAR_MANTENIMIENTO_KO, null);
            break;

        case Eventos.ELIMINAR_MANTENIMIENTO:
            res = factNeg.hacerSAMantenimiento().delete((int) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaMantenimiento(evento).actualizar(Eventos.ELIMINAR_MANTENIMIENTO_OK, null);
            else
                factPres.hacerGUIRespuestaMantenimiento(evento).actualizar(Eventos.ELIMINAR_MANTENIMIENTO_KO, null);
            break;

        case Eventos.MOSTRAR_MANTENIMIENTO:
            res = factNeg.hacerSAMantenimiento().read((int) o);
            if(res != null)
                factPres.hacerGUIRespuestaMantenimiento(evento).actualizar(Eventos.MOSTRAR_MANTENIMIENTO_OK, res);
            else
                factPres.hacerGUIRespuestaMantenimiento(evento).actualizar(Eventos.MOSTRAR_MANTENIMIENTO_KO, null);
            break;

        case Eventos.MOSTRAR_MANTENIMIENTOS:
            res = factNeg.hacerSAMantenimiento().readAll();
            if(res != null)
                factPres.hacerGUIRespuestaMantenimiento(evento).actualizar(Eventos.MOSTRAR_MANTENIMIENTOS_OK, res);
            else
                factPres.hacerGUIRespuestaMantenimiento(evento).actualizar(Eventos.MOSTRAR_MANTENIMIENTOS_KO, null);
            break;

        case Eventos.VINCULAR_MANTENIMIENTO:
            res = factNeg.hacerSAMantenimiento().vincularMantenimiento((int[]) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaMantenimiento(evento).actualizar(Eventos.VINCULAR_MANTENIMIENTO_OK, null);
            else
                factPres.hacerGUIRespuestaMantenimiento(evento).actualizar(Eventos.VINCULAR_MANTENIMIENTO_KO, null);
            break;

        case Eventos.DESVINCULAR_MANTENIMIENTO:
            res = factNeg.hacerSAMantenimiento().desvincularMantenimiento((int[]) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaMantenimiento(evento).actualizar(Eventos.DESVINCULAR_MANTENIMIENTO_OK, null);
            else
                factPres.hacerGUIRespuestaMantenimiento(evento).actualizar(Eventos.DESVINCULAR_MANTENIMIENTO_KO, null);
            break;

        case Eventos.MOSTRAR_MANTENIMIENTOS_DEL_CAMPO:
            res = factNeg.hacerSAMantenimiento().readMantenimientosDelCampo((int) o);
            if(res != null)
                factPres.hacerGUIRespuestaMantenimiento(evento).actualizar(Eventos.MOSTRAR_MANTENIMIENTOS_DEL_CAMPO_OK, res);
            else
                factPres.hacerGUIRespuestaMantenimiento(evento).actualizar(Eventos.MOSTRAR_MANTENIMIENTOS_DEL_CAMPO_KO, null);
            break;

        // Partido
        case Eventos.CREAR_PARTIDO:
            res = factNeg.hacerSAPartido().create((TPartido) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaPartido(evento).actualizar(Eventos.CREAR_PARTIDO_OK, res);
            else
                factPres.hacerGUIRespuestaPartido(evento).actualizar(Eventos.CREAR_PARTIDO_KO, null);
            break;

        case Eventos.ACTUALIZAR_PARTIDO:
            res = factNeg.hacerSAPartido().update((TPartido) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaPartido(evento).actualizar(Eventos.ACTUALIZAR_PARTIDO_OK, null);
            else
                factPres.hacerGUIRespuestaPartido(evento).actualizar(Eventos.ACTUALIZAR_PARTIDO_KO, null);
            break;

        case Eventos.ELIMINAR_PARTIDO:
            res = factNeg.hacerSAPartido().delete((int) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaPartido(evento).actualizar(Eventos.ELIMINAR_PARTIDO_OK, null);
            else
                factPres.hacerGUIRespuestaPartido(evento).actualizar(Eventos.ELIMINAR_PARTIDO_KO, null);
            break;

        case Eventos.MOSTRAR_PARTIDO:
            res = factNeg.hacerSAPartido().read((int) o);
            if(res != null)
                factPres.hacerGUIRespuestaPartido(evento).actualizar(Eventos.MOSTRAR_PARTIDO_OK, res);
            else
                factPres.hacerGUIRespuestaPartido(evento).actualizar(Eventos.MOSTRAR_PARTIDO_KO, null);
            break;

        case Eventos.MOSTRAR_PARTIDOS:
            res = factNeg.hacerSAPartido().readAll();
            if(res != null)
                factPres.hacerGUIRespuestaPartido(evento).actualizar(Eventos.MOSTRAR_PARTIDOS_OK, res);
            else
                factPres.hacerGUIRespuestaPartido(evento).actualizar(Eventos.MOSTRAR_PARTIDOS_KO, null);
            break;

        case Eventos.ADD_GOL_VISITANTE:
            res = factNeg.hacerSAPartido().addGolVisitante((int) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaPartido(evento).actualizar(Eventos.ADD_GOL_VISITANTE_OK, null);
            else
                factPres.hacerGUIRespuestaPartido(evento).actualizar(Eventos.ADD_GOL_VISITANTE_KO, null);
            break;

        case Eventos.ADD_GOL_LOCAL:
            res = factNeg.hacerSAPartido().addGolLocal((int) o);
            if((int) res > 0)
                factPres.hacerGUIRespuestaPartido(evento).actualizar(Eventos.ADD_GOL_LOCAL_OK, null);
            else
                factPres.hacerGUIRespuestaPartido(evento).actualizar(Eventos.ADD_GOL_LOCAL_KO, null);
            break;
            
		}
	}

}
