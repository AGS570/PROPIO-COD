package presentacion;

public class Eventos{
	//casos de uso

	//Jugador
	public static final int CREAR_JUGADOR = 101;
	public static final int ACTUALIZAR_JUGADOR = 102;
	public static final int ELIMINAR_JUGADOR = 103;
	public static final int MOSTRAR_JUGADOR = 104;
	public static final int MOSTRAR_JUGADORES = 105;
	public static final int MOSTRAR_JUGADORES_DEL_EQUIPO = 106;
	
	//Campo
	public static final int CREAR_CAMPO = 107;
	public static final int ACTUALIZAR_CAMPO = 108;
	public static final int ELIMINAR_CAMPO = 109;
	public static final int MOSTRAR_CAMPO = 110;
	public static final int MOSTRAR_CAMPOS_DEL_MANTENIMIENTO = 111;
	public static final int MOSTRAR_CAMPOS = 112;

	//Entrenador
	public static final int CREAR_ENTRENADOR = 113;
	public static final int ACTUALIZAR_ENTRENADOR = 114;
	public static final int ELIMINAR_ENTRENADOR = 115;
	public static final int MOSTRAR_ENTRENADOR = 116;
	public static final int MOSTRAR_ENTRENADORES = 117;
	public static final int VINCULAR_ENTRENADOR = 118;
	public static final int DESVINCULAR_ENTRENADOR = 119;
	public static final int AÑADIR_EXPERIENCIA = 120;

	//Equipo
	public static final int CREAR_EQUIPO = 121;
	public static final int ACTUALIZAR_EQUIPO = 122;
	public static final int ELIMINAR_EQUIPO = 123;
	public static final int MOSTRAR_EQUIPO = 124;
	public static final int MOSTRAR_EQUIPOS = 125;
	public static final int VINCULAR_JUGADOR = 126;
	public static final int DESVINCULAR_JUGADOR = 127;
	public static final int MOSTRAR_EQUIPOS_DEL_JUGADOR = 128;

	//Mantenimiento
	public static final int CREAR_MANTENIMIENTO = 129;
	public static final int ACTUALIZAR_MANTENIMIENTO = 130;
	public static final int ELIMINAR_MANTENIMIENTO = 131;
	public static final int MOSTRAR_MANTENIMIENTO = 132;
	public static final int MOSTRAR_MANTENIMIENTOS = 133;
	public static final int VINCULAR_MANTENIMIENTO = 134;
	public static final int DESVINCULAR_MANTENIMIENTO = 135;
	public static final int MOSTRAR_MANTENIMIENTOS_DEL_CAMPO = 136;

	//Partido
	public static final int CREAR_PARTIDO = 137;
	public static final int ACTUALIZAR_PARTIDO = 138;
	public static final int ELIMINAR_PARTIDO = 139;
	public static final int MOSTRAR_PARTIDO = 140;
	public static final int MOSTRAR_PARTIDOS = 141;
	public static final int ADD_GOL_VISITANTE = 142;
	public static final int ADD_GOL_LOCAL = 143;


	//OK y KO de cada caso de uso

	//Jugador
	public static final int CREAR_JUGADOR_OK = 401;
	public static final int CREAR_JUGADOR_KO = 402;
	public static final int ACTUALIZAR_JUGADOR_OK = 403;
	public static final int ACTUALIZAR_JUGADOR_KO = 404;
	public static final int ELIMINAR_JUGADOR_OK = 405;
	public static final int ELIMINAR_JUGADOR_KO = 406;
	public static final int MOSTRAR_JUGADOR_OK = 407;
	public static final int MOSTRAR_JUGADOR_KO = 408;
	public static final int MOSTRAR_JUGADORES_OK = 409;
	public static final int MOSTRAR_JUGADORES_KO = 410;
	public static final int MOSTRAR_JUGADORES_DEL_EQUIPO_OK = 411;
	public static final int MOSTRAR_JUGADORES_DEL_EQUIPO_KO = 412;

	//Campo
	public static final int CREAR_CAMPO_OK = 413;
	public static final int CREAR_CAMPO_KO = 414;
	public static final int ACTUALIZAR_CAMPO_OK = 415;
	public static final int ACTUALIZAR_CAMPO_KO = 416;
	public static final int ELIMINAR_CAMPO_OK = 417;
	public static final int ELIMINAR_CAMPO_KO = 418;
	public static final int MOSTRAR_CAMPO_OK = 419;
	public static final int MOSTRAR_CAMPO_KO = 420;
	public static final int MOSTRAR_CAMPOS_DEL_MANTENIMIENTO_OK = 421;
	public static final int MOSTRAR_CAMPOS_DEL_MANTENIMIENTO_KO = 422;
	public static final int MOSTRAR_CAMPOS_OK = 423;
	public static final int MOSTRAR_CAMPOS_KO = 424;

