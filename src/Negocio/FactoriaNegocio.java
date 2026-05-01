package Negocio;

import Negocio.NegocioJugador.SA_Jugador;

public abstract class FactoriaNegocio {
private static FactoriaNegocio instancia;
	
	public static FactoriaNegocio getInstance(){
		if(instancia == null)
			instancia = new FactoriaNegocioImp();
		return instancia;
	}
	
	public abstract SA_Jugador hacerSAJugador();
	public abstract SA_Equipo hacerSAEquipo();
	public abstract SA_Entrenador hacerSAEntrenador();
	public abstract SA_Partido hacerSAPartido();
	public abstract SA_Campo hacerSACampo();
	public abstract SA_Mantenimiento hacerSAMantenimiento();
}

