package presentacion;

public abstract class FactoriaPresentacion {
	
	private static FactoriaPresentacion instancia;
	
	public static FactoriaPresentacion getInstance(){
		if(instancia == null)
			instancia = new FactoriaPresentacionImp();
		return instancia;
	}
	
	public abstract IGUI hacerGUIRespuestaJugador(int evento);
	public abstract IGUI hacerGUIRespuestaEquipo(int evento);
	public abstract IGUI hacerGUIRespuestaPartido(int evento);
	public abstract IGUI hacerGUIRespuestaCampo(int evento);
	public abstract IGUI hacerGUIRespuestaEntrenador(int evento);
	public abstract IGUI hacerGUIRespuestaMantenimiento(int evento);
}