	//Entrenador
	public static final int CREAR_ENTRENADOR_OK = 425;
	public static final int CREAR_ENTRENADOR_KO = 426;
	public static final int ACTUALIZAR_ENTRENADOR_OK = 427;
	public static final int ACTUALIZAR_ENTRENADOR_KO = 428;
	public static final int ELIMINAR_ENTRENADOR_OK = 429;
	public static final int ELIMINAR_ENTRENADOR_KO = 430;
	public static final int MOSTRAR_ENTRENADOR_OK = 431;
	public static final int MOSTRAR_ENTRENADOR_KO = 432;
	public static final int MOSTRAR_ENTRENADORES_OK = 433;
	public static final int MOSTRAR_ENTRENADORES_KO = 434;
	public static final int VINCULAR_ENTRENADOR_OK = 435;
	public static final int VINCULAR_ENTRENADOR_KO = 436;
	public static final int DESVINCULAR_ENTRENADOR_OK = 437;
	public static final int DESVINCULAR_ENTRENADOR_KO = 438;
	public static final int AÑADIR_EXPERIENCIA_OK = 439;
	public static final int AÑADIR_EXPERIENCIA_KO = 440;

	//Equipo
	public static final int CREAR_EQUIPO_OK = 441;
	public static final int CREAR_EQUIPO_KO = 442;
	public static final int ACTUALIZAR_EQUIPO_OK = 443;
	public static final int ACTUALIZAR_EQUIPO_KO = 444;
	public static final int ELIMINAR_EQUIPO_OK = 445;
	public static final int ELIMINAR_EQUIPO_KO = 446;
	public static final int MOSTRAR_EQUIPO_OK = 447;
	public static final int MOSTRAR_EQUIPO_KO = 448;
	public static final int MOSTRAR_EQUIPOS_OK = 449;
	public static final int MOSTRAR_EQUIPOS_KO = 450;
	public static final int VINCULAR_JUGADOR_OK = 451;
	public static final int VINCULAR_JUGADOR_KO = 452;
	public static final int DESVINCULAR_JUGADOR_OK = 453;
	public static final int DESVINCULAR_JUGADOR_KO = 454;
	public static final int MOSTRAR_EQUIPOS_DEL_JUGADOR_OK = 455;
	public static final int MOSTRAR_EQUIPOS_DEL_JUGADOR_KO = 456;

	//Mantenimiento
	public static final int CREAR_MANTENIMIENTO_OK = 457;
	public static final int CREAR_MANTENIMIENTO_KO = 458;
	public static final int ACTUALIZAR_MANTENIMIENTO_OK = 459;
	public static final int ACTUALIZAR_MANTENIMIENTO_KO = 460;
	public static final int ELIMINAR_MANTENIMIENTO_OK = 461;
	public static final int ELIMINAR_MANTENIMIENTO_KO = 462;
	public static final int MOSTRAR_MANTENIMIENTO_OK = 463;
	public static final int MOSTRAR_MANTENIMIENTO_KO = 464;
	public static final int MOSTRAR_MANTENIMIENTOS_OK = 465;
	public static final int MOSTRAR_MANTENIMIENTOS_KO = 466;
	public static final int VINCULAR_MANTENIMIENTO_OK = 467;
	public static final int VINCULAR_MANTENIMIENTO_KO = 468;
	public static final int DESVINCULAR_MANTENIMIENTO_OK = 469;
	public static final int DESVINCULAR_MANTENIMIENTO_KO = 470;
	public static final int MOSTRAR_MANTENIMIENTOS_DEL_CAMPO_OK = 471;
	public static final int MOSTRAR_MANTENIMIENTOS_DEL_CAMPO_KO = 472;

	//Partido
	public static final int CREAR_PARTIDO_OK = 473;
	public static final int CREAR_PARTIDO_KO = 474;
	public static final int ACTUALIZAR_PARTIDO_OK = 475;
	public static final int ACTUALIZAR_PARTIDO_KO = 476;
	public static final int ELIMINAR_PARTIDO_OK = 477;
	public static final int ELIMINAR_PARTIDO_KO = 478;
	public static final int MOSTRAR_PARTIDO_OK = 479;
	public static final int MOSTRAR_PARTIDO_KO = 480;
	public static final int MOSTRAR_PARTIDOS_OK = 481;
	public static final int MOSTRAR_PARTIDOS_KO = 482;
	public static final int ADD_GOL_VISITANTE_OK = 483;
	public static final int ADD_GOL_VISITANTE_KO = 484;
	public static final int ADD_GOL_LOCAL_OK = 485;
	public static final int ADD_GOL_LOCAL_KO = 486;
}
