package Presentacion.Campos;

public class EventosCampo {
    // Eventos de petición
    public static final int CREAR_CAMPO = 101;
    public static final int ELIMINAR_CAMPO = 102;
    public static final int ACTUALIZAR_CAMPO = 103;
    public static final int MOSTRAR_CAMPO = 104;
    public static final int MOSTRAR_CAMPOS = 105;
    public static final int MOSTRAR_CAMPOS_MANTENIMIENTO = 106;

    // Eventos de respuesta (Resultados)
    public static final int CREAR_CAMPO_OK = 201;
    public static final int CREAR_CAMPO_KO = 202;
    public static final int ELIMINAR_CAMPO_OK = 203;
    public static final int ELIMINAR_CAMPO_KO = 204;
    public static final int ACTUALIZAR_CAMPO_OK = 205;
    public static final int ACTUALIZAR_CAMPO_KO = 206;
    public static final int MOSTRAR_CAMPO_OK = 207;
    public static final int MOSTRAR_CAMPO_KO = 208;
    public static final int MOSTRAR_CAMPOS_OK = 209;
    public static final int MOSTRAR_CAMPOS_KO = 210;
    public static final int MOSTRAR_CAMPOS_MANTENIMIENTO_OK = 211;
    public static final int MOSTRAR_CAMPOS_MANTENIMIENTO_KO = 212;

    // Alias legacy para compatibilidad con clases antiguas
    public static final int MOSTRAR_TODOS = MOSTRAR_CAMPOS;
    public static final int CREAR_OK = CREAR_CAMPO_OK;
    public static final int CREAR_KO = CREAR_CAMPO_KO;
    public static final int ELIMINAR_OK = ELIMINAR_CAMPO_OK;
    public static final int ELIMINAR_KO = ELIMINAR_CAMPO_KO;
    public static final int ACTUALIZAR_OK = ACTUALIZAR_CAMPO_OK;
    public static final int ACTUALIZAR_KO = ACTUALIZAR_CAMPO_KO;
}
