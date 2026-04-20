package presentacion;

public abstract class FactoriaPresentacion {
	
	private static FactoriaPresentacion instancia;
	
	public static FactoriaPresentacion getInstance(){
		if(instancia == null)
			instancia = new FactoriaPresentacionImp();
		return instancia;
	}
	
	public abstract IGUI hacerGUIRespuestaPelicula(int codigo);
	public abstract IGUI hacerGUIRespuestaSala(int codigo);
	public abstract IGUI hacerGUIRespuestaEmpleado(int codigo);
	public abstract IGUI hacerGUIRespuestaProyeccion(int codigo);
	public abstract IGUI hacerGUIRespuestaVenta(int codigo);
}
